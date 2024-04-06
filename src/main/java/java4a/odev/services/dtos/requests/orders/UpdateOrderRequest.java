package java4a.odev.services.dtos.requests.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    @Min(value=0, message = "Kimlik numarası 0'dan küçük değer alamaz.")
    private int id;

    @NotNull(message = "Oluşturma tarihi boş olamaz.")
    @PastOrPresent(message = "Oluşturma tarihi geçmiş veya şu anki zaman olmalıdır.")
    private LocalDateTime createdAt;

    @Min(value=0, message = "Kullanıcı numarası 0'dan küçük değer alamaz.")
    private int userId;
}
