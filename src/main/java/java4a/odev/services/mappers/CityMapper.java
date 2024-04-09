package java4a.odev.services.mappers;


import java4a.odev.entities.City;
import java4a.odev.services.dtos.requests.cities.AddCityRequest;
import java4a.odev.services.dtos.requests.cities.UpdateCityRequest;
import java4a.odev.services.dtos.responses.cities.AddCityResponse;
import java4a.odev.services.dtos.responses.cities.ListCityResponse;
import java4a.odev.services.dtos.responses.cities.UpdateCityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    //add
    //source => request
    //target => entity
    @Mapping(source = "countryId", target = "country.id")
    City cityFromAddRequest(AddCityRequest request);

    //source => entity
    //target => response
    @Mapping(source = "country.id", target = "countryId")
    //TODO: response body'de name null dönüyor
    @Mapping(source = "country.name", target = "countryName")
    AddCityResponse addResponseFromCity(City city);

    //update
    //source => request
    //target => entity
    @Mapping(source = "countryId", target = "country.id")
    City cityFromUpdateRequest(UpdateCityRequest request);

    //source => entity
    //target => response
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    UpdateCityResponse updateResponseFromCity(City city);

    //list
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    ListCityResponse listResponseFromCity(City city);

}
