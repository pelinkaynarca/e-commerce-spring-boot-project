package java4a.odev.services.dtos.requests.addresses;

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
public class AddAddressRequest {

    @NotBlank(message = "Ürün adı boş olamaz.")
    @Size(min=2, max=50, message = "Adres 2 ile 50 karakter arasında olmalıdır.")
    private String description;

    @Min(value=0, message = "cityId 0'dan küçük değer alamaz.")
    private int postalCode;

    @Min(value=0, message = "cityId 0'dan küçük değer alamaz.")
    private int cityId;

    @Min(value=0, message = "userId 0'dan küçük değer alamaz.")
    private int userId;
}
