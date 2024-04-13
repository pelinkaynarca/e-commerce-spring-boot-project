package java4a.odev.services.dtos.responses.users;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListUserResponse {

	private int id;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	private String phone;

	private Set<String> roles;
}
