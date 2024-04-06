package java4a.odev.services.dtos.responses.images;

import java4a.odev.services.dtos.responses.products.ListProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AddImageResponse {
    private int id;

    private String imageUrl;

    private ListProductResponse listProductResponse;
}
