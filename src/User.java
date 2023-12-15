public class User {
    private String DNI;
    private String name;
    private int id_dep;
//---------------------------------------Constructors-----------------------------------------------------------------//
    public User(String DNI, String name, int id_dep) {
        this.DNI = DNI;
        this.name = name;
        this.id_dep = id_dep;
    }

    public User () {
        DNI = "";
        name = "";
        id_dep = -1;
    }
//---------------------------------------Getters----------------------------------------------------------------------//
    public String getDNI() {
        return DNI;
    }
    public String getName() {
        return name;
    }
    public int getId_dep() {
        return id_dep;
    }
//---------------------------------------Setters----------------------------------------------------------------------//

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_dep(int id_dep) {
        this.id_dep = id_dep;
    }
//-------------------------------------ToString-----------------------------------------------------------------------//
    @Override
    public String toString() {
        return ("User: " + name + " Dni: " + DNI + " ID_Departament: " + id_dep);
    }

}
