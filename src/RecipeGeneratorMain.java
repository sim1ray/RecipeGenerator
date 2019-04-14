import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeGeneratorMain{

  public static void main(String[] args) {
    Trie ingredientList = new Trie();
    File excelFile = new File("/Users/simone/IdeaProjects/RecipeGenerator/IngredientList.csv");
    Scanner reader;
    try {
      reader = new Scanner(excelFile);
      while (reader.hasNext()) {
        ingredientList.insert(reader.next(), reader.nextInt());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    //System.out.println(ingredientList.search("chicken-broth"));

    boolean[][] inRecipe = new boolean[100][100];
    String[] recipes = new String[100];


    excelFile = new File("/Users/simone/IdeaProjects/RecipeGenerator/Recipes.csv");
    try {
      reader = new Scanner(excelFile);
      int index = 0;
      while (reader.hasNext()) {
        recipes[index] = reader.nextLine();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    excelFile = new File("/Users/simone/IdeaProjects/RecipeGenerator/Ingredients.csv");
    try {
      reader = new Scanner(excelFile);
      String input;
      Scanner lineInput;
      int index = 0;
      int value = -1;
      while (reader.hasNextLine()) {
        input = reader.nextLine();
        lineInput = new Scanner(input);
        lineInput.useDelimiter(",");
        while (lineInput.hasNext()) {
          value = ingredientList.search(lineInput.next());
          if(value > 0) {
            inRecipe[index][value] = true;
          }
          lineInput.nextDouble();
          lineInput.next();
        }
        index++;
        lineInput.close();
      }

      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < 100; i++) {
      for(int j = 0; j < 100; j++) {
        if (inRecipe[i][j])
          System.out.print(j);
        else
          System.out.print(' ');
      }
      System.out.println();
    }
  }
}
