package java4a.odev.services.dtos.responses.cities;

import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
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
