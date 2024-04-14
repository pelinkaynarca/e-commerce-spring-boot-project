package java4a.odev.services.dtos.requests.products;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min = 2, max = 100, message = "Ürün adı 2 ile 100 karakter arasında olmalıdır.")
    private String name;

    @Positive(message = "Fiyat değeri sıfırdan büyük olmalıdır.")
    private double unitPrice;

    private String description;

    @Min(value = 1, message = "Ürün miktarı 1'den küçük olamaz.")
    private int stockQuantity;

    @Min(value = 1, message = "Geçerli bir kategori ID'si belirtilmelidir.")
    private int categoryId;
}
