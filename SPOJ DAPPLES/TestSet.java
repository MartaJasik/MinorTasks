import java.util.List;

public class TestSet {
    private int v;
    private int maxHeightDifference;
    private int numOfCitizens;
    private List<Citizen> citizenList;

    public TestSet() {
    }

    public TestSet(int v, int maxHeightDifference, int numOfCitizens, List<Citizen> citizenList) {
        this.v = v;
        this.maxHeightDifference = maxHeightDifference;
        this.numOfCitizens = numOfCitizens;
        this.citizenList = citizenList;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getMaxHeightDifference() {
        return maxHeightDifference;
    }

    public void setMaxHeightDifference(int maxHeightDifference) {
        this.maxHeightDifference = maxHeightDifference;
    }

    public int getNumOfCitizens() {
        return numOfCitizens;
    }

    public void setNumOfCitizens(int numOfCitizens) {
        this.numOfCitizens = numOfCitizens;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }

    @Override
    public String toString() {
        return "TestSet{" +
                "v=" + v +
                ", maxHeightDifference=" + maxHeightDifference +
                ", numOfCitizens=" + numOfCitizens +
                ", citizenList=" + citizenList +
                '}';
    }
}
