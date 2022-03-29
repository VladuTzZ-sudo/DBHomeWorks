package DeutscheBank.Day1;

class Generalist extends Doctor implements Comparable<Generalist> {
    private int noPatients;

    public Generalist(int noPatients, String name) {
        super(name);
        this.noPatients = noPatients;
    }

    public Generalist() {
    }

    @Override
    public String toString() {
        return "Generalist{" +
                "noPatients=" + noPatients +
                "name= " + super.getName() +
                '}';
    }
    public void writeRecipe(){
        System.out.println("I am writing your recipe");
    }

    @Override
    public int compareTo(Generalist o) {
        return noPatients - o.noPatients;
    }

    public int getNoPatients() {
        return noPatients;
    }

}

