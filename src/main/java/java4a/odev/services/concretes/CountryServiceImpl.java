package java4a.odev.services.concretes;

import java4a.odev.entities.Country;
import java4a.odev.repositories.CountryRepository;
import java4a.odev.services.abstracts.CountryService;
import java4a.odev.services.dtos.requests.countries.AddCountryRequest;
import java4a.odev.services.dtos.requests.countries.UpdateCountryRequest;
import java4a.odev.services.dtos.responses.countries.AddCountryResponse;
import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
import java4a.odev.services.dtos.responses.countries.UpdateCountryResponse;
import java4a.odev.services.mappers.CountryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Override
    public List<ListCountryResponse> getAll() {
        List<Country> countries = countryRepository.findAll();
        return CountryMapper.INSTANCE.toListCountryResponseList(countries);
    }

    @Override
    public ListCountryResponse getById(int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        return CountryMapper.INSTANCE.toListCountryResponse(country);
    }

    @Override
    public AddCountryResponse add(AddCountryRequest request){
        Country country = CountryMapper.INSTANCE.countryFromAddRequest(request);
        country = countryRepository.save(country);

        return CountryMapper.INSTANCE.addResponseFromCountry(country);
    }

    @Override
    public UpdateCountryResponse update(UpdateCountryRequest request) {
        Country country = countryRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + request.getId()));

        country.setName(request.getName());

        country = countryRepository.save(country);

        return CountryMapper.INSTANCE.updateCountryResponseFromCountry(country);
    }

    @Override
    public void delete(int id) {
        countryRepository.deleteById(id);
    }
}
