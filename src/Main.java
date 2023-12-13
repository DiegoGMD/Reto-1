import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();
        List<Technician> technicians = new ArrayList<>();
        users = CsvHandler.getUsersCsv();
        technicians = CsvHandler.getTechniciansCsv();
        boolean exit = false;
        while (exit)
        System.out.println("Welcome to the Ticket Management System, please write the name of your user or type Create to make a new user:");
        String nameUser = Global.inputKeyboard.next();
        if (nameUser.toUpperCase().equals("CREATE")) {
            User user = createNewUser();
            users.add(user);
            CsvHandler.writeUsersCsv(users);
        } else {
            List<String> usersByName = Global.getUsers(nameUser, users);
        }


    }

}
