package shoppingcart.basket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shoppingcart.basket.model.request.StoreBasketRequest;
import shoppingcart.basket.model.response.DeleteResponse;
import shoppingcart.basket.model.response.GetBasketResponse;
import shoppingcart.basket.model.response.StoreBasketResponse;
import shoppingcart.basket.service.BasketService;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    @GetMapping("/{userName}")
    public ResponseEntity<GetBasketResponse> getBasket(@PathVariable String userName) {
        return ResponseEntity.ok(basketService.getBasket(userName));
    }

    @PostMapping
    public ResponseEntity<StoreBasketResponse> storeBasket(@RequestBody StoreBasketRequest storeBasketRequest) {
        return ResponseEntity.ok(basketService.storeBasket(storeBasketRequest));
    }

    @DeleteMapping("/delete/{userName}")
    public ResponseEntity<DeleteResponse> deleteBasket(@PathVariable String userName) {
        return ResponseEntity.ok(basketService.deleteBasket(userName));
    }
}
