package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class employeeData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int empId;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empl")
    private List<addressData> addList = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Courses_taken",
            joinColumns = @JoinColumn(name = "Empl_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Collection<courseData> course = new HashSet<>();
    
    public void addCourse(courseData courseInst){
        this.course.add(courseInst);
        courseInst.getEmplList().add(this);
    }
    
    public employeeData(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
