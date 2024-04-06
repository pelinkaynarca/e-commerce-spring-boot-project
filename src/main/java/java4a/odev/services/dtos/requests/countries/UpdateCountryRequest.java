package java4a.odev.services.dtos.requests.countries;

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
public class UpdateCountryRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Ülke adı 2 ile 50 karakter arasında olmalıdır.")
    private String name;
}
