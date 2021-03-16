package hu.nive.ujratervezes.zarovizsga;
/*
A DigitsCounter osztálynak legyen egy int getCountOfDigits(String s) metódusa,
mely megszámolja, hogy hány különböző számjegy van a bemeneti Stringben.
 */

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        Set<Character> countOfNumbers = new HashSet<>();

        if (s == null || s.equals("")) {
            return 0;
        }

        else {
            int stringLenght = s.length();
            StringBuilder onlyNumbers = new StringBuilder();

            for (int i = 0; i < stringLenght; i++) {
                if (((Character.getNumericValue(s.charAt(i))) < 10)) {
                    onlyNumbers.append(s.charAt(i));
                }
            }

            for (int i = 0; i < onlyNumbers.length(); i++) {
                if (onlyNumbers.charAt(i) >= '0' && onlyNumbers.charAt(i) <= '9') {
                    countOfNumbers.add(onlyNumbers.charAt(i));
                }
            }
        }
        return countOfNumbers.size();
    }
}
