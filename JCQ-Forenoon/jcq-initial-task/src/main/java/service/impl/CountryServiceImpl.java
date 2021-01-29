package service.impl;



import entity.Country;
import service.CountryService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountryServiceImpl implements CountryService {

    public String findCountry(String contents) {
        Pattern pattern = Pattern.compile("<title>(\\S+)</title>");
        Matcher matcher = pattern.matcher(contents);
        if (matcher.find()) {
            String result = matcher.group(1);
            return result;
        }
        return "Country not Found";
    }

    public Country setCountryData(String name, List<String> countryList){
        Country country = new Country();
        country.setName(name);
        country.setCities(countryList);
        return country;
    }
}
