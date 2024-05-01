package shoppingcart.basket.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteResponse {
    private boolean isSuccess;
}
