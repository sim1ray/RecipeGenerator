import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RecipeGeneratorMain{

  public static Trie createIngredientList() {
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
    return ingredientList;
  }

  public static String[] createRecipeArray() {
    String[] recipes = new String[50];

    File excelFile = new File("/Users/simone/IdeaProjects/RecipeGenerator/Recipes.csv");
    Scanner reader;
    try {
      reader = new Scanner(excelFile);
      int index = 0;
      while (reader.hasNext()) {
        recipes[index] = reader.nextLine();
        index++;
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return recipes;
  }

  public static boolean[][] createTwoDimArray() {
    Trie ingredientList = createIngredientList();
    boolean[][] inRecipe = new boolean[50][50];

    Scanner reader;
    File excelFile = new File("/Users/simone/IdeaProjects/RecipeGenerator/Ingredients.csv");
    try {
      reader = new Scanner(excelFile);
      String input;
      Scanner lineInput;
      int index = 0;
      int value = -1;
      String s;
      while (reader.hasNextLine()) {
        input = reader.nextLine();
        lineInput = new Scanner(input);
        lineInput.useDelimiter(",");
        while (lineInput.hasNext()) {
          s = lineInput.next();
          s = s.replace('\ufeff',' ').trim();
          value = ingredientList.search(s);
          if(value > -1) {
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

//    //TEST
//    for (int i = 0; i < 100; i++) {
//      for(int j = 0; j < 100; j++) {
//        if (inRecipe[i][j])
//          System.out.print('*');
//        else
//          System.out.print(' ');
//      }
//      System.out.println();
//    }
    return inRecipe;

  }

  public static String outputRecipe(String[] ingredients) {
    Trie ingredientList = createIngredientList();
    String[] recipes = createRecipeArray();
    int[] recipeIndex = new int[50];
    boolean[][] inRecipe = createTwoDimArray();
    int[] ingredientIndexes = new int[ingredients.length];

    for (int i = 0; i < ingredients.length; i++) {
      ingredientIndexes[i] = ingredientList.search(ingredients[i]);
    }

    for(int i = 0; i < ingredientIndexes.length; i++) {
      int index = ingredientIndexes[i];
      for(int j = 0; j < 50; j++) {
        if(inRecipe[j][index])
          recipeIndex[j]++;
      }
    }

    int max = 0;
    String result = "";
    for(int i = 0; i < 50; i++) {
      if (recipeIndex[i] > max) {
        result = recipes[i];
        max = recipeIndex[i];
      }
    }
    return result + " is the dish you can make using the most ingredients from your kitchen!";
  }

  public static void main(String[] args) {
    String[] ingredients = {"butter", "beef", "bread", "lettuce"};
    System.out.println(outputRecipe(ingredients));

  }


}
