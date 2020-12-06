package felipetvsouza.github.micrometertryout.controller;

import felipetvsouza.github.micrometertryout.request.CloseOrderRequest;
import felipetvsouza.github.micrometertryout.response.BaseResponse;
import felipetvsouza.github.micrometertryout.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/close")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BaseResponse<String>> closeOrder(@RequestBody CloseOrderRequest request) {
        return orderService.closeOrder(request);
    }

}
