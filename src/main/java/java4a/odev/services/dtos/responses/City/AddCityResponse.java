package java4a.odev.services.dtos.responses.City;

import java4a.odev.services.dtos.responses.Country.ListCountryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddCityResponse {

    private int id;

    private String name;

    private ListCountryResponse listCountryResponse;
}
