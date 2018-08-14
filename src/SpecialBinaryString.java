import com.google.gson.Gson;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SpecialBinaryString {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        Gson gson = new Gson();
        return gson.fromJson(input, String.class).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);

            String ret = new Solution().makeLargestSpecial(S);

            String out = (ret);

            System.out.print(out);
        }
    }

    static class Solution {
        public String makeLargestSpecial(String S) {
            int count = 0, i = 0;

            List<String> res = new ArrayList<String>();
            for (int j = 0; j < S.length(); ++j) {
                if (S.charAt(j) == '1') count++;
                else count--;
                if (count == 0) {
                     System.out.println("i = " + i);
                     System.out.println("j = " + j);
                    res.add('1' + makeLargestSpecial(S.substring(i + 1, j)) + '0');
                     System.out.println("string: " + '1' + S.substring(i + 1, j) + '0');
                    i = j + 1;
                }
            }

            HashMap<Integer, Integer> map = new HashMap<>();

            Collections.sort(res, Collections.reverseOrder());
            // System.out.println(res.size());
            // for (String s : res) {
            //     System.out.println(s);
            // }
            // System.out.println(String.join("", res));
            return String.join("", res);
        }
    }
}