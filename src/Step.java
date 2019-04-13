import java.util.ArrayList;
import java.util.Objects;

public class Step {
    private String name;
    private ArrayList<String> details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(name, step.name) &&
                Objects.equals(details, step.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, details);
    }
}
