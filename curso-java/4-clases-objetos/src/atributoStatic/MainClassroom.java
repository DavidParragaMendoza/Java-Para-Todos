package atributoStatic;

public class MainClassroom {
    static void main(String[] args) {

        Classroom student1 = new Classroom("David");

        Classroom student2 = new Classroom("Ronald");

        Classroom student3 = new Classroom("Parraga");

        student1.showInfo();
        student2.showInfo();
        student3.showInfo();

        Classroom.setSchoolName("Escuela2-UEA");
        student3.showInfo();
    }
}
