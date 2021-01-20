import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLtoJava {
    private static final String filepath="C:\\Users\\rajvi\\Desktop\\Accolite\\Day8\\src\\marksList.txt";
    private static ArrayList<marksList> test  ;

    public static void main(String[] args) {


        try {

            File file = new File("studentsData.xml");
            ArrayList<marksList> marklist = new ArrayList<>();
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Students students = (Students) jaxbUnmarshaller.unmarshal(file);

            System.out.println("Student List:");
            List<Student> list=students.getStudent();
            HashMap<Integer, Integer> markList = new HashMap<>();
            for(Student stu :list) {
                System.out.println(stu.getRoll() + " " + stu.getMarks() + "  " + stu.getSubject());
                if(markList.containsKey(stu.getRoll())) {
                    int a = markList.get(stu.getRoll());
                    a = a + stu.getMarks();
                    markList.put(stu.getRoll(), a);
                }
                else{
                    markList.put(stu.getRoll(), stu.getMarks());
                }
                }
            System.out.println(markList);

            for (Map.Entry<Integer, Integer> e : markList.entrySet()) {
                marksList ml = new marksList(e.getKey(), e.getValue());
                marklist.add(ml);
            }
            XMLtoJava text = new XMLtoJava();
            text.WriteObjectToFile(marklist);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public void WriteObjectToFile(ArrayList<marksList> stu) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(stu);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}  