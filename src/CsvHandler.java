import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    public static List<User> getUsersCsv() throws IOException {
        BufferedReader in = null;
        List<User> users = new ArrayList<User>();
        try {

            in = new BufferedReader(new FileReader("Usuario.csv"));
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

    public static List<ActionRequest> makeActionRequestCsv () throws IOException{
        BufferedReader input = null;
        List<ActionRequest> petition = new ArrayList<ActionRequest>();
        try {
            input = new BufferedReader(new FileReader("Petición.csv"));
            String line;
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                petition.add(new ActionRequest(Integer.parseInt(items[0]),
                        Integer.parseInt(items[1]),items[2],
                        items[3], items[4], items[5]));
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return petition;
    }

    public static  List<Inventory> makeInventory() throws IOException {
        BufferedReader input = null;
        List<Inventory> inventory = new ArrayList<Inventory>();
        try {
            input = new BufferedReader(new FileReader("Equipo_inventario.csv"));
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

    public static List<Category> makeCategoryCsv () throws IOException {
        BufferedReader input = null;
        List<Category> categoryList = new ArrayList<Category>();
        try {
            input = new BufferedReader(new FileReader("Categorias.csv"));
            String line;
            while ((line = input.readLine()) != null) {
                String[] item = line.split(",");
                categoryList.add(new Category(Integer.parseInt(item[0]), item[1]));
            }
        }
        finally {
            if (input != null) {
                input.close();
            }
        }
        return categoryList;
    }
    public static void writeUsersCsv(List<User> users) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("Usuario.csv"));
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

            in = new BufferedReader(new FileReader("Tecnico.csv"));
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
            out = new PrintWriter(new FileWriter("Tecnico.csv"));
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

            in = new BufferedReader(new FileReader("Petición.csv"));
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
            out = new PrintWriter(new FileWriter("Petición.csv"));
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

    public static List<Manager> getManagerCsv() throws IOException {
        BufferedReader in = null;
        List<Manager> managers = new ArrayList<Manager>();
        try {

            in = new BufferedReader(new FileReader("Gestor de sistemas.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] userInfo = line.split(",");
                managers.add(new Manager(userInfo[0], userInfo[1]));
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return managers;
    }


}
