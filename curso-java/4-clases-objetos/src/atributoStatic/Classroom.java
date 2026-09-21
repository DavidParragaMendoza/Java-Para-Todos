package atributoStatic;

public class Classroom {
    private String studentName;
    private static String schoolName = "UEANCON.COM";

    public Classroom(String studentName) {

        this.studentName = studentName;
    }

    public void showInfo() {
        System.out.println("Alumno: " + studentName + " Escuela: " + schoolName);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {

        this.studentName = studentName;
    }

    public static String getSchoolName() {

        return schoolName;
    }

    public static void setSchoolName(String schoolName) {

        Classroom.schoolName = schoolName;
    }
}
