import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "assignments")
@XmlAccessorType(XmlAccessType.FIELD)
public class assignments {
    List<assignment> assignmt;

    @XmlElement(name = "assignment")
    public List<assignment> getAssignment() {
        return assignmt;
    }

    public void setAssignment(List<assignment> assignmt) {
        this.assignmt = assignmt;
    }

    @Override
    public String toString() {
        return "Assignments [assignments=" + assignmt + "]";
    }


}
