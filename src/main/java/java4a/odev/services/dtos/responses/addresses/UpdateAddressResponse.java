package java4a.odev.services.dtos.responses.addresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddressResponse {

    private int id;

    private String description;

    private int postalCode;

    private String cityName;

	private String countryName;

	private String userFirstName;

	private String userLastName;
	
}
