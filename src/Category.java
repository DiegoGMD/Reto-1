import java.io.IOException;

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
    public static int getCategory() throws IOException {
        int cod_category = -1;
        boolean b = false;
        while (!b) {
            System.out.println("Please enter id_request :");
            System.out.println(CsvHandler.makeCategoryCsv());
            cod_category = Global.inputKeyboard.nextInt();
            switch (cod_category) {
                case 1:
                    cod_category = 1;
                    break;
                case 2:
                    cod_category = 2;
                    break;
                case 3:
                    cod_category = 3;
                    break;
                case 4:
                    cod_category = 4;
                    break;
                case 5:
                    cod_category = 5;
                    break;
                case 6:
                    cod_category = 6;
                    break;
                case 7:
                    cod_category = 7;
                    break;
                case 8:
                    cod_category = 8;
                    break;
                case 9:
                    cod_category = 9;
                    break;
                case 10:
                    cod_category = 10;
                    break;
                case 11:
                    cod_category = 11;
                    break;
                case 12:
                    cod_category = 12;
                    break;
                case 13:
                    cod_category = 13;
                    break;
                case 14:
                    cod_category = 14;
                    break;
                case 15:
                    cod_category = 15;
                    break;
                default:
                    System.out.println("Enter a valid option");
                    b = false;
            }
        }
        return cod_category;
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
