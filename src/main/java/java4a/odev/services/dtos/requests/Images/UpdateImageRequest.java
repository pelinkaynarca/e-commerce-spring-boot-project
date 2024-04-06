package java4a.odev.services.dtos.requests.Images;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateImageRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotBlank(message = "Ürün fotoğrafının url kısmı boş olamaz.")
    @Size(min=2, max=255, message = "Ürün fotoğrafının url uzunluğu 2 ile 255 karakter arasında olmalıdır.")
    private String imageUrl;

    @Min(value=0, message = "Ürün numarası 0'dan küçük değer alamaz.")
    private int productId;
}
