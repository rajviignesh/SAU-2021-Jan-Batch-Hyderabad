package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class personalEmpData implements Serializable {
    
    @Column
    private String phoneNo;
    
    @Column
    private String email;
    
    
    @OneToOne
    @Id
    @MapsId
    private employeeData empl;
    
    public personalEmpData(String ph, String email, employeeData emp){
        this.phoneNo = ph;
        this.email = email;
        this.empl = emp;
    }
}
