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
public class AddCategoryRequest {
    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Kategori adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;


    @PositiveOrZero(message = "parentId pozitif veya sıfır olmalıdır.")
    private Integer parentId;

}
