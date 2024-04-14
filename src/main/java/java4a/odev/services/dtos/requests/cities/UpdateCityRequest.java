package java4a.odev.services.dtos.requests.cities;

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
public class UpdateCityRequest {
    @Min(value = 1, message = "Geçerli bir ID numarası girilmelidir.")
    private int id;

    @NotBlank(message = "Şehir Adı boş bırakılamaz.")
    @Size(min = 2, max = 50, message = "Şehir ismi 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @Min(value = 1, message = "Ülke ID'si 1'den küçük veya eşit olamaz.")
    private int countryId;
}
