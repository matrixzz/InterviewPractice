import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RegEx {
    final static Scanner scan = new Scanner(System.in);
    final static String fileName = System.getenv("OUTPUT_PATH");


    /*
     * Write the regular expression in the blank space below
     */
    // It should be "^([a-z]{1,6})(_{0,1}|_[0-9]{1,4})@hackerrank.com$"
    final static String regularExpression = "^([a-z]{1,6})(_{0,1}[0-9]{0,4})@hackerrank.com$";


    public static void main(String[] args) throws IOException {
        int query = Integer.parseInt(scan.nextLine());
        String[] result = new String[query];
        Arrays.fill(result, "False");

        for (int i = 0; i < query; i++) {
            String someString = scan.nextLine();

            if (someString.matches(regularExpression)) {
                result[i] = "True";
            }
        }

        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
        for (String res: result) {
            fileOut.write(res + "\n");
        }

        fileOut.close();
    }
}