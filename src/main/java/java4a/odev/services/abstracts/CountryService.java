package java4a.odev.services.abstracts;

import java4a.odev.services.dtos.requests.countries.AddCountryRequest;
import java4a.odev.services.dtos.requests.countries.UpdateCountryRequest;
import java4a.odev.services.dtos.responses.countries.AddCountryResponse;
import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
import java4a.odev.services.dtos.responses.countries.UpdateCountryResponse;

import java.util.List;

public interface CountryService {
    List<ListCountryResponse> getAll();
    ListCountryResponse getById(int id);
    AddCountryResponse add(AddCountryRequest request);
    UpdateCountryResponse update(UpdateCountryRequest request);
    void delete(int id);
}
