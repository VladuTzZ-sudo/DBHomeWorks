package DeutscheBank.HomeWork02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Exercitiul 1.
        System.out.println("EXERCITIUL 1\n");
        HashMap<Integer, TreeSet<Student>> rounded_grades = new HashMap<>();
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Vlad", 9.87));
        students.add(new Student("Matei", 9.23));
        students.add(new Student("Cristian", 9.50));
        students.add(new Student("Ion", 8.51));
        students.add(new Student("Maria", 8.52));
        students.add(new Student("George", 8.495));
        students.add(new Student("Vasile", 8.49));

        for (Student student : students) {
            int round_grade = (int) Math.round(student.getGrade());
            if (round_grade > 0 && round_grade <= 10) {
                if (!rounded_grades.containsKey(round_grade)) {
                    TreeSet<Student> treeSet = new TreeSet<>((o1, o2) -> Double.compare(o2.getGrade(), o1.getGrade()));
                    treeSet.add(student);

                    rounded_grades.put(round_grade, treeSet);
                } else {
                    TreeSet<Student> treeSet = rounded_grades.get(round_grade);

                    treeSet.add(student);

                    rounded_grades.put(round_grade, treeSet);
                }
            }
        }

        // unsorted
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();

        // sorted
        for (HashMap.Entry<Integer, TreeSet<Student>> map_grades : rounded_grades.entrySet()) {
            System.out.println("For grade : " + map_grades.getKey());

            for (Student student : map_grades.getValue()) {
                System.out.println(student);
            }
        }

        // Exercitiul 2.
        System.out.println("\nEXERCITIUL 2 - VARIANTA 1\n");

        MyList<Integer> my_list = new MyList<>(2);

        my_list.add(1);

        my_list.print();
        System.out.println("Elementul: " + 2 + " exista ? R: " + my_list.lookup(2));

        my_list.add(5);
        my_list.print();
        System.out.println("Alocarea listei este : " + my_list.data.length);
        my_list.add(600);

        my_list.print();
        System.out.println("Alocarea listei este : " + my_list.data.length);

        my_list.add(800);
        my_list.add(22);
        my_list.print();
        System.out.println("Alocarea listei este : " + my_list.data.length);

        System.out.println("Elementul: " + 5 + " exista ? R: " + my_list.lookup(5));
        System.out.println("Elementul: " + 700 + " exista ? R: " + my_list.lookup(700));

        System.out.println("\nEXERCITIUL 2 - VARIANTA 2\n");

        MyList<Double> my_list2 = new MyList<>(2);

        my_list2.add(1.4);

        my_list2.print();
        System.out.println("Elementul: " + 1.4 + " exista ? R: " + my_list2.lookup(1.4));

        my_list2.add(5.7);
        my_list2.print();
        System.out.println("Alocarea listei este : " + my_list2.data.length);
        my_list2.add(88.8);

        my_list2.print();
        System.out.println("Alocarea listei este : " + my_list2.data.length);

        my_list2.add(800.0002);
        my_list2.add(22.3);
        my_list2.print();
        System.out.println("Alocarea listei este : " + my_list2.data.length);

        System.out.println("Elementul: " + 800.0001 + " exista ? R: " + my_list2.lookup(800.0001));
        System.out.println("Elementul: " + 22.3 + " exista ? R: " + my_list2.lookup(22.3));
    }
}
