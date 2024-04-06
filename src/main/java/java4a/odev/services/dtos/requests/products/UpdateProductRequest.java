package java4a.odev.services.dtos.requests.products;

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
public class UpdateProductRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Ürün adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @Positive(message = "Fiyat değeri sıfırdan büyük olmalıdır.")
    private double unitPrice;

    @NotBlank(message = "Ürün açıklaması boş olamaz.")
    private String description;

    @Min(value=0, message = "Ürün miktarı sıfırdan büyük olmalıdır.")
    private int stockQuantity;

    @Min(value=0, message = "Kategori numarası 0'dan küçük değer alamaz.")
    private int categoryId;
}
