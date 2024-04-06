package java4a.odev.services.dtos.responses.Address;

import java4a.odev.services.dtos.responses.City.ListCityResponse;
import java4a.odev.services.dtos.responses.User.ListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ListAddressResponse {

    private int id;

    private String description;

    private int postalCode;

    private ListCityResponse listCityResponse;

    private ListUserResponse listUserResponse;
}
