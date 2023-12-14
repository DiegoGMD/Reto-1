public class ActionRequest {
    private int id_request;
    private int id_category;
    private int id_user;
    private String title;
    private String description;
    private String article;

    public ActionRequest (int id_request, int id_category, int id_user, String title,
                          String description, String article) {
        this.id_request = id_request;
        this.id_category = id_category;
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.article = article;
    }
}
