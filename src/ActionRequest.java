import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ActionRequest {
    private int id_request;
    private int id_category;
    private String id_user;
    private String title;
    private String description;
    private String article;

    //------------------------------------Constructor-----------------------------------------//
    public ActionRequest(int id_request, int id_category, String id_user, String title,
                         String description, String article) {
        this.id_request = id_request;
        this.id_category = id_category;
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.article = article;
    }

    public ActionRequest() {
        id_request = -1;
        id_category = -1;
        id_user = "";
        title = "";
        description = "";
        article = "";
    }
//------------------------------------Getters---------------------------------------------//

    public int getId_request() {
        return id_request;
    }

    public int getId_category() {
        return id_category;
    }

    public String getId_user() {
        return id_user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static String getArticle() throws IOException {
            String s = "";
            boolean b = false;
            while (!b) {
                b = true;
                System.out.println("Choose the code of the Hardware involved");
                System.out.println(CsvHandler.makeInventory());
                String cod_article = Global.inputKeyboard.nextLine();
                switch (cod_article) {
                    case "1":
                        s += "Server";
                        break;
                    case "2":
                        s += "Router";
                        break;
                    case "3A":
                        s += "Switch_Sales";
                        break;
                    case "3B":
                        s += "Switch_Marketing";
                        break;
                    case "3C":
                        s += "Switch_Accounting";
                        break;
                    case "3D":
                        s += "Switch_Administrative";
                        break;
                    case "4A.1":
                        s += "Tower_Sales";
                        break;
                    case "4B.1":
                        s += "Tower_Marketing";
                        break;
                    case "4C.1":
                        s += "Tower_Accounting";
                        break;
                    case "4D.1":
                        s += "Tower_Administrative";
                        break;
                    case "5A.1":
                        s += "Monitor_Sales";
                        break;
                    case "5B.1":
                        s += "Monitor_Marketing";
                        break;
                    case "5C.1":
                        s += "Monitor_Accounting";
                        break;
                    case "5D.1":
                        s += "Monitor_Administrative";
                        break;
                    case "6A.1":
                        s += "MouseKeyboard_Sales";
                        break;
                    case "6B.1":
                        s += "MouseKeyboard_Marketing";
                        break;
                    case "6C.1":
                        s += "MouseKeyboard_Accounting";
                        break;
                    case "6D.1":
                        s += "MouseKeyboard_Administrative";
                        break;
                    default:
                        System.out.println("Please enter a valid option");;
                        b = false;
                }
            }
        return s;
    }

    //-----------------------------------Setters----------------------------------------------//
    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setTitle() {
        System.out.println("Write below the ActionRequest title:");
        this.title = Global.inputKeyboard.nextLine();
    }

    public void setDescription() {
        System.out.println("Write below the ActionRequest description:");
        this.description = Global.inputKeyboard.nextLine();
    }

    public void setArticle(String article) {
        this.article = article;
    }

    //------------------------------ToString----------------------------------------------------//
    @Override
    public String toString() {
        String s = "";
        return s+= "ID_Request: " + id_request + "\n" +
                "ID-Category: " + id_category + "\n" +
                "ID_User: " + id_user + "\n" +
                "Title: " + title + "\n" +
                "Description: " + description + "\n" +
                "Article: " + article + "\n";
    }
}
