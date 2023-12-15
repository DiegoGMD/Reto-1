import java.io.IOException;
import java.util.List;

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
        return ("Technician: " + name + " Dni: " + DNI);
    }

    public static String selectTechnician() throws IOException {
        List<Technician> technicians = CsvHandler.getTechniciansCsv();
        String s = "";
        while (s.isEmpty()) {
            System.out.println("Choose the Technician");
            int index = 1;
            for (Technician technician : technicians) {
                System.out.println(index + " | " + technician);
                index++;
            }
            String numIndex = Global.inputKeyboard.next();
            index = 1;
            for (Technician technician : technicians) {
                if (numIndex.equals(index + "")) {
                    s += technician.getDNI();
                }
                index++;
            }
        }
        return s;
    }
}
