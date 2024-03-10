public class Library {
    public static int str2Int(String str) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            } else {
                throw new NumberFormatException("Invalid input: " + str);
            }
        }
        return result;
    }

    public static String thousandSeparator(int num) {
        String numStr = Integer.toString(num);
        StringBuilder formatted = new StringBuilder();
        int count = 0;
        for (int i = numStr.length() - 1; i >= 0; i--) {
            formatted.insert(0, numStr.charAt(i));
            count++;
            if (count % 3 == 0 && i > 0) {
                formatted.insert(0, '.');
            }
        }
        return formatted.toString();
    }

    public static boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

    public static String makeFancyString(String s) {
        StringBuilder fancy = new StringBuilder();
        int count = 1;
        fancy.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count = 1;
                fancy.append(s.charAt(i));
            } else if (count < 2) {
                count++;
                fancy.append(s.charAt(i));
            }
        }
        return fancy.toString();
    }

    public static String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder capitalizedTitle = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedTitle.append(word).append(" ");
            }
        }
        return capitalizedTitle.toString().trim();
    }
}
