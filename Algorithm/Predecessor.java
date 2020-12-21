package Algorithm;

public class Predecessor {
    private int parent;
    private float weight;

    public int getParent() {
        return parent;
    }

    public float getWeight() {
        return weight;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String toString() {
        return " from city " + parent + " with weight " + weight;
    }
}
