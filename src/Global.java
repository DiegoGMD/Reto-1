import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Global {
    public static Scanner inputKeyboard = new Scanner(System.in);

    public static List<User> getUsers(String nameUser, List<User> users) {
        List<User> user = new ArrayList<User>();
        for (User allUser : users) {
            if (allUser.getName().toUpperCase().equals(nameUser)) {
                user.add(allUser);
            }
        }
        return user;
    }
    public static List<Technician> getTechnicians(String nameUser, List<Technician> technicians) {
        List<Technician> technician = new ArrayList<Technician>();
        for (Technician allUser : technicians) {
            if (allUser.getName().toUpperCase().equals(nameUser)) {
                technician.add(allUser);
            }
        }
        return technician;
    }
    public static List<Manager> getManagers(String nameUser, List<Manager> allManagers) {
        List<Manager> managers = new ArrayList<Manager>();
        for (Manager manager : allManagers) {
            if (manager.getName().toUpperCase().equals(nameUser)) {
                managers.add(manager);
            }
        }
        return managers;
    }
}
