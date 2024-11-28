import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> readFromFile(String path) {
        List<String> list = new ArrayList<>();

        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(data);
            }

            myReader.close();
        } catch (FileNotFoundException var5) {
            System.out.println("An error occurred.");
            var5.printStackTrace();
        }

        return list;
    }

   public static List<Alumno> readAlumns(String path) {
      List<Alumno> alumns = new ArrayList<>();

      try {
         List<String> alumnsText = readFromFile(path);
       for(String alumn: alumnsText ){
        String[] arrayAlumn  =  alumn.split(",");
        Alumno alumno = new AlumnoImpl(arrayAlumn[0], arrayAlumn[1], arrayAlumn[2], Integer.parseInt(arrayAlumn[3]));
            alumns.add(alumno);
      } 
    }catch (Exception var7) {
         System.out.println("Error reading file");
      }

      return alumns;
   } 
}

