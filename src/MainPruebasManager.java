import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPruebasManager {
    public static void main(String[] args) throws IOException {

        List<User> users = new ArrayList<>();
        List<Technician> technicians = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();
        users = CsvHandler.getUsersCsv();
        technicians = CsvHandler.getTechniciansCsv();
        managers = CsvHandler.getManagerCsv();
        User user = null;
        Technician technician = null;
        Manager manager = null;
        boolean exit = false;
        while (!exit) {
            boolean selectUser = false;
            while (!selectUser) {
                System.out.println("Welcome to the Ticket Management System, please write the name of your user or type Create to make a new user:");
                String nameUser = Global.inputKeyboard.next();
                if (nameUser.toUpperCase().equals("CREATE")) {
                    CsvHandler.writeUsersCsv(users);
                } else {
                    List<User> usersByName = Global.getUsers(nameUser, users);
                    List<Technician> techniciansByName = Global.getTechnicians(nameUser, technicians);
                    List<Manager> managersByName = Global.getManagers(nameUser, managers);
                    int index = 1;
                    for (User usersWithName : usersByName) {
                        System.out.println(index + " " + usersWithName);
                        index++;
                    }
                    for (Technician technicianWithName : techniciansByName) {
                        System.out.println(index + " " + technicianWithName);
                        index++;
                    }
                    for (Manager managersWithName : managersByName) {
                        System.out.println(index + " " + managersWithName);
                        index++;
                    }
                    System.out.println("Input the name of the number of the User of technician you want to use");
                    int numIndex = Global.inputKeyboard.nextInt();
                    index = 1;
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
                    for (Manager managersWithName : managersByName) {
                        if (index == numIndex) {
                            manager = managersWithName;
                        }
                        index++;
                    }
                    if (technician == null && user == null && manager == null) {
                        System.out.println("The index you've inputed doesn't exist in the options");
                    } else {
                        selectUser = true;
                    }

                }

            }
            if (technician != null) {
                exit = technicianMethod(technician);
            } else if (user != null) {
                exit = userMethod(user);
            } else {
                exit = managerMethod(manager);
            }
        }



    }

    public static Boolean managerMethod(Manager manager) throws IOException {
        System.out.println("What you want to do: Consult(1), Modify(2), Create(3) or Exit(4)?");
        int option = Global.inputKeyboard.nextInt();
        int option2;
        if (option == 1) {
            System.out.println("You want to consult requests(1) or tickets(2)?");
            option2 = Global.inputKeyboard.nextInt();
            if (option2 == 1) {
                List<ActionRequest> requests = new ArrayList<>();
                requests = CsvHandler.getPetitionsCsv();
                System.out.println(requests);
            } else {
                List<ActionRequest> tickets = new ArrayList<>();
                //tickets = CsvHandler.getTicketsCsv();
                System.out.println(tickets);
            }
        } else if (option == 2) {
            System.out.println("You want to modify requests(1) or tickets(2)?");
            option2 = Global.inputKeyboard.nextInt();
        } else if (option == 3) {
            System.out.println("You want to create request(1) or ticket(2)?");
            option2 = Global.inputKeyboard.nextInt();
        } else {
            return true;
        }
        return true;
    }
    public static Boolean userMethod(User user) {
        return  true;
    }

    public static Boolean technicianMethod(Technician technician) {
        return  true;
    }

}