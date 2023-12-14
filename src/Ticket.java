import java.util.Scanner;
public class Ticket {
    private int id;
    private String dni_tecnician;
    private String dni_manager;
    private int id_petition;
    private String state;
    private String rename;
    private String description;

    public Ticket(int id, String dni_tecnician, String dni_manager, int id_petition,
                  String estado, String titulo, String descripcion) {
        this.id = id;
        this.dni_tecnician = dni_tecnician;
        this.dni_manager = dni_manager;
        this.id_petition = id_petition;
        this.state = estado;
        this.rename = titulo;
        this.description = descripcion;
    }

    public Ticket() {
        id = -1;
        dni_tecnician = "";
        dni_manager = "";
        id_petition = -1;
        state = "";
        rename = "";
        description = "";
    }
//---Getters------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getDni_tecnician() {
        return dni_tecnician;
    }

    public String getDni_manager() {
        return dni_manager;
    }

    public int getId_petition() {
        return id_petition;
    }

    public String getState() {
        return state;
    }

    public String getRename() {
        return rename;
    }

    public String getDescription() {
        return description;
    }
//---Setters------------------------------------------------------------------------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setDni_tecnician(String dni_tecnician) {
        this.dni_tecnician = dni_tecnician;
    }

    public void setDni_manager(String dni_manager) {
        this.dni_manager = dni_manager;
    }

    public void setId_petition(int id_petition) {

    }

    public void setEstado() {
        System.out.println("Select the state of the ticket:" + "\n" +
                            "1.OPEN" + "\t" + "2.CLOSED" + "\t" + "3.SOLVED");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                state = "OPEN";
                break;
            case 2:
                state = "CLOSED";
                break;
            case 3:
                state = "SOLVED";
                break;
        }
        this.state = state;
    }

    public void setTitulo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket title:");
        this.rename = input.nextLine();
    }

    public void setDescription(String description) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket description:");
        this.description = input.nextLine();
    }
//---To-String----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        String s = "";
        s += "ID:" + getId() + "\n" +
             "Title:" + getRename() + "\n" +
             "Description:" + getDescription() + "\n" +
             "State:" + getState();
        return s;
    }
}
