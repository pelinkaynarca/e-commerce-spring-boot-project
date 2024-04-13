package java4a.odev.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleName {
    CUSTOMER(1),
    ADMIN(2);
	
	private final int roleId;
}
