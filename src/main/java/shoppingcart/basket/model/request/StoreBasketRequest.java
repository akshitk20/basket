package shoppingcart.basket.model.request;

import lombok.Data;
import shoppingcart.basket.model.ShoppingCart;

@Data
public class StoreBasketRequest {
    private ShoppingCart shoppingCart;
}
