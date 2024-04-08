package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.abstracts.UserService;
import java4a.odev.services.dtos.requests.users.AddUserRequest;
import java4a.odev.services.dtos.requests.users.UpdateUserRequest;
import java4a.odev.services.dtos.responses.users.AddUserResponse;
import java4a.odev.services.dtos.responses.users.ListUserResponse;
import java4a.odev.services.dtos.responses.users.UpdateUserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @GetMapping("/get-all")
    public List<ListUserResponse> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ListUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    public AddUserResponse add(@RequestBody @Valid AddUserRequest request) {
        return userService.add(request);
    }

    @PutMapping("/update-user")
    public UpdateUserResponse update(@RequestBody @Valid UpdateUserRequest request) {
        return userService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
