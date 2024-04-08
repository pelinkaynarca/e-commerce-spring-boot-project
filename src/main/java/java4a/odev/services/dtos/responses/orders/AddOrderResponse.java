package java4a.odev.services.dtos.responses.orders;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderResponse {

	private int id;

	private LocalDateTime createdAt;

	private int userId;

	private String userFirstName;

	private String userLastName;

}
