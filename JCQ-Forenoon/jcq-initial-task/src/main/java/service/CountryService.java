package service;

import entity.Country;

import java.util.List;

public interface CountryService {

    public String findCountry(String contents);
    public Country setCountryData(String name, List<String> countryList);
}
