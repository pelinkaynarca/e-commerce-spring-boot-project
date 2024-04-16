package java4a.odev.services.mappers;

import java4a.odev.entities.Country;
import java4a.odev.services.dtos.requests.countries.AddCountryRequest;
import java4a.odev.services.dtos.requests.countries.UpdateCountryRequest;
import java4a.odev.services.dtos.responses.countries.AddCountryResponse;
import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
import java4a.odev.services.dtos.responses.countries.UpdateCountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    ListCountryResponse listResponseFromCountry(Country country);

    List<ListCountryResponse> ListResponseListFromCountryList(List<Country> countries);

    Country countryFromAddRequest(AddCountryRequest request);

    AddCountryResponse addResponseCountry(Country country);

    @Mapping(target = "id", source = "request.id")
    @Mapping(target = "name", source = "request.name")
    Country countryFromUpdateRequest(UpdateCountryRequest request);

    @Mapping(target = "id", source = "country.id")
    @Mapping(target = "name", source = "country.name")
    UpdateCountryResponse updateResponseFromCountry(Country country);


}
