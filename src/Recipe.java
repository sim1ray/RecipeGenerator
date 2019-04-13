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

}
