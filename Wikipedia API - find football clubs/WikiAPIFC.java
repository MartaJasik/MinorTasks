import java.io.IOException;
import java.net.URL;
import java.util.*;
import org.json.JSONObject;


public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("Type FC name you want to get an Wiki URL for:");
        Scanner scan = new Scanner(System.in);
        String nameInput = scan.nextLine();

        while (!nameInput.equals("quit")) {
            System.out.println(getTheRightUrl(nameInput));
            System.out.println("Type another FC name, or \"quit\" if you're done with the search.");
            nameInput = scan.nextLine();
        }
    }

    public static String getTheRightUrl(String nameToLookFor) throws IOException {
        ArrayList<JSONObject> jsonResults = getTheJSONResults(nameToLookFor);

        for (JSONObject object : jsonResults) {
            String snippet = object.getString("snippet").toLowerCase();
            String title = object.getString("title");

            if (snippet.contains("football club") || title.contains("FC") || title.contains("F.C.")) { //not all the FCs have "football club" in their snippets - e.g. FC Barcelona has "Futbol Club" only.
                return appendFCNameToWikiUrl(object);
            }
        }
        return "\"" + nameToLookFor + "\" FC not found on first 10 Wiki pages";
    }


    public static String appendFCNameToWikiUrl(JSONObject object) {
        String titleForUrl = object.getString("title").replace(' ', '_');
        return ("https://en.wikipedia.org/wiki/" + titleForUrl);
    }


    public static ArrayList<JSONObject> getTheJSONResults(String nameToLookFor) throws IOException {
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&list=search&format=json&srsearch=%22" + nameToLookFor + "%22&srlimit=10");

        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine();
        }
        scan.close();

        ArrayList<String> results = new ArrayList<>(Arrays.asList(str.split("\\{\"ns\":0,")));
        ArrayList<JSONObject> resultsJSON = new ArrayList<>();

        for (int i = 1; i < results.size(); i++) {
            resultsJSON.add(new JSONObject("{" + results.get(i)));
        }
        return resultsJSON;
    }

}