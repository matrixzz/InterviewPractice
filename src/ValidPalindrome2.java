import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidPalindrome2 {

    public static boolean isValid(String s) {
        boolean flag = true;
        if (s == null || s.length() == 2) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            if (s.charAt(front) != s.charAt(end)) {
                if (flag) {
                    front++;
                    flag = !flag;
                } else {
                    break;
                }
            } else {
                front++;
                end--;
            }
        }

        if (end > front && !flag) {
            front = 0;
            end = s.length() - 1;
            flag = true;
            while (front < end) {
                if (s.charAt(front) != s.charAt(end)) {
                    if (flag) {
                        end--;
                        flag = !flag;
                    } else {
                        break;
                    }
                } else {
                    front++;
                    end--;
                }
            }
        }

        return end <= front;
    }

//    private static void print(List<Character> arr2) {
//        for(int i = 0; i < arr2.size(); i++) {
//            System.out.print(arr2.get(i));
//        }
//        System.out.println();
//    }
//
//    private static boolean isvalid(char c) {
//        return Character.isLetter(c) || Character.isDigit(c);
//    }

    public static void main(String[] args) {
        String s = "acbcea";
        System.out.println(ValidPalindrome2.isValid(s));
    }
}
