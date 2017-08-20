public class LeftPad {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        if (originalStr.length() >= size) {
            return originalStr;
        } else {
            int more = size - originalStr.length();
            String pad = "";
            for(int i = 0; i < more; i++) {
                pad = pad + " ";
            }
            return pad + originalStr;
        }
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        if (originalStr.length() >= size) {
            return originalStr;
        } else {
            int more = size - originalStr.length();
            String pad = "";
            for(int i = 0; i < more; i++) {
                pad = pad + padChar;
            }
            return pad + originalStr;
        }
    }

    public static void main (String[] args) {
        System.out.println(LeftPad.leftPad("foo", 5));
        System.out.println(LeftPad.leftPad("foobar", 6));
        System.out.println(LeftPad.leftPad("1", 2, '0'));
    }


}
