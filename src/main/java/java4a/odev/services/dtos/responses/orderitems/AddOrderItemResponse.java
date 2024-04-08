package java4a.odev.services.dtos.responses.orderitems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemResponse {

    private int id;

    private int quantity;

    private double totalPrice;

    private int orderId;

    private int productId;
    
    private String productName;
    
}
