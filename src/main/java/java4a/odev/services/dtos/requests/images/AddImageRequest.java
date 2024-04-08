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
public class AddImageRequest {
    @NotBlank(message = "Ürün fotoğrafının url kısmı boş olamaz.")
    private String imageUrl;

    @Min(value=1, message = "Ürün ID'si 0'dan küçük değer alamaz.")
    private int productId;
}
