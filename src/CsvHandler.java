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

    public static List<ActionRequest> makeActionRequestCsv() throws IOException{
        BufferedReader input = null;
        List<ActionRequest> petition = new ArrayList<ActionRequest>();
        try {
            input = new BufferedReader(new FileReader("ActionRequest.csv"));
            String line;
            input.readLine();
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
            input = new BufferedReader(new FileReader("Inventory.csv"));
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
            input = new BufferedReader(new FileReader("Category.csv"));
            String line;
            input.readLine();
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


    public static void writeTicketsCsv(List<Ticket> tickets) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("Ticket.csv"));
            out.println("ID,DNI_Technician,DNI_Manager,ID_Request,State,Title,Description");
            for (Ticket ticket : tickets) {
                out.println(ticket.getId() + "," + ticket.getDni_tecnician() + "," + ticket.getDni_manager() + "," + ticket.getId_petition() + "," + ticket.getState() + "," + ticket.getTitle() + "," + ticket.getDescription());
            }
        } finally {
            if (out != null) {
                out.close();
            }
        }
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

            in = new BufferedReader(new FileReader("Technician.csv"));
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
            out = new PrintWriter(new FileWriter("Technician.csv"));
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
    public static List<ActionRequest> getPetitionsCsv() throws IOException {
        BufferedReader in = null;
        List<ActionRequest> users = new ArrayList<ActionRequest>();
        try {
            in = new BufferedReader(new FileReader("ActionRequest.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] userInfo = line.split(",");
                users.add(new ActionRequest(Integer.parseInt(userInfo[0]), Integer.parseInt(userInfo[1]),
                        userInfo[2], userInfo[3], userInfo[4], userInfo[5]));
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return users;
    }
    public static void writePetitionCsv(List<ActionRequest> users) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("ActionRequest.csv"));
            out.println("ID,ID_Category,ID_User,Title,Description,Inventory");
            for (ActionRequest user : users) {
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

            in = new BufferedReader(new FileReader("Managers.csv"));
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

    public static List<Ticket> getTicketsCsv() throws IOException {
        BufferedReader in = null;
        List<Ticket> tickets = new ArrayList<Ticket>();
        try {

            in = new BufferedReader(new FileReader("Ticket.csv"));
            String line = in.readLine();
            while ((line = in.readLine()) != null) {
                String[] ticketInfo = line.split(",");
                tickets.add(new Ticket(Integer.valueOf(ticketInfo[0]), ticketInfo[1], ticketInfo[2],
                        Integer.valueOf(ticketInfo[3]), ticketInfo[4], ticketInfo[5], ticketInfo[6]));
                //id, dni_technician, dni_manager, id_petition, state, title, description.
            }
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return tickets;
    }


}
