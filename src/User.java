public class User {
    String DNI;
    String name;
    int id_dep;
    public User(String DNI, String name, int id_dep) {
        this.DNI = DNI;
        this.name = name;
        this.id_dep = id_dep;
    }
    public String getDNI() {
        return DNI;
    }
    public String getName() {
        return name;
    }
    public int getId_dep() {
        return id_dep;
    }

}
