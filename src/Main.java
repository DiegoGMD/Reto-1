import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        boolean exit = false;
        while (exit)
        System.out.println("Welcome to the Ticket Management System, please write the name of your user or type Create to make a new user:");
        String nameUser = Global.inputKeyboard.next();
        if (nameUser.toUpperCase().equals("CREATE")) {
            User user = createNewUser();
            users.add(user);
        }


    }

}
