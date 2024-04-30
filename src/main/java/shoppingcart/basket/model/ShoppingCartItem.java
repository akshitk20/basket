package shoppingcart.basket.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartItem {
    private int quantity;
    private String color;
    private BigDecimal price;
    private String productId;
    private String productName;
}
