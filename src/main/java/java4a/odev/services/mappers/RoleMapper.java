package java4a.odev.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java4a.odev.entities.Role;
import java4a.odev.entities.RoleName;

@Mapper
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

	@Mapping(target = "id", expression = "java((short) roleName.getRoleId())")
	@Mapping(target = "name", expression = "java(roleName)")
	Role roleFromRoleName(RoleName roleName);
}
