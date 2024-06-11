package ru.academits.java.kononov;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.academits.java.kononov.jsonmodel.Country;
import ru.academits.java.kononov.jsonmodel.Currency;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CountriesJsonManager {
    private CountriesJsonManager() {
    }

    static List<Country> getCountriesFromFile(String filePath) throws IOException {
        return new ObjectMapper().readValue(
                new File(filePath),
                new TypeReference<List<Country>>() {
                });
    }

    static Long calculateTotalPopulation(List<Country> countries) {
        return countries.stream().mapToLong(Country::getPopulation).sum();
    }

    static List<Currency> getAllCurrencies(List<Country> countries) {
        return countries.stream().flatMap(country -> country.getCurrencies().stream())
                .distinct().collect(Collectors.toList());
    }

    static List<Country> getCountriesWithPopulationNoLessThen(List<Country> countries, Long population) {
        return countries.stream().filter(country -> country.getPopulation() >= population)
                .collect(Collectors.toList());
    }

    static void saveCountriesToFile(List<Country> countries, String filePath) throws IOException {
        new ObjectMapper().writeValue(new File(filePath), countries);
    }
}
