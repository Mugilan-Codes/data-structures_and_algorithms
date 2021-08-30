package questions.codesignal.centuryfromyear;

public class CenturyFromYear {

    public static int centuryFromYear(int year) {
        // 1 to 100 years

        if (year < 1) {
            return -1;
        }

        // return 1st century
        if (year <= 100) {
            return 1;
        }

        // if the year is in multiples of 100
        if (year % 100 == 0) {
            return year / 100;
        }

        return (year / 100) + 1;

    }

    public static void main(String[] args) {

        int year1 = 1905;
        int century1 = centuryFromYear(year1);
        System.out.println("Year " + year1 + " is in Century " + century1);

        int year2 = 1700;
        int century2 = centuryFromYear(year2);
        System.out.println("Year " + year2 + " is in Century " + century2);

    }

}
