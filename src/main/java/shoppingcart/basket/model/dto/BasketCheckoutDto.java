package shoppingcart.basket.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
public class BasketCheckoutDto {
    private String userName;
    private UUID customerId;
    private BigDecimal totalPrice;

    // shipping and billing address
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String addressLine;
    private String country;
    private String state;
    private String zipCode;

    // payment
    private String cardName;
    private String cardNumber;
    private String expiration;
    private String cvv;
    private int paymentMethod;
}
