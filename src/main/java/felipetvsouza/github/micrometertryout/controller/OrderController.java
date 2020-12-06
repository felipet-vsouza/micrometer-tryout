package felipetvsouza.github.micrometertryout.controller;

import felipetvsouza.github.micrometertryout.request.CloseOrderRequest;
import felipetvsouza.github.micrometertryout.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/order")
@RestController
@Slf4j
public class OrderController {

    private static BigDecimal totalSold = BigDecimal.ZERO;

    @PostMapping("/close")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse<String> closeOrder(@RequestBody CloseOrderRequest request) {
        log.info("Closing order with id {}", request.getOrderId());
        totalSold = totalSold.add(request.getTotalValue());

        var totalSoldString = String.format("Total sold: %s", totalSold.toPlainString());
        return BaseResponse.build(totalSoldString);
    }

}
