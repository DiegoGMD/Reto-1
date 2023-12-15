import java.io.IOException;
import java.util.List;

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

    public String getArticle() {
        return article;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    //------------------------------ToString----------------------------------------------------//
    @Override
    public String toString() {
        String s = "";
        return s+= "ID_Request: " + getId_request() + "\n" +
                "ID-Category: " + getId_category() + "\n" +
                "ID_User: " + getId_user() + "\n" +
                "Title: " + getTitle() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Article: " + getArticle() + "\n";
    }
}
