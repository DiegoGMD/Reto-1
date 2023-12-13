import java.util.Scanner;
public class Ticket {
    private int id;
    private String dni_tecnico;
    private String dni_gestor;
    private int id_peticion;
    private String estado;
    private String titulo;
    private String descripcion;

    public Ticket(int id, String dni_tecnico, String dni_gestor, int id_peticion,
                  String estado, String titulo, String descripcion) {
        this.id = id;
        this.dni_tecnico = dni_tecnico;
        this.dni_gestor = dni_gestor;
        this.id_peticion = id_peticion;
        this.estado = estado;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Ticket() {
        id = 0;
        dni_tecnico = "";
        dni_gestor = "";
        id_peticion = 0;
        estado = "";
        titulo = "";
        descripcion = "";
    }
//---Getters------------------------------------------------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public String getDni_tecnico() {
        return dni_tecnico;
    }

    public String getDni_gestor() {
        return dni_gestor;
    }

    public int getId_peticion() {
        return id_peticion;
    }

    public String getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
//---Setters------------------------------------------------------------------------------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setDni_tecnico(String dni_tecnico) {
        this.dni_tecnico = dni_tecnico;
    }

    public void setDni_gestor(String dni_gestor) {
        this.dni_gestor = dni_gestor;
    }

    public void setId_peticion(int id_peticion) {

    }

    public void setEstado() {
        System.out.println("Select the state of the ticket:" + "\n" +
                            "1.OPEN" + "\t" + "2.CLOSED" + "\t" + "3.SOLVED");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()){
            case 1:
                estado = "OPEN";
                break;
            case 2:
                estado = "CLOSED";
                break;
            case 3:
                estado = "SOLVED";
                break;
        }
        this.estado = estado;
    }

    public void setTitulo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket title:");
        this.titulo = input.nextLine();
    }

    public void setDescripcion(String descripcion) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write below the ticket description:");
        this.descripcion = input.nextLine();
    }
}
