import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPruebaUser {
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

    public static Boolean managerMethod(Manager manager) {
        return true;
    }

    public static Boolean userMethod(User user) throws IOException {
        List<ActionRequest> petitions = CsvHandler.getPetitionsCsv();
        boolean b =true;
        int IDPetition = 5;
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
                makePetitions(user, IDPetition, petitions);
                IDPetition ++;
            } else if (option.equals("3")) {
                return false;
            }
        }
        return true;
    }

    private static void makePetitions(User user, int IDPetition, List<ActionRequest> petitions) throws IOException {
        int cod_category = Category.selectCategory();
        System.out.println("Write the title of the petition accodring to the id request: ");
        Global.inputKeyboard.nextLine();
        String title = Global.inputKeyboard.nextLine();
        System.out.println("Write a short description of the problem");
        String description = Global.inputKeyboard.nextLine();
        String article = ActionRequest.selectArticle();
        ActionRequest petition = new ActionRequest(IDPetition, cod_category, user.getDNI(),title, description,article);
        System.out.println(petition);
        petitions.add(petition);
        CsvHandler.writePetitionCsv(petitions);
    }

    public static Boolean technicianMethod(Technician technician) {
        return true;
    }

}



