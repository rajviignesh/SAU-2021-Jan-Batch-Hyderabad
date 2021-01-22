package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class courseData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int courseId;
    
    @Column
    private String courseName;
    
    @ManyToMany(mappedBy = "course")
    private List<employeeData> emplList = new ArrayList<>();
    
    public courseData(String cName){
        this.courseName = cName;
    }
}
