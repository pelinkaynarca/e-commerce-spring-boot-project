package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.dtos.requests.countries.AddCountryRequest;
import java4a.odev.services.dtos.requests.countries.UpdateCountryRequest;
import java4a.odev.services.dtos.responses.countries.AddCountryResponse;
import java4a.odev.services.dtos.responses.countries.ListCountryResponse;
import java4a.odev.services.dtos.responses.countries.UpdateCountryResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/countries")

public class CountriesController {
    private CountriesController countryService;

    @GetMapping("/get-all")
    public List<ListCountryResponse> getAll(){
        return countryService.getAll();
    }

    @GetMapping("/{id}")
    public ListCountryResponse getById(@PathVariable int id){
        return countryService.getById(id);
    }

    @PostMapping("/create-country")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCountryResponse add(@RequestBody @Valid AddCountryRequest request) {
        return countryService.add(request);
    }

    @PutMapping("/update-country")
    public UpdateCountryResponse update(@RequestBody @Valid UpdateCountryRequest request) {
        return countryService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        countryService.delete(id);
    }
}
