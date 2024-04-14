package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.Address;
import java4a.odev.entities.Country;
import java4a.odev.repositories.AddressRepository;
import java4a.odev.services.abstracts.AddressService;
import java4a.odev.services.dtos.requests.addresses.AddAddressRequest;
import java4a.odev.services.dtos.requests.addresses.UpdateAddressRequest;
import java4a.odev.services.dtos.responses.addresses.AddAddressResponse;
import java4a.odev.services.dtos.responses.addresses.ListAddressResponse;
import java4a.odev.services.dtos.responses.addresses.UpdateAddressResponse;
import java4a.odev.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public ListAddressResponse getById(int id) {
        Address address = getAddressById(id);
        return AddressMapper.INSTANCE.listResponseFromAddress(address);
    }

    @Override
    public List<ListAddressResponse> findAllByUserId(int userId) {
        List<Address> addresses = addressRepository.findAllByUserId(userId);
        return addresses.stream()
                .map(AddressMapper.INSTANCE::listResponseFromAddress)
                .collect(Collectors.toList());
    }

    @Override
    public AddAddressResponse add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        address = addressRepository.save(address);

        AddAddressResponse addAddressResponse = AddressMapper.INSTANCE.addResponseFromAddress(address);

        return addAddressResponse;
    }

    @Override
    public UpdateAddressResponse update(UpdateAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        address = addressRepository.save(address);

        UpdateAddressResponse updateAddressResponse = AddressMapper.INSTANCE.updateResponseFromAddress(address);

        return updateAddressResponse;
    }

    @Override
    public void delete(int id) {
        Address address = getAddressById(id);
        addressRepository.delete(address);
        }

    private Address getAddressById(int id) {
        return addressRepository.findById(id).orElseThrow(() -> new BusinessException(id + "ID'sine sahip bir adres bulunamadı."));
    }
}
