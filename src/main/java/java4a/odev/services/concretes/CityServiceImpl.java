package java4a.odev.services.concretes;

import java4a.odev.core.utils.exceptions.types.BusinessException;
import java4a.odev.entities.City;
import java4a.odev.repositories.CityRepository;
import java4a.odev.services.abstracts.CityService;
import java4a.odev.services.dtos.requests.cities.AddCityRequest;
import java4a.odev.services.dtos.requests.cities.UpdateCityRequest;
import java4a.odev.services.dtos.responses.cities.AddCityResponse;
import java4a.odev.services.dtos.responses.cities.ListCityResponse;
import java4a.odev.services.dtos.responses.cities.UpdateCityResponse;
import java4a.odev.services.mappers.CityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public List<ListCityResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        return cities.stream()
                .map(CityMapper.INSTANCE::listResponseFromCity)
                .collect(Collectors.toList());
    }

    @Override
    public ListCityResponse getById(int id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new BusinessException("City not found with id: " + id));
        return CityMapper.INSTANCE.listResponseFromCity(city);
    }

    @Override
    public AddCityResponse add(AddCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromAddRequest(request);
        city = cityRepository.save(city);

        AddCityResponse addCityResponse = CityMapper.INSTANCE.addResponseFromCity(city);

        return addCityResponse;
    }

    @Override
    public UpdateCityResponse update(UpdateCityRequest request) {
        City city = CityMapper.INSTANCE.cityFromUpdateRequest(request);
        city = cityRepository.save(city);

        UpdateCityResponse updateCityResponse = CityMapper.INSTANCE.updateResponseFromCity(city);

        return updateCityResponse;
    }

    @Override
    public void delete(int id) {
        City city = cityRepository.findById(id).orElseThrow();
        cityRepository.delete(city);
    }
}
