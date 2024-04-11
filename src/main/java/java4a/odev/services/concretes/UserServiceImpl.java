package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.User;
import java4a.odev.repositories.UserRepository;
import java4a.odev.services.abstracts.UserService;
import java4a.odev.services.dtos.requests.users.AddUserRequest;
import java4a.odev.services.dtos.requests.users.UpdateUserRequest;
import java4a.odev.services.dtos.responses.users.AddUserResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import java4a.odev.services.dtos.responses.users.UpdateUserResponse;

import java4a.odev.services.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.toListUserResponseList(users);
    }
    @Override
    public ListUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BusinessException("User not found with id: " + id));
        return UserMapper.INSTANCE.listResponseFromUser(user);
    }
    @Override
    public AddUserResponse add(AddUserRequest request) {
        User user = UserMapper.INSTANCE.userFromAddRequest(request);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.addResponseFromUser(user);
    }
    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
       userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("User not found with id: " + request.getId()));
       User user;
       user = UserMapper.INSTANCE.userFromUpdateRequest(request);
        user = userRepository.save(user);

        UpdateUserResponse updateUserResponse = UserMapper.INSTANCE.updateResponseFromUser(user);
        return updateUserResponse;
    }
    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }
}

