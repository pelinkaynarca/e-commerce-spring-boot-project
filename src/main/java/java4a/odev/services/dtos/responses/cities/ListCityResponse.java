package java4a.odev.services.dtos.responses.cities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCityResponse {

	private int id;

	private String name;

	private int countryId;

	private String countryName;

}
