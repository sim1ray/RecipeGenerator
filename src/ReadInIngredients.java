import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadInIngredients {
  public ArrayList<Recipe> readIn(String filePath, ArrayList<Recipe> recipes) {
    File excelFile = new File(filePath);
    Scanner reader;
    try {
      reader = new Scanner(excelFile);
      String input;
      Scanner lineInput;
      int index = 0;
      while (reader.hasNextLine()) {
        input = reader.nextLine();
        lineInput = new Scanner(input);
        lineInput.useDelimiter(",");
        while (lineInput.hasNext()) {
          ArrayList<Ingredient> in = new ArrayList<>();
          for (int i = 0; i < 3; i++) {
            String name = lineInput.next();
            double amt = lineInput.nextDouble();
            String unit = lineInput.next();
            Ingredient newIng = new Ingredient(name, amt, unit);
            in.add(newIng);
          }

          if (recipes.get(index) == null) {
//            recipes.get(index).setIngredients(in);
            index++;
            lineInput.close();
          }
        }
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return recipes;
  }


  /*private Day[] trimArray(Day[] array, int length) {
    Day[] newArray = new Day[length];
    int index = 0;
    while (index < length) {
      newArray[index] = array[index];
      index++;
    }
    return newArray;
  }*/
}
