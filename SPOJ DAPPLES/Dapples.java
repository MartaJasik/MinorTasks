import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dapples {

    final static int gravity = 10;
    final static int yearsToPlanCuttingFor = 20;
    final static int ageToStopGrowing = 20;
    final static int maxPersonHeight = 250;

    public static void main(String[] args) {

        List<TestSet> testSets = transformInputIntoObjects();

        for (int i = 0; i < testSets.size(); i++) {
            StringBuilder results = new StringBuilder();
            int currentSet = i + 1;
            results.append("Set " + currentSet + "\n" + "\n");

            List<Citizen> citizenList = testSets.get(i).getCitizenList();

            for (int j = 0; j <= yearsToPlanCuttingFor; j++) {
                int shortestPersonHeight = maxPersonHeight;

                for (Citizen citizen : citizenList) {
                    int currentAge = citizen.getAge() + j;
                    int currentHeight = citizen.getHeight();

                    if ((currentAge < ageToStopGrowing) && (j > 0)) {
                        currentHeight += citizen.getGrowth();
                        citizen.setHeight(currentHeight);
                    }

                    if (currentHeight < shortestPersonHeight) {
                        shortestPersonHeight = currentHeight;
                    }
                }

                int treeCutHeight = shortestPersonHeight + testSets.get(i).getMaxHeightDifference();
                results.append(j + ": " + treeCutHeight + "\n");
            }

            printSetsToFile(currentSet, results);
            System.out.println(results.toString());
        }
    }

    public static List<TestSet> transformInputIntoObjects() {
        List<TestSet> testSets = new ArrayList<>();
        File file = new File("dapplesInput.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                int numOfSets = scan.nextInt();
                while (numOfSets > 0) {
                    TestSet testSet = new TestSet();
                    int v = scan.nextInt();
                    testSet.setV(v);
                    int numOfCitizens = scan.nextInt();
                    testSet.setNumOfCitizens(numOfCitizens);
                    List<Citizen> citizenList = new ArrayList<>();
                    while (numOfCitizens > 0) {
                        Citizen citizen = new Citizen();
                        citizen.setHeight(scan.nextInt());
                        citizen.setAge(scan.nextInt());
                        citizen.setGrowth(scan.nextInt());
                        citizenList.add(citizen);
                        numOfCitizens--;
                    }
                    testSet.setCitizenList(citizenList);
                    testSet.setMaxHeightDifference((int) (0.5 * gravity * Math.pow((double) v / gravity, 2) * 100));

                    testSets.add(testSet);
                    numOfSets--;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NoSuchElementException e) {
            System.out.println("Error in your file detected");
        }

        return testSets;

    }

    public static void printSetsToFile(int setNo, StringBuilder results) {
        try {
            PrintWriter printWriter = new PrintWriter("set" + setNo + "Output.txt");
            printWriter.println(results);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Saving error");
        }
    }

}