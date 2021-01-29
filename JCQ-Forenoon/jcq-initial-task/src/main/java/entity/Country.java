package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Country {

    private String name;
    private ArrayList<String> cities;

    public Country(){
        cities = new ArrayList<>();
    }

    public void setCities(List<String> city){
        this.cities.addAll(city);
    }



}
