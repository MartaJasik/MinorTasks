public class Citizen {

    private int height;
    private int age;
    private int growth;

    public Citizen() {
    }

    public Citizen(int height, int age, int growth) {
        this.height = height;
        this.age = age;
        this.growth = growth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "height=" + height +
                ", age=" + age +
                ", growth=" + growth +
                '}';
    }
}
