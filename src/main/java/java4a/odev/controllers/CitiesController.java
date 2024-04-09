package java4a.odev.controllers;

import jakarta.validation.Valid;

import java4a.odev.services.abstracts.CityService;
import java4a.odev.services.dtos.requests.cities.AddCityRequest;
import java4a.odev.services.dtos.requests.cities.UpdateCityRequest;
import java4a.odev.services.dtos.responses.cities.AddCityResponse;
import java4a.odev.services.dtos.responses.cities.ListCityResponse;
import java4a.odev.services.dtos.responses.cities.UpdateCityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private CityService cityService;

    @GetMapping("/get-all")
    public List<ListCityResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public ListCityResponse getById(@PathVariable int id){
        return cityService.getById(id);
    }

    @PostMapping("/create-city")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCityResponse add(@RequestBody @Valid AddCityRequest request) {
        return cityService.add(request);
    }

    @PutMapping("/update-city")
    public UpdateCityResponse update(@RequestBody @Valid UpdateCityRequest request) {
        return cityService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cityService.delete(id);
    }
}
