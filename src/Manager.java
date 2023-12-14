public class Manager {
    private String DNI;
    private String name;

    public Manager(String DNI, String name) {
        this.DNI = DNI;
        this.name = name;
    }
    public String getDNI() {
        return DNI;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ("Manager: " + name + " Dni: " + DNI);
    }

}
