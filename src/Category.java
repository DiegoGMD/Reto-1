public class Category {
    private String category;
    private int cod_category;

//------------------------------Constructor-------------------------------------------------//
    public Category (int cod_category, String category) {
    this.cod_category = cod_category;
    this.category = category;
    }

    public Category () {
        cod_category = -1;
        category = "";
    }

//-------------------------------Getters----------------------------------------------------//
    public String getCategory() {
        return category;
    }

    public int getCod_category() {
        return cod_category;
    }
//--------------------------------Setters---------------------------------------------------//
    public void setCategory(String category) {
        this.category = category;
    }

    public void setCod_category(int cod_category) {
        this.cod_category = cod_category;
    }
//----------------------------------ToString------------------------------------------------//
  @Override
    public String toString () {
        String s = "";
        return s += "( " + cod_category + " ) " + category + "\n";
  }
}
