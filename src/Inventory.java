public class Inventory {
    private String cod_serie;
    private String articles;
//----------------Constructor--------------------------------------------------------------//
    public Inventory(String cod_serie, String articles) {
        this.cod_serie = cod_serie;
        this.articles = articles;
    }
//----------------------------Getters------------------------------------------------------//
    public String getCod_serie() {
        return cod_serie;
    }

    public String getArticles() {
        return articles;
    }
    //-------------------------Setters----------------------------------------------------//
    public void setCod_serie(String cod_serie) {
        this.cod_serie = cod_serie;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }
}

