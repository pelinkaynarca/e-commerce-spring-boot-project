package java4a.odev.services.dtos.requests.Products;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Ürün adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @NotNull(message = "Oluşturma tarihi boş olamaz.")
    @PastOrPresent(message = "Oluşturma tarihi geçmiş veya şu anki zaman olmalıdır.")
    private LocalDateTime createdAt;

    @Positive(message = "Fiyat değeri sıfırdan büyük olmalıdır.")
    private double unitPrice;

    @NotBlank(message = "Ürün açıklaması boş olamaz.")
    private String description;

    @Min(value=0, message = "Ürün miktarı sıfırdan büyük olmalıdır.")
    private int stockQuantity;

    @Min(value=0, message = "Kategori numarası 0'dan küçük değer alamaz.")
    private int categoryId;
}
