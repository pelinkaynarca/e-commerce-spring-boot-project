package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.cities.AddCityRequest;
import java4a.odev.services.dtos.requests.cities.UpdateCityRequest;
import java4a.odev.services.dtos.responses.cities.AddCityResponse;
import java4a.odev.services.dtos.responses.cities.ListCityResponse;
import java4a.odev.services.dtos.responses.cities.UpdateCityResponse;

import java.util.List;

public interface CityService {
    List<ListCityResponse> getAll();
    ListCityResponse getById(int id);
    AddCityResponse add(AddCityRequest request);
    UpdateCityResponse update(UpdateCityRequest request);
    void delete(int id);
}
