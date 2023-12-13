import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    public static List<User> getUsersCsv() throws IOException {
        BufferedReader in = null;
        List<User> users = new ArrayList<User>();
        try {

            in = new BufferedReader(new FileReader("Users.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] userInfo = line.split(",");
                users.add(new User(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2])));
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return users;
    }

    public static  List<Inventory> makeInventory() throws IOException {
        BufferedReader input = null;
        List<Inventory> inventory = new ArrayList<Inventory>();
        try {
            input = new BufferedReader(new FileReader("Equipo inventario.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                inventory.add(new Inventory(items[0], items[1]));
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return inventory;
    }
    public static void writeUsersCsv(List<User> users) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("Users.csv"));
            out.println("DNI,Name,id_dep");
            for (User user : users) {
                out.println(user.getDNI() + "," + user.getName() + "," + user.getId_dep());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    public static List<Technician> getTechniciansCsv() throws IOException {
        BufferedReader in = null;
        List<Technician> technicians = new ArrayList<Technician>();
        try {

            in = new BufferedReader(new FileReader("Users.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] userInfo = line.split(",");
                technicians.add(new Technician(userInfo[0], userInfo[1]));
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return technicians;
    }
    public static void writeTechniciansCsv(List<User> users) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("Users.csv"));
            out.println("DNI,Name");
            for (User user : users) {
                out.println(user.getDNI() + "," + user.getName());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    public static List<User> getPetitionsCsv() throws IOException {
        BufferedReader in = null;
        List<User> users = new ArrayList<User>();
        try {

            in = new BufferedReader(new FileReader("Petitions.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] userInfo = line.split(",");
                users.add(new User(userInfo[0], userInfo[1], Integer.parseInt(userInfo[2])));
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return users;
    }
    public static void writePetitionCsv(List<User> users) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("Petitions.csv"));
            out.println("ID ,ID Categoría ,ID Usuario ,Título ,Descripción ,Equipo");
            for (User user : users) {
                out.println(user.getDNI() + "," + user.getName() + "," + user.getId_dep());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
