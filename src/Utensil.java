import java.util.Objects;

public class Utensil {
    private String type;
    private int number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utensil utensil = (Utensil) o;
        return number == utensil.number &&
                Objects.equals(type, utensil.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }
}
