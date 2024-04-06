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
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotBlank(message = "Şehir kısmı boş olamaz.")
    @Size(min=2, max=50, message = "Şehir 2 ile 50 karakter arasında olmalıdır.")
    private String name;

    @Min(value=0, message = "Ülke numarası 0'dan küçük değer alamaz.")
    private int countryId;
}
