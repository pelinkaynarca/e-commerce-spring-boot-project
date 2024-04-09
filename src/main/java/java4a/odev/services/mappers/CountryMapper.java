package java4a.odev.services.mappers;

import java4a.odev.entities.Country;
import java4a.odev.services.dtos.requests.countries.AddCountryRequest;
import java4a.odev.services.dtos.responses.countries.AddCountryResponse;
import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
import java4a.odev.services.dtos.responses.countries.UpdateCountryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    Country countryFromAddRequest(AddCountryRequest request);
    AddCountryResponse addResponseFromCountry(Country country);
    UpdateCountryResponse updateCountryResponseFromCountry(Country country);
    List<ListCountryResponse> toListCountryResponseList(List<Country> countries);
    ListCountryResponse toListCountryResponse(Country country);
}
