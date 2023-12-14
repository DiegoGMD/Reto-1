import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianMethodClass {
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
                //exit = userMethod(user);
            } else {
                //exit = managerMethod(manager);
            }
        }
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
    public static Boolean technicianMethod(Technician technician) throws IOException {
        System.out.println(getTicketsCsv() + "\n");
        return  true;
    }
}
