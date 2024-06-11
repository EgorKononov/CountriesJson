package ru.academits.java.kononov;

import ru.academits.java.kononov.jsonmodel.Country;

import java.util.List;

public class App {
    private static final String COUNTRIES_JSON_FILEPATH = "countries.json";
    private static final String COUNTRIES_WITH_POPULATION_NO_LESS_THEN_ONE_MILLION_JSON_FILEPATH = "countriesWithPopulationNoLessThenOneMillion.json";

    public static void main(String[] args) {
        try {
            List<Country> countriesFromFile = CountriesJsonManager.getCountriesFromFile(COUNTRIES_JSON_FILEPATH);

            System.out.println("Countries list: " + countriesFromFile + System.lineSeparator());
            System.out.println("Total population: " + CountriesJsonManager.calculateTotalPopulation(countriesFromFile) + System.lineSeparator());
            System.out.println("All currencies list: " + CountriesJsonManager.getAllCurrencies(countriesFromFile) + System.lineSeparator());

            List<Country> countriesWithPopulationNoLessThenOneMillion = CountriesJsonManager.getCountriesWithPopulationNoLessThen(countriesFromFile, 1000000L);
            System.out.println("Countries with population no less then 1 000 000: "
                    + countriesWithPopulationNoLessThenOneMillion + System.lineSeparator());

            CountriesJsonManager.saveCountriesToFile(countriesWithPopulationNoLessThenOneMillion, COUNTRIES_WITH_POPULATION_NO_LESS_THEN_ONE_MILLION_JSON_FILEPATH);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + e);
        }
    }
}
