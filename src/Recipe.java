import java.util.ArrayList;

public class Recipe {
    ArrayList<Ingredient> ingredients;
    ArrayList<Step> steps;
    Time t;
    Servings s;
    Elements el;

    public Recipe(ArrayList<Ingredient> ingredients, ArrayList<Step> steps, Time t, Servings s, Elements el) {
        this.ingredients = ingredients;
        this.steps = steps;
        this.t = t;
        this.s = s;
        this.el = el;
    }

    public void readInTimes(String filePath){
      File excelFile = new File(filePath);
      Scanner input = new Scanner(excelFile);
      Scanner line;
      String value;
      Strin time;
      while(input.hasNextLine()){
        value = input.nextLine();
        line = new Scanner(value);
        t.setPrepTime(line.next());
        t.setCookTime(line.next());
      }
    }

}
