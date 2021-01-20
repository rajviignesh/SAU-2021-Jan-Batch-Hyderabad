import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;

public class XMLtoObj {
    private static String filePath = "assignments.xml";
    private static assignments assignmts;

    public assignments getAssignments(){
        return this.assignmts;
    }

    public static void main(String[] args) {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(assignments.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            assignmts = (assignments) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Deserialized XML File:");
            for(assignment assi: assignmts.getAssignment()){
                System.out.println(assi);
            }
            System.out.println("Capitalizing Name and Program Language.. And Inserting into Oracle DB");
//            for(assignment assi: assignmts.getAssignment()){
//                CapitalizeStringConv.capitalizeString(assi);
//                System.out.println(assi);
//                JdbcOracleConnection.DBwrite(assi);
//            }


        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
