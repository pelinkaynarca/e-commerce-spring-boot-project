package java4a.odev.services.dtos.requests.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    @Size(min=2, max=50, message = "İsim 2 ile 50 karakter arasında olmalıdır.")
    private String firstName;

    @Size(min=2, max=50, message = "Soyisim 2 ile 50 karakter arasında olmalıdır.")
    private String lastName;

    @Size(min=2, max=50, message = "Kullanıcı adı 2 ile 50 karakter arasında olmalıdır.")
    private String userName;

    @Email(message = "Geçersiz email formatı. Lütfen doğru bir email giriniz.")
    @Size(min=2, max=50, message = "Ürün adı 2 ile 50 karakter arasında olmalıdır.")
    private String email;

    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;

    @Size(min=2, max=20, message = "Şifre 2 ile 20 karakter arasında olmalıdır.")
    private String password;
}
