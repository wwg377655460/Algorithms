package Sort;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Student implements Comparable<Student> {

    public String name;

    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return this.name + " " + this.score;
    }
}
