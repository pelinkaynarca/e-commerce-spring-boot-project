package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.users.AddUserRequest;
import java4a.odev.services.dtos.requests.users.UpdateUserRequest;
import java4a.odev.services.dtos.responses.users.AddUserResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import java4a.odev.services.dtos.responses.users.UpdateUserResponse;

import java.util.List;

public interface UserService {
    List<ListUserResponse> getAll();
    ListUserResponse getById(int id);
    AddUserResponse add(AddUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    void delete(int id);
}
