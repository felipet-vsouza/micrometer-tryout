package felipetvsouza.github.micrometertryout.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CloseOrderRequest {

    private String orderId;

    private BigDecimal totalValue;

}
