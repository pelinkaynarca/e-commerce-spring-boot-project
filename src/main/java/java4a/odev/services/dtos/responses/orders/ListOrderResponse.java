package java4a.odev.services.dtos.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderResponse {

	private int id;

	private LocalDateTime createdAt;

	private int userId;

	private String userFirstName;

	private String userLastName;

	private List<String> productNames;

	private double orderTotal;

}
