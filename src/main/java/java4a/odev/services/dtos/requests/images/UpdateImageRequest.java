package java4a.odev.services.dtos.requests.images;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateImageRequest {
    @Min(value = 1, message = "Geçerli bir ID numarası girilmelidir.")
    private int id;

    @NotBlank(message = "Ürün fotoğrafı URL'si boş olamaz.")
    private String imageUrl;

    @Min(value = 1, message = "Geçerli bir ürün ID'si belirtilmelidir.")
    private int productId;
}
