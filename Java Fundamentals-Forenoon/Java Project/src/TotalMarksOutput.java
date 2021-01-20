import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TotalMarksOutput {

    public static void main(String [] args) {
        marksList e = null;
        ArrayList<marksList> ml = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\rajvi\\Desktop\\Accolite\\Day8\\src\\marksList.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ml = (ArrayList<marksList>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        Collections.sort(ml);
        Collections.reverse(ml);
        int rank = 1;
        for(marksList m: ml) {
            m.setRank(rank++);
        }
        System.out.println("Deserialized Data:");
        System.out.println("Rank RollNo Marks");

        for(marksList m: ml) {
            System.out.println(m.getRank() + " " + m.getRoll() + " " + m.getTotalMarks());
        }


        File file = new File("test.csv");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Rank, RollNo, Marks");
            bw.newLine();

            for(marksList m: ml) {
                bw.write(m.getRank() + "," + m.getRoll() + "," + m.getTotalMarks());
                bw.newLine();
            }
            System.out.println("Data written to CSV");
            bw.close();
            fw.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }



    }
}