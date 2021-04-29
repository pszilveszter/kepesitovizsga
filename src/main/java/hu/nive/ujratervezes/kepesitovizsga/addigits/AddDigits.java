package hu.nive.ujratervezes.kepesitovizsga.addigits;


public class AddDigits {

    public int addDigits(String s) {
        if (isEmptyIn(s)) {
            return -1;
        }

        int sum = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Integer.parseInt(c.toString());
            }
        }
        return sum;
    }


    private boolean isEmptyIn(String s) {
        return s == null || s.isBlank();
    }

}
