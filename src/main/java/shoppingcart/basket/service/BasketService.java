package shoppingcart.basket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import shoppingcart.basket.model.ShoppingCart;
import shoppingcart.basket.model.request.StoreBasketRequest;
import shoppingcart.basket.model.response.DeleteResponse;
import shoppingcart.basket.model.response.GetBasketResponse;
import shoppingcart.basket.model.response.StoreBasketResponse;
import shoppingcart.discount.CouponModel;
import shoppingcart.discount.DiscountProtoServiceGrpc;
import shoppingcart.discount.GetDiscountRequest;

import java.math.BigDecimal;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {

    private final RedisTemplate<String, ShoppingCart> redisTemplate;

    @GrpcClient("discount-service")
    DiscountProtoServiceGrpc.DiscountProtoServiceBlockingStub client;

    public GetBasketResponse getBasket(String userName) {
        ShoppingCart shoppingCart = redisTemplate.opsForValue().get(userName);
        if (Objects.isNull(shoppingCart)) {
            return GetBasketResponse.builder()
                    .shoppingCart(null)
                    .build();
        }
        log.info("Successfully fetched value");
        return GetBasketResponse.builder()
                .shoppingCart(shoppingCart)
                .build();
    }

    public StoreBasketResponse storeBasket(StoreBasketRequest storeBasketRequest) {
        ShoppingCart shoppingCart = storeBasketRequest.getShoppingCart();
        BigDecimal totalAmount = BigDecimal.ZERO;
        shoppingCart.getItems().forEach(c -> {
            GetDiscountRequest getDiscountRequest = GetDiscountRequest.newBuilder()
                    .setProductName(c.getProductName())
                    .build();
            CouponModel discount = client.getDiscount(getDiscountRequest);
            log.info("response from grpc service {}", discount);
            totalAmount.add(c.getPrice().subtract(BigDecimal.valueOf(discount.getAmount())));
        });
        log.info("Total amount calculated {}", totalAmount);
        shoppingCart.setTotalPrice(totalAmount);

        redisTemplate.opsForValue().set(shoppingCart.getUserName(), storeBasketRequest.getShoppingCart());
        return StoreBasketResponse.builder()
                .userName(shoppingCart.getUserName())
                .build();
    }

    public DeleteResponse deleteBasket(String userName) {
        log.info("deleting userName {} ", userName);
        Boolean deleted = redisTemplate.delete(userName);
        return DeleteResponse.builder()
                .isSuccess(Boolean.TRUE.equals(deleted))
                .build();
    }
}
