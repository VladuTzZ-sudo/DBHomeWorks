package DeutscheBank.HomeWork02;

import java.util.Objects;

public class Student {
    private final String name;
    private final double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                "," + "\t" + "\t" + "grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) && grade == ((Student) o).getGrade();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}
