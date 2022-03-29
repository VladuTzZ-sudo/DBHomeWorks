package DeutscheBank.Day1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        Doctor d1 = new Surgeon("pro", "Name1");
        Doctor d2 = new Surgeon("megapro", "Name2");
        Doctor d3 = new Generalist(4, "Name3");
        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(doctors.get(i).toString());
        }
        /*
        doctors.add(null);
        doctors.add(null);

        for(int i =0 ; i<doctors.size();i++){
            doctors.get(i);
        }
        */

        int contorSurgeon = 0;
        int contorGeneralist = 0;
        for (Doctor d : doctors) {
            if (d instanceof Surgeon) {
                contorSurgeon++;
                // ((Surgeon) d).intervation();
            } else if (d instanceof Generalist) {
                ((Generalist) d).writeRecipe();
                contorGeneralist++;
            }
        }

        if (contorSurgeon >= 2 && contorGeneralist >= 2) {
            System.out.println("There are !");
        }

        List<Generalist> list_generalist = new ArrayList<Generalist>();

        Generalist g1 = new Generalist(1, "Costel");
        Generalist g2 = new Generalist(2, "Dorel");
        Generalist g3 = new Generalist(3, "Ion");
        list_generalist.add(g1);
        list_generalist.add(g2);
        list_generalist.add(g3);

        Collections.sort(list_generalist);

        for (Generalist generalist : list_generalist) {
            System.out.println(generalist);
        }

        double number_average = 0;
        int sum = 0;

        for (Generalist generalist : list_generalist) {
            sum += generalist.getNoPatients();
        }

        number_average = (double) sum / list_generalist.size();

        System.out.println();
        for (Generalist generalist : list_generalist) {
            if (generalist.getNoPatients() > number_average) {
                System.out.println(generalist);
            }
        }
    }
}

class Surgeon extends Doctor {
    private String expertise;

    public Surgeon(String expertise, String name) {
        super(name);
        this.expertise = expertise;
    }

    public Surgeon() {
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "expertise='" + expertise + '\'' +
                "name= " + super.getName() +
                '}';
    }

    public void intervention() {
        System.out.println("This surgeon is having an intervation");
    }
}
