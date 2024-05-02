package shoppingcart.basket.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoppingcart.basket.model.dto.BasketCheckoutDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckoutBasketRequest {
    private BasketCheckoutDto basketCheckoutDto;
}
