package java4a.odev.services.dtos.responses.addresses;

import java4a.odev.services.dtos.responses.cities.ListCityResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddAddressResponse {
    private int id;

    private String description;

    private int postalCode;

    private ListCityResponse listCityResponse;

    private ListUserResponse listUserResponse;


}
