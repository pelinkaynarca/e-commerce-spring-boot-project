package java4a.odev.services.dtos.requests.categories;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
    @Min(value=1, message = "Lütfen geçerli bir ID numarası girin.")
    private int id;

    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Kategori adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @Min(value=1, message = "parentId 0'dan küçük değer alamaz.")
    private int parentId;
}
