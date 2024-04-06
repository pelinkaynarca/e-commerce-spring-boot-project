package java4a.odev.services.dtos.responses.Order;

import java4a.odev.services.dtos.responses.User.ListUserResponse;
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

    private ListUserResponse listUserResponse;
}
