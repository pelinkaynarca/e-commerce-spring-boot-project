package java4a.odev.services.dtos.responses.cartitems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartItemResponse {

	private int id;

	private int quantity;

	private String userFirstName;

	private String userLastName;

	private String productName;

}
