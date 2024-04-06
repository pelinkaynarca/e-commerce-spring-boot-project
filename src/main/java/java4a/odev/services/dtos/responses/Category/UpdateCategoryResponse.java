package java4a.odev.services.dtos.responses.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryResponse {
    private int id;
    private String name;
    private int parentId;
    private LocalDateTime createdAt;

}
