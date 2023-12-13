public class Inventory {
    private String cod_serie;
    private String articles;

    public Inventory(String cod_serie, String articles) {
        this.cod_serie = cod_serie;
        this.articles = articles;
    }

    public String getCod_serie() {
        return cod_serie;
    }

    public void setCod_serie(String cod_serie) {
        this.cod_serie = cod_serie;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }
}

