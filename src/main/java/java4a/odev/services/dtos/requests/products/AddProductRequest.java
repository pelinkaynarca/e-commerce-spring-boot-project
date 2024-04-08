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
    @Size(min=2, max=100, message = "Ürün adı 2 ile 100 karakter arasında olmalıdır.")
    private String name;

    @Positive(message = "Fiyat değeri sıfırdan büyük olmalıdır.")
    private double unitPrice;

    private String description;

    @Min(value=1, message = "Ürün miktarı sıfırdan büyük olmalıdır.")
    private int stockQuantity;

    @Min(value=1, message = "Kategori ID'si 0'dan küçük değer alamaz.")
    private int categoryId;
}
