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
    @Min(value=1, message = "Lütfen geçerli bir ID numarası girin.")
    private int id;

    @NotBlank(message = "Boş bırakılamaz.")
    @Size(min=2, max=50, message = "İsim 2 ile 100 karakter arasında olmalıdır.")
    private String firstName;

    @NotBlank(message = "Boş bırakılamaz.")
    @Size(min=2, max=100, message = "Soyisim 2 ile 100 karakter arasında olmalıdır.")
    private String lastName;

    @NotBlank(message = "Boş bırakılamaz.")
    @Size(min=2, max=100, message = "Kullanıcı adı 2 ile 100 karakter arasında olmalıdır.")
    private String username;

    @NotBlank(message = "Boş bırakılamaz.")
    @Email(message = "Geçersiz email formatı. Lütfen doğru bir email giriniz.")
    @Size(min=6, max=100, message = "E-posta 2 ile 100 karakter arasında olmalıdır.")
    private String email;

    @NotBlank(message = "Boş bırakılamaz.")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @NotBlank(message = "Boş bırakılamaz.")
    @Size(min=6, message = "Şifre en az 6 karakterden oluşmalıdır.")
    private String password;
    
    private List<RoleName> roles;
}
