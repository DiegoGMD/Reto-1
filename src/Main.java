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
        while (exit) {
            boolean selectUser = false;
            while (selectUser) {
                System.out.println("Welcome to the Ticket Management System, please write the name of your user or type Create to make a new user:");
                String nameUser = Global.inputKeyboard.next();
                if (nameUser.toUpperCase().equals("CREATE")) {
                    CsvHandler.writeUsersCsv(users);
                } else {
                    List<User> usersByName = Global.getUsers(nameUser, users);
                    List<Technician> techniciansByName = Global.getTechnicians(nameUser, technicians);
                    int index = 0;
                    for (User usersWithName : usersByName) {
                        System.out.println(index + " " + usersWithName);
                        index++;
                    }
                    for (Technician technicianWithName : techniciansByName) {
                        System.out.println(index + " " + technicianWithName);
                        index++;
                    }
                    System.out.println("Input the name of the number of the User of technician you want to use");
                    int numIndex = Global.inputKeyboard.nextInt();
                    index = 0;
                    User user = null;
                    Technician technician = null;
                    for (User usersWithName : usersByName) {
                        if (index == numIndex) {
                            user = usersWithName;
                        }
                        index++;
                    }
                    for (Technician technicianWithName : techniciansByName) {
                        if (index == numIndex) {
                            technician = technicianWithName;
                        }
                        index++;
                    }
                    if (technician == null && user == null) {
                        System.out.println("The index you've inputed doesn't exist in the options");
                    }

                }

            }
        }



    }

}
