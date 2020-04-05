import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {

        final Map<String, Operation> calculations = new HashMap<String, Operation>();

        calculations.put("+", new Operation() {
            public int calculate(int a, int b) {
                return a + b;
            }
        });
        calculations.put("-", new Operation() {
            public int calculate(int a, int b) {
                return a - b;
            }
        });
        calculations.put("*", new Operation() {
            public int calculate(int a, int b) {
                return a * b;
            }
        });
        calculations.put("/", new Operation() {
            public int calculate(int a, int b) {
                return a / b;
            }
        });
        calculations.put("%", new Operation() {
            public int calculate(int a, int b) {
                return a % b;
            }
        });

        File file = new File("toCalculate.txt");
        StringBuilder results = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String[] lineElements = scan.nextLine().split(" ");
                int res = calculations.get(lineElements[0]).calculate(Integer.parseInt(lineElements[1]), Integer.parseInt(lineElements[2]));
                results.append(res + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        printResultsToFile(results);
        System.out.println(results);

    }

    public static void printResultsToFile(StringBuilder results) {
        try {
            PrintWriter printWriter = new PrintWriter("results.txt");
            printWriter.println(results);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Saving error");
        }
    }

}