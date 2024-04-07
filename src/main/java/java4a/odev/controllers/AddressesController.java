package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.dtos.requests.addresses.AddAddressRequest;
import java4a.odev.services.dtos.requests.addresses.UpdateAddressRequest;
import java4a.odev.services.dtos.responses.addresses.AddAddressResponse;
import java4a.odev.services.dtos.responses.addresses.ListAddressResponse;
import java4a.odev.services.dtos.responses.addresses.UpdateAddressResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private AddressesController addressService;

    @GetMapping("/get-all")
    public List<ListAddressResponse> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public ListAddressResponse getById(@PathVariable int id){
        return addressService.getById(id);
    }

    @PostMapping("/create-address")
    @ResponseStatus(HttpStatus.CREATED)
    public AddAddressResponse add(@RequestBody @Valid AddAddressRequest request) {
        return addressService.add(request);
    }

    @PutMapping("/update-address")
    public UpdateAddressResponse update(@RequestBody @Valid UpdateAddressRequest request) {
        return addressService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }
}
