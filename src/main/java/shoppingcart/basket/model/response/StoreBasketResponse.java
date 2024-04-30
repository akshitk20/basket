package shoppingcart.basket.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreBasketResponse {
    private String userName;
}
