
import java.util.Arrays;

public class CompareStuff {
    
    public static void main(String[] args){
        
        Student[] students = new Student[3];
        students[0] = new Student("Robert", "Johnson");
        students[1] = new Student("Maria", "Blake");
        students[2] = new Student("John", "Johnson");

        students[0].setScore(55);
        students[1].setScore(41);
        students[2].setScore(79);

        for (Student x: students){
            System.out.println(x);
        }
        System.out.println("-----");
        Arrays.sort(students);
        for (Student x : students) {
            System.out.println(x);
        }
    }
}
