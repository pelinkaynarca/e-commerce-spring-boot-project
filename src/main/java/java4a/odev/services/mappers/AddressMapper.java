package java4a.odev.services.mappers;

import java4a.odev.entities.Address;
import java4a.odev.services.dtos.requests.addresses.AddAddressRequest;
import java4a.odev.services.dtos.requests.addresses.UpdateAddressRequest;
import java4a.odev.services.dtos.responses.addresses.AddAddressResponse;
import java4a.odev.services.dtos.responses.addresses.ListAddressResponse;
import java4a.odev.services.dtos.responses.addresses.UpdateAddressResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    //add
    //source => request
    //target => entity
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "userId", target = "user.id")
    Address addressFromAddRequest(AddAddressRequest request);

    //source => entity
    //target => response
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    AddAddressResponse addResponseFromAddress(Address address);

    //update
    //source => request
    //target => entity
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "userId", target = "user.id")
    Address addressFromUpdateRequest(UpdateAddressRequest request);

    //source => entity
    //target => response
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.country.name", target = "countryName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    UpdateAddressResponse updateResponseFromAddress(Address address);

    //list
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "city.country.name", target = "countryName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    ListAddressResponse listResponseFromAddress(Address address);
}
