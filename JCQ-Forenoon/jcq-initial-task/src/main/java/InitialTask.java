import entity.Country;
import res.CountryData;
import service.CountryService;
import service.impl.CountryServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InitialTask {



    public static void main(String[] args) throws URISyntaxException, IOException{

        Path path = Paths.get(InitialTask.class.getClassLoader().getResource("sample.html").toURI());

        String contents = new String(Files.readAllBytes(path));

        CountryService countryService = new CountryServiceImpl();
        String countryTitle = countryService.findCountry(contents);
        System.out.println(countryTitle);


        HashMap<String, Country> countryMap = new HashMap<>();
        CountryData countryData = new CountryData();
        countryMap.put("India", countryService.setCountryData("India",Arrays.asList( "Chennai", "Mumbai")));
        countryMap.put("USA", countryService.setCountryData("USA",Arrays.asList( "NY", "LA")));
        countryMap.put("UK", countryService.setCountryData("UK",Arrays.asList( "London", "Leeds")));

        if(countryMap.containsKey(countryTitle)){
            System.out.println(countryMap.get(countryTitle).getCities());
        }
    }
}
