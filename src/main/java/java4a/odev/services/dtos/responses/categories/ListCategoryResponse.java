package java4a.odev.services.dtos.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryResponse {
    private int id;
    private String name;
    private Integer parentId;
    private LocalDateTime createdAt;
}
