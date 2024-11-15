import java.time.Year;

public class AlumnoImpl implements Alumno {
   private String name;
   private String surname;
   private String identification;
   private int birthYear;

   public AlumnoImpl(String name, String surname, String identification, int birthYear) {
      this.name = name;
      this.surname = surname;
      this.identification = identification;
      this.birthYear = birthYear;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getSurname() {
      return this.surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public String getIdentification() {
      return this.identification;
   }

   public void setIdentification(String identification) {
      this.identification = identification;
   }

   public int getBirthYear() {
      return this.birthYear;
   }

   public void setBirthYear(int birthYear) {
      this.birthYear = birthYear;
   }

   public int getAge() {
      return Year.now().getValue() - this.getBirthYear();
   }
}
