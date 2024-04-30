package shoppingcart.basket.model.response;

import lombok.Builder;
import lombok.Data;
import shoppingcart.basket.model.ShoppingCart;

@Builder
@Data
public class GetBasketResponse {
    private ShoppingCart shoppingCart;
}
