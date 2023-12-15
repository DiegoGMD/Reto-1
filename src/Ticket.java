import java.util.Scanner;
public class Ticket {
    private int id;
    private String dni_tecnician;
    private String dni_manager;
    private int id_petition;
    private String state;
    private String title;
    private String description;

    public Ticket(int id, String dni_tecnician, String dni_manager, int id_petition,
                  String state, String title, String description) {
        this.id = id;
        this.dni_tecnician = dni_tecnician;
        this.dni_manager = dni_manager;
        this.id_petition = id_petition;
        this.state = state;
        this.title = title;
        this.description = description;
    }

    public Ticket() {
        id = -1;
        dni_tecnician = "";
        dni_manager = "";
        id_petition = -1;
        state = "";
        title = "";
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

    public String getTitle() {
        return title;
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

    public void setState() {
        System.out.println("Select the state of the ticket:" + "\n" +
                            "1.OPEN" + "\t" + "2.SOLVED" + "\t" + "3.CLOSED");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                state = "OPEN";
                break;
            case 2:
                state = "SOLVED";
                break;
            case 3:
                state = "CLOSED";
                break;
        }
        this.state = state;
    }

    public void setTitle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket title:");
        this.title = input.nextLine();
    }

    public void setDescription(String description) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket description:");
        this.description = input.nextLine();
    }
//---To-String----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        String s = new String();
        s = "ID: " + getId() + "\t" +
             "Title: " + getTitle() + "\n" +
             "Description: " + getDescription() + "\n" +
             "Technician DNI: " + getDni_tecnician() + "\n" +
             "State: " + getState() + "\n";
        return s;
    }
}
