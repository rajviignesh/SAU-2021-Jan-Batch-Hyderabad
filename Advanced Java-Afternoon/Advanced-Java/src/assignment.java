import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class assignment {
    @CapitalizeString(capitalizeString = true)
    @XmlElement(name = "name" )
    private String Name;

    @CapitalizeString(capitalizeString = true)
    @XmlElement(name = "prog_lang" )
    private String ProgLang;

    @XmlElement(name = "status_update" )
    private String Status;

    @XmlAttribute(name = "id")
    private Integer Id;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getProgLang() {
        return ProgLang;
    }

    public void setProgLang(String ProgLang) {
        this.ProgLang = ProgLang;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "ID='" + this.Id + '\'' +
                ", Name='" + this.Name + '\'' +
                ", Prog language='" + this.ProgLang + '\'' +
                ", Status Update=" + this.Status +
                '}';
    }
}
