public class Technician {
    private String DNI;
    private String name;

    public Technician(String DNI, String name) {
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
        return ("Technician: " + name + " Dni: " + DNI + " ID_Departament: ");
    }
}
