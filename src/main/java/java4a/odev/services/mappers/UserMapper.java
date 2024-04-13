package java4a.odev.services.mappers;

import java4a.odev.entities.Role;
import java4a.odev.entities.RoleName;
import java4a.odev.entities.User;
import java4a.odev.services.dtos.requests.users.AddUserRequest;
import java4a.odev.services.dtos.requests.users.UpdateUserRequest;
import java4a.odev.services.dtos.responses.users.AddUserResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import java4a.odev.services.dtos.responses.users.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(target = "roles", expression = "java(toStringSetFromRoleSet(user.getRoles()))")
	ListUserResponse listResponseFromUser(User user);

	@Mapping(target = "roles", expression = "java(toRoleSetFromRoleNameList(request.getRoles()))")
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "cartItems", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orders", ignore = true)
	User userFromAddRequest(AddUserRequest request);

	@Mapping(target = "roles", expression = "java(toStringSetFromRoleSet(user.getRoles()))")
	AddUserResponse addResponseFromUser(User user);

	@Mapping(target = "roles", expression = "java(toRoleSetFromRoleNameList(request.getRoles()))")
	@Mapping(target = "addresses", ignore = true)
	@Mapping(target = "cartItems", ignore = true)
	@Mapping(target = "orders", ignore = true)
	User userFromUpdateRequest(UpdateUserRequest request);

	@Mapping(target = "roles", expression = "java(toStringSetFromRoleSet(user.getRoles()))")
	UpdateUserResponse updateResponseFromUser(User user);

	default Set<Role> toRoleSetFromRoleNameList(List<RoleName> roleNames) {
		if (roleNames == null) {
			return null;
		}
		return roleNames.stream().map((RoleName roleName) -> RoleMapper.INSTANCE.roleFromRoleName(roleName))
				.collect(Collectors.toSet());
	}

	default Set<String> toStringSetFromRoleSet(Set<Role> roles) {
		if (roles == null) {
			return null;
		}
		return roles.stream().map((Role role) -> role.getName().toString()).collect(Collectors.toSet());
	}
}
