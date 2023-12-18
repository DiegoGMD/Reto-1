import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String Divider = "-------------------------------------------------------------------------------------------";
    public static void main(String[] args) throws IOException {
        Ticket ticket = new Ticket();
        ticket.setId();

        List<User> users = new ArrayList<>();
        List<Technician> technicians = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();
        users = CsvHandler.getUsersCsv();
        technicians = CsvHandler.getTechniciansCsv();
        managers = CsvHandler.getManagerCsv();
        boolean exit = false;
        while (!exit) {
            User user = null;
            Technician technician = null;
            Manager manager = null;
            boolean selectUser = false;
            while (!selectUser) {
                System.out.println(Divider);
                System.out.println("Welcome to the Ticket Management System, please write the name of your user:");
                String nameUser = Global.inputKeyboard.next();
                if (nameUser.toUpperCase().equals("CREATE")) {
                    CsvHandler.writeUsersCsv(users);
                } else {
                    List<User> usersByName = Global.getUsers(nameUser, users);
                    List<Technician> techniciansByName = Global.getTechnicians(nameUser, technicians);
                    List<Manager> managersByName = Global.getManagers(nameUser, managers);
                    int index = 1;
                    System.out.println(Divider);
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
                    if (usersByName.isEmpty() && techniciansByName.isEmpty() && managersByName.isEmpty()) {
                        System.out.println("That user doesn't exist try again");
                    } else {
                        System.out.println(Divider);
                        System.out.println("Input the name of the number of the User of technician you want to use");
                        int numIndex = Global.inputKeyboard.nextInt();
                        System.out.println(Divider);
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

            }
            if (technician != null) {
                exit = technicianMethod(technician);
            } else if (user != null) {
                exit = userMethod(user);
            } else {
        exit = managerMethod(manager);
    }
            System.out.println("If you want to Exit press 1, if you want to login with another user press other key");
    String strExit = Global.inputKeyboard.next();
            if (strExit.equals("1")) {
        exit = true;
    } else {
        exit = false;
    }

}



    }

    public static Boolean managerMethod(Manager manager) throws IOException {
        boolean b = true;
        while (b) {
            System.out.println("What you want to do: Consult(1), Modify(2), Create(3) or Exit(4)?");
            String option = Global.inputKeyboard.next();
            String option2;
            if (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")) {
                System.out.println("Please enter a valid option");
            } else if (option.equals("1")) {
                System.out.println("You want to consult requests(1) or tickets(2)?");
                option2 = Global.inputKeyboard.next();
                if (!option2.equals("1") && !option2.equals("2")) {
                    System.out.println("Please enter a valid option");
                } else if (option2.equals("1")) {
                    for (ActionRequest requests : CsvHandler.getPetitionsCsv()) {
                        System.out.println(requests);
                    }
                } else {
                    for (Ticket tickets : CsvHandler.getTicketsCsv()) {
                        System.out.println(tickets);
                    }
                }
            } else if (option.equals("2")) {
                System.out.println("You want to modify requests(1) or tickets(2)?");
                option2 = Global.inputKeyboard.next();
                if (!option2.equals("1") && !option2.equals("2")) {
                    System.out.println("Please enter a valid option");
                } else if (option2.equals("1")) {
                    List<ActionRequest> requests = CsvHandler.getPetitionsCsv();
                    System.out.println("Which request do you want to modify?");
                    int idRequest = Global.inputKeyboard.nextInt();
                    while (true) {
                        for (ActionRequest request : requests) {
                            if (idRequest == request.getId_request()) {
                                System.out.println("What do you want to modify: ID_Category(1), Title(2), Description(3), Inventory(4) or EXIT(5)?");
                                int modifyOption = Global.inputKeyboard.nextInt();
                                switch (modifyOption) {
                                    default:
                                        System.out.println("Please enter a valid option");
                                        break;
                                    case 1:
                                        request.setId_category(Category.selectCategory());
                                        break;
                                    case 2:
                                        request.setTitle();
                                        break;
                                    case 3:
                                        request.setDescription();
                                        break;
                                    case 4:
                                        ActionRequest.selectArticle();
                                        break;
                                    case 5:
                                        return false;
                                }
                                CsvHandler.writePetitionCsv(requests);
                            }
                        }
                    }
                } else {
                    List<Ticket> tickets = CsvHandler.getTicketsCsv();
                    System.out.println("Which ticket do you want to modify?");
                    int idTicket = Global.inputKeyboard.nextInt();
                    while (true) {
                        for (Ticket ticket : tickets) {
                            if (idTicket == ticket.getId()) {
                                System.out.println("What do you want to modify: Title(1), Description(2), Technician DNI(3), State(4) or EXIT(5)?");
                                int modifyOption = Global.inputKeyboard.nextInt();
                                switch (modifyOption) {
                                    default:
                                        System.out.println("Please enter a valid option");
                                        break;
                                    case 1:
                                        ticket.setTitle();
                                        break;
                                    case 2:
                                        ticket.setDescription();
                                        break;
                                    case 3:
                                        ticket.setDni_technician(Technician.selectTechnician());
                                        break;
                                    case 4:
                                        ticket.setState();
                                        break;
                                    case 5:
                                        return false;
                                }
                                CsvHandler.writeTicketsCsv(tickets);
                            }
                        }
                    }
                }
            } else if (option.equals("3")) {
                List<ActionRequest> petitions = CsvHandler.getPetitionsCsv();
                System.out.println("You want to create request(1) or ticket(2)?");
                option2 = Global.inputKeyboard.next();
                if (!option2.equals("1") && !option2.equals("2")) {
                    System.out.println("Please enter a valid option");
                } else if (option2.equals("1")) {
                    makePetitionsManager(manager, petitions);
                } else {
                    List<Ticket> tickets = CsvHandler.getTicketsCsv();
                    Ticket ticket = new Ticket();
                    ticket.setId();
                    System.out.println("Which technician do you want to assign it to?");
                    ticket.setDni_technician(Technician.selectTechnician());
                    ticket.setDni_manager(manager.getDNI());
                    System.out.println("Which petition is referencing this ticket?");
                    ticket.setId_petition(ActionRequest.selectActionRequest());
                    ticket.setState();
                    ticket.setTitle();
                    ticket.setDescription();
                    System.out.println(ticket);
                    tickets.add(ticket);
                    CsvHandler.writeTicketsCsv(tickets);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static Boolean userMethod(User user) throws IOException {
        List<ActionRequest> petitions = CsvHandler.getPetitionsCsv();
        boolean b =true;
        while (b) {
            System.out.println( "Please enter any option: (1) View petitions (2) Make petitions (3) EXIT");
            String option = Global.inputKeyboard.next();
            if (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
                System.out.println("Please enter a valid option");
            } else if (option.equals("1")) {
                for (ActionRequest petition : petitions) {
                    if (petition.getId_user().equals(user.getDNI())){
                        System.out.println(petition);
                    }
                }
            } else if (option.equals("2")) {
                makePetitionsUser(user, petitions);
            } else if (option.equals("3")) {
                return false;
            }
        }
        return true;
    }

    private static void makePetitionsUser(User user, List<ActionRequest> petitions) throws IOException {
        int cod_category = Category.selectCategory();
        System.out.println("Write the title of the petition according to the id request: ");
        Global.inputKeyboard.nextLine();
        String title = Global.inputKeyboard.nextLine();
        System.out.println("Write a short description of the problem");
        String description = Global.inputKeyboard.nextLine();
        String article = ActionRequest.selectArticle();
        ActionRequest petition = new ActionRequest(ActionRequest.setId(), cod_category, user.getDNI(),title, description,article);
        System.out.println(petition);
        petitions.add(petition);
        CsvHandler.writePetitionCsv(petitions);
    }

    private static void makePetitionsManager(Manager manager, List<ActionRequest> petitions) throws IOException {
        int cod_category = Category.selectCategory();
        System.out.println("Write the title of the petition according to the id request: ");
        Global.inputKeyboard.nextLine();
        String title = Global.inputKeyboard.nextLine();
        System.out.println("Write a short description of the problem");
        String description = Global.inputKeyboard.nextLine();
        String article = ActionRequest.selectArticle();
        ActionRequest petition = new ActionRequest(ActionRequest.setId(), cod_category, manager.getDNI(),title, description,article);
        System.out.println(petition);
        petitions.add(petition);
        CsvHandler.writePetitionCsv(petitions);
    }

    public static Boolean technicianMethod(Technician technician) throws IOException {
        boolean exit = false;
        while (!exit) {
            List<Ticket> tickets = CsvHandler.getTicketsCsv();
            Scanner scan = new Scanner(System.in);
            String text = "";
            if (tickets.isEmpty()) {
                System.out.println("No tickets available.");
            } else {
                System.out.println("Your Tickets:");
                for (Ticket ticket : tickets) {
                    if (ticket.getDni_technician().contains(technician.getDNI())) {
                        System.out.println(ticket);
                    }
                }
                System.out.println(Divider);
                System.out.println("Do you want to edit one of your tickets?" + "\n" + "Type: Y or N");
                text = scan.nextLine().toUpperCase();
                if (text.equals("Y")) {
                    text = "";
                    System.out.println(Divider);
                    System.out.println("Tell me the ID of the ticket");
                    text = scan.nextLine();
                    System.out.println(Divider);
                    System.out.println("You have selected the ticket with the ID " + text);
                    boolean entered = false;
                    for (Ticket ticket : tickets) {
                        if (ticket.getDni_technician().contains(technician.getDNI())) {
                            if (ticket.getId() == Integer.parseInt(text)) {
                                System.out.println(ticket);
                                System.out.println(Divider);
                                ticket.setState();
                                System.out.println(Divider);
                                System.out.println("Introduce an explanation of how you solved the problem");
                                text = scan.nextLine();
                                System.out.println(Divider);
                                ticket.setSolution(text);
                                System.out.println("Result:" + "\n" + ticket);
                                entered = true;
                            }

                        }
                    }
                    if (!entered) {
                        System.out.println("You don't have a ticket with that id assigned to you");
                    } else {
                        CsvHandler.writeTicketsCsv(tickets);
                    }
                } else {
                    exit = true;
                }
            }
        }


        return  true;
    }


}
