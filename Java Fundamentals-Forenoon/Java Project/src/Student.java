import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer roll;
    private Integer marks;
    private String subject;
    public Student() {}
    public Student(Integer roll, Integer marks, String subject) {
        super();
        this.roll = roll;
        this.marks = marks;
        this.subject = subject;
    }
    public Integer getRoll() {
        return roll;
    }
    public void setRoll(Integer roll) {
        this.roll = roll;
    }
    public Integer getMarks() {
        return marks;
    }
    public void setMarks(Integer marks) {
        this.marks = marks;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return new StringBuffer(" Roll Number: ").append(this.roll)
                .append(" Marks : ").append(this.marks).append(" Subject : ").append(this.subject).toString();
    }

}