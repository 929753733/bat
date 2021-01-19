package clone;

/**
 * @author lvyue
 * @since 2021/1/14
 */
public class Student implements Cloneable {

    private String name;
    private int age;
    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student(String name, int age, Professor professor) {
        this.name = name;
        this.age = age;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", professor=" + professor +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student student = null;
        student = (Student) super.clone();
        return student;
    }
}
