package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class addressData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int addressId;
    
    @Column
    private String areaName;
    
    @Column
    private String city;
    
    @Column
    private String pincode;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private employeeData empl;
    
    public addressData(String areaName, String city, String pincode, employeeData emp){
        this.areaName = areaName;
        this.city = city;
        this.pincode = pincode;
        this.empl = emp;
    }
}
