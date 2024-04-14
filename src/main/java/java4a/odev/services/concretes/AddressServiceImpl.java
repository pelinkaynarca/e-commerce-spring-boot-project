package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.Address;
import java4a.odev.entities.City;
import java4a.odev.entities.Country;
import java4a.odev.entities.User;
import java4a.odev.repositories.AddressRepository;
import java4a.odev.repositories.CityRepository;
import java4a.odev.repositories.CountryRepository;
import java4a.odev.repositories.UserRepository;
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
    private UserRepository userRepository;
    private CityRepository cityRepository;


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
        City city = getCityById(request.getCityId());
        User user = getUserById(request.getUserId());
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        address = addressRepository.save(address);
        address.setCity(city);
        address.setUser(user);

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

    private User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new BusinessException(id + "ID'sine sahip bir kullanıcı bulunamadı."));
    }

    private City getCityById(int id) {
        return cityRepository.findById(id).orElseThrow(() -> new BusinessException(id + "ID'sine sahip bir şehir bulunamadı."));
    }
}
