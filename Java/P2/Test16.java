import java.util.Scanner;

public class Test16 {
    public static void main(String [] args){
        int score = 0;

        // Testing Library.str2Int
        int result1 = Library.str2Int("435065");
        int expected1 = 435065;
        if (result1 == expected1) score += 10;

        // Testing Library.thousandSeparator
        String result2 = Library.thousandSeparator(24435065);
        String expected2 = "24.435.065";
        if (result2.equals(expected2)) score += 10;

        // Testing Library.detectCapitalUse
        boolean result3 = Library.detectCapitalUse("Google");
        boolean expected3 = true;
        if (result3 == expected3) score += 10;

        boolean result4 = Library.detectCapitalUse("gooGle");
        boolean expected4 = false;
        if (result4 == expected4) score += 10;

        // Testing Library.makeFancyString
        String result5 = Library.makeFancyString("gooogggleee");
        String expected5 = "googglee";
        if (result5.equals(expected5)) score += 10;

        // Testing Library.capitalizeTitle
        String result6 = Library.capitalizeTitle("FirSt leTTeR of EACH Word");
        String expected6 = "First Letter Of Each Word";
        if (result6.equals(expected6)) score += 15;

        // Testing MyScanner
        String testing = "   John   Doe 123\t  \t  TrUe  \n   453.5     Rest of the line  \n 654";
        Scanner scanner = new Scanner(testing);
        MyScanner myScanner = new MyScanner(testing);
    
        if (scanner.next().equals(myScanner.next())) score += 5;
        if (scanner.next().equals(myScanner.next())) score += 5;
        if (scanner.nextInt() == myScanner.nextInt()) score += 5;
        if (scanner.nextBoolean() == myScanner.nextBoolean()) score += 5;
        if ((scanner.nextDouble()-myScanner.nextDouble()) <= 0.001) score += 5;
        if (scanner.nextLine().equals(myScanner.nextLine())) score += 5;
        if (scanner.nextInt() == myScanner.nextInt()) score += 5;

        scanner.close();
        System.out.printf("Your Lab score is %d\n", score);
    }
} //end-Test