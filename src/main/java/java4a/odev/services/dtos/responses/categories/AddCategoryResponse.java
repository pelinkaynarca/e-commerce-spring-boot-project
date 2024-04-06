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
public class AddCategoryResponse {
    private String name;

    private LocalDateTime createdAt;

    private int parentId;

    }

