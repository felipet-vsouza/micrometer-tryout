package felipetvsouza.github.micrometertryout.service;

import felipetvsouza.github.micrometertryout.request.CloseOrderRequest;
import felipetvsouza.github.micrometertryout.response.BaseResponse;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class OrderService {

    private static final String TOTAL_ORDERS = "TOTAL_ORDERS";
    private static final String TOTAL_SOLD = "TOTAL_SOLD";

    private final AtomicReference<BigDecimal> totalSold = new AtomicReference<>(BigDecimal.ZERO);

    private final MeterRegistry meterRegistry;

    public OrderService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        meterRegistry.gauge(TOTAL_SOLD, totalSold, sold -> sold.get().doubleValue());
    }

    public Mono<BaseResponse<String>> closeOrder(CloseOrderRequest request) {
        return Mono.just(request)
                .doOnNext(req -> log.info("Closing order with id {}", req.getOrderId()))
                .doOnNext(req -> totalSold.getAndUpdate(current -> current.add(req.getTotalValue())))
                .doOnNext(req -> meterRegistry.counter(TOTAL_ORDERS).increment())
                .map(req -> {
                    var totalSoldString = String.format("Total sold: %s", totalSold.get().toPlainString());
                    return BaseResponse.build(totalSoldString);
                });
    }
}
