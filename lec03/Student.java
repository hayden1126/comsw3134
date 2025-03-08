
public class Student implements Comparable<Student> {
    private int score;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName){
        this.firstName = firstName; // "this." is required because the name of class variable is the same
        this.lastName = lastName;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String toString(){
        return firstName + " " + lastName + " - " + score;
    }

    public int compareTo(Student other){
        return score - other.score;
        // int cmpResult = lastName.compareTo(other.lastName);
        // if (cmpResult!=0){
        //     return cmpResult;
        // } else {
        //     return firstName.compareTo(other.firstName);
        // }
    }
}
