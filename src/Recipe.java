import java.util.ArrayList;

public class Recipe {
    private ArrayList<Step> steps;
    private Time t;
    private Serving s;
    private ArrayList<Element> el;

    public Recipe() {
        this.steps = null;
        this.t = null;
        this.s = null;
        this.el = null;
    }

    public Recipe(ArrayList<Step> steps, Time t, Serving s, ArrayList<Element> el) {
        this.steps = steps;
        this.t = t;
        this.s = s;
        this.el = el;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public Time getT() {
        return t;
    }

    public void setT(Time t) {
        this.t = t;
    }

    public Serving getS() {
        return s;
    }

    public void setS(Serving s) {
        this.s = s;
    }

    public ArrayList<Element> getEl() {
        return el;
    }

    public void setEl(ArrayList<Element> el) {
        this.el = el;
    }

}
