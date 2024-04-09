package java4a.odev.services.dtos.responses.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListImageResponse {

    private int id;

    private String imageUrl;


	private String productName;

}
