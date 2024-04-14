package java4a.odev.services.dtos.requests.users;

import java.util.List;

import jakarta.validation.constraints.*;
import java4a.odev.entities.RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
    @Min(value = 1, message = "Geçerli bir ID numarası girilmelidir.")
    private int id;

    @NotBlank(message = "İsim boş bırakılamaz.")
    @Size(min = 2, max = 50, message = "İsim 2 ile 50 karakter arasında olmalıdır.")
    private String firstName;

    @NotBlank(message = "Soyisim boş bırakılamaz.")
    @Size(min = 2, max = 100, message = "Soyisim 2 ile 100 karakter arasında olmalıdır.")
    private String lastName;

    @NotBlank(message = "Kullanıcı adı boş bırakılamaz.")
    @Size(min = 2, max = 100, message = "Kullanıcı adı 2 ile 100 karakter arasında olmalıdır.")
    private String username;

    @NotBlank(message = "E-posta boş bırakılamaz.")
    @Email(message = "Geçersiz e-posta formatı. Lütfen doğru bir e-posta giriniz.")
    @Size(min = 6, max = 100, message = "E-posta 6 ile 100 karakter arasında olmalıdır.")
    private String email;

    @NotBlank(message = "Telefon numarası boş bırakılamaz.")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Geçersiz telefon numarası formatı. Lütfen 10 haneli bir numara giriniz.")
    private String phone;

    @NotBlank(message = "Şifre boş bırakılamaz.")
    @Size(min = 6, message = "Şifre en az 6 karakterden oluşmalıdır.")
    private String password;
    
    private List<RoleName> roles;
}
