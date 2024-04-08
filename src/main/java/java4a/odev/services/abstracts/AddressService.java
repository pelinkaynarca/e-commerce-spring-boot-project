package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.addresses.AddAddressRequest;
import java4a.odev.services.dtos.requests.addresses.UpdateAddressRequest;
import java4a.odev.services.dtos.responses.addresses.AddAddressResponse;
import java4a.odev.services.dtos.responses.addresses.ListAddressResponse;
import java4a.odev.services.dtos.responses.addresses.UpdateAddressResponse;

import java.util.List;

public interface AddressService {
    List<ListAddressResponse> getAll();
    ListAddressResponse getById(int id);
    AddAddressResponse add(AddAddressRequest request);
    UpdateAddressResponse update(UpdateAddressRequest request);
    void delete(int id);
}
