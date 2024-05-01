package shoppingcart.basket.model.request;

import lombok.Builder;
import lombok.Data;
import shoppingcart.basket.model.dto.BasketCheckoutDto;

@Data
@Builder
public class CheckoutBasketRequest {
    private BasketCheckoutDto basketCheckoutDto;
}
