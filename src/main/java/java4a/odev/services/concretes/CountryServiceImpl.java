package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
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
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    @Override
    public List<ListCountryResponse> getAll() {
        List<Country> countries = countryRepository.findAll();
        return CountryMapper.INSTANCE.ListResponseListFromCountryList(countries);
    }

    @Override
    public ListCountryResponse getById(int id) {
        Country country = getCountryById(id);
        return CountryMapper.INSTANCE.listResponseFromCountry(country);
    }

    @Override
    public AddCountryResponse add(AddCountryRequest request){
        countryWithSameNameShouldNotExist(request.getName());
        Country country = CountryMapper.INSTANCE.countryFromAddRequest(request);
        country = countryRepository.save(country);

        return CountryMapper.INSTANCE.addResponseCountry(country);
    }

    @Override
    public UpdateCountryResponse update(UpdateCountryRequest request) {
        getCountryById(request.getId());
        countryWithSameNameShouldNotExist(request.getName());

        Country updatedCountry = CountryMapper.INSTANCE.countryFromUpdateRequest(request);
        updatedCountry = countryRepository.save(updatedCountry);

        return CountryMapper.INSTANCE.updateResponseFromCountry(updatedCountry);
    }

    @Override
    public void delete(int id) {
       Country country = getCountryById(id);
       countryRepository.delete(country);
    }

    private Country getCountryById(int id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new BusinessException("ID'si " + id + " olan ülke bulunamadı."));
    }
    private void countryWithSameNameShouldNotExist(String name) {
        Optional<Country> categoryWithSameName = countryRepository.findByNameIgnoreCase(name);

        if(categoryWithSameName.isPresent())
            throw new BusinessException("Aynı isimde bir ülke zaten var");
    }

}
