package java4a.odev.services.dtos.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryResponse {

	private int id;

	private String name;

	private int parentId;

	private LocalDateTime createdAt;

	private LocalDateTime modifiedAt;

	private List<ListCategoryResponse> children;

}
