package stream.api;

import java.util.ArrayList;
import java.util.List;

public class FlatMapMain {
    public static void main(String[] args) {
        final Student st1 = new Student("Ivan", 'm', 22, 3);
        final Student st2 = new Student("Nikolay", 'm', 28, 2);
        final Student st3 = new Student("Elena", 'f', 19, 1);
        final Student st4 = new Student("Petr", 'm', 35, 4);
        final Student st5 = new Student("Marina", 'f', 23, 3);

        
        Faculty f1 = new Faculty("Economic");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.addStudent(st1);
        f1.addStudent(st2);
        f1.addStudent(st3);

        f2.addStudent(st4);
        f2.addStudent(st5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList.stream().flatMap(faculty -> faculty.getStudents().stream())
                .forEach(student -> System.out.println(student.getName()));
    }
}

class Faculty {
    String name;
    List<Student> students;

    public Faculty(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}

class Student {
    private final String name;
    private final int age;
    private final char sex;
    private final int course;

    public Student(String name, char sex, int age, int course) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", course=" + course +
                '}';
    }
}
