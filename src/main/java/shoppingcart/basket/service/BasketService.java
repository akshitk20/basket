package shoppingcart.basket.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import shoppingcart.basket.model.ShoppingCart;
import shoppingcart.basket.model.request.StoreBasketRequest;
import shoppingcart.basket.model.response.GetBasketResponse;
import shoppingcart.basket.model.response.StoreBasketResponse;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {

    private final RedisTemplate<String, ShoppingCart> redisTemplate;

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
        redisTemplate.opsForValue().set(shoppingCart.getUserName(), storeBasketRequest.getShoppingCart());
        return StoreBasketResponse.builder()
                .userName(shoppingCart.getUserName())
                .build();
    }
}
