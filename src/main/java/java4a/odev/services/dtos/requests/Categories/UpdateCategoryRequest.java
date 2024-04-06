package java4a.odev.services.dtos.requests.Categories;

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
public class UpdateCategoryRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Kategori adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @NotNull(message = "Oluşturma tarihi boş olamaz.")
    @PastOrPresent(message = "Oluşturma tarihi geçmiş veya şu anki zaman olmalıdır.")
    private LocalDateTime modifiedAt;

    @Min(value=0, message = "parentId 0'dan küçük değer alamaz.")
    private int parentId;
}
