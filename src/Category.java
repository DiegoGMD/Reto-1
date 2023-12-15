import java.io.IOException;
import java.util.List;

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
//-------------------------------Methods----------------------------------------------------//
    public static int selectCategory() throws IOException {
        int cod_category = -1;

        List<Category> categories = CsvHandler.makeCategoryCsv();
        System.out.println("Categories:");
        for (Category category1 : categories) {
            System.out.println(category1);
        }
        Boolean correct = false;
        System.out.println("Please enter id_request :");
        cod_category = Global.inputKeyboard.nextInt();
        while (!correct){
            if (cod_category > 15 || cod_category < 1){
                System.out.println("Enter a valid option" + "\n" + "Please enter id_request :");
                cod_category = Global.inputKeyboard.nextInt();
            } else {
                correct = true;
            }
        }
        return cod_category;
    }
//-------------------------------Getters----------------------------------------------------//
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
        return s += "( " + cod_category + " ) " + category;
  }
}
