package shoppingcart.basket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private String userName;
    private List<ShoppingCartItem> items;
    private BigDecimal totalPrice;

    public ShoppingCart(String userName) {
        this.userName = userName;
    }
}
