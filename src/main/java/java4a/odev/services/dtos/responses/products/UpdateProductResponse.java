package java4a.odev.services.dtos.responses.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {

	private int id;

	private String name;

	private double unitPrice;

	private int stockQuantity;

	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;

	private String description;

	private int categoryId;

	private String categoryName;

}
