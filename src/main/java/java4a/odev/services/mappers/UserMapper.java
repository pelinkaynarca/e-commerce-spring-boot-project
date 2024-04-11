package java4a.odev.services.mappers;


import java4a.odev.entities.User;
import java4a.odev.services.dtos.requests.users.AddUserRequest;
import java4a.odev.services.dtos.requests.users.UpdateUserRequest;
import java4a.odev.services.dtos.responses.users.AddUserResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import java4a.odev.services.dtos.responses.users.UpdateUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ListUserResponse listResponseFromUser(User user);
    User userFromAddRequest(AddUserRequest request);
    AddUserResponse addResponseFromUser(User user);
    User userFromUpdateRequest(UpdateUserRequest request);
    UpdateUserResponse updateResponseFromUser(User user);
    List<ListUserResponse> toListUserResponseList(List<User> users);


}
