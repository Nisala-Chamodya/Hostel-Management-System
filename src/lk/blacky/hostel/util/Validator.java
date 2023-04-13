package lk.blacky.hostel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)");
    private static final Pattern numberPattern = Pattern.compile("[0-9]{10}+");
    private static final Pattern stringPattern = Pattern.compile("[a-z A-Z_]+");
    private static final Pattern studentIdPattern=Pattern.compile("S-\\d{3,4}");
    private static final Pattern custNicPattern=Pattern.compile("^([0-9]{9}[x|X|v|V]|[0-9]{12})$");
    private static final Pattern productPricePattern=Pattern.compile("[0-9]+.[0-9]{2}");
    private static final Pattern genderpattern=Pattern.compile("^Male|Female");
    private static final Pattern birthdaypattern=Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
    private static final Pattern availabilitypattern=Pattern.compile("[0-9]+");
    private static final Pattern passwordPattern=Pattern.compile("[a-z A-Z_0-9]{10}");

    public static boolean isEmailMatch(String text){
        Matcher emailMatcher = emailPattern.matcher(text);
        return emailMatcher.matches();
    }



    public static boolean isNameMatch(String text){
        Matcher nameMatcher = stringPattern.matcher(text);
        return nameMatcher.matches();
    }

    public static boolean isAgeMatch(String text){
        Matcher ageMatcher = numberPattern.matcher(text);
        return ageMatcher.matches();
    }
    public static boolean isStudentIdMatcher(String text){
        Matcher idMatcher=studentIdPattern.matcher(text);
        return  idMatcher.matches();
    }
    public static boolean isNicMatcher(String text){
        Matcher isNicMatcher=custNicPattern.matcher(text);
        return  isNicMatcher.matches();
    }

    public static boolean isPriceMatcher(String text){
        Matcher isPriceMatcher=productPricePattern.matcher(text);
        return  isPriceMatcher.matches();
    }
    public static boolean isGenderMatcher(String text){
        Matcher isGenderMatcher=genderpattern.matcher(text);
        return  isGenderMatcher.matches();
    }


    public static boolean isBirthdayMatcher(String text){
        Matcher isBirthdayMatcher=birthdaypattern.matcher(text);
        return  isBirthdayMatcher.matches();
    }

    public static boolean isAvailabilityMatcher(String text){
        Matcher isAvailabilityMatcher=availabilitypattern.matcher(text);
        return  isAvailabilityMatcher.matches();
    }





    public static boolean isPasswordMatcher(String text){
        Matcher isPasswordMatcher=passwordPattern.matcher(text);
        return  isPasswordMatcher.matches();
    }

    public static boolean isContactNoMatcher(String text){
        Matcher isContactNoMatcher=numberPattern.matcher(text);
        return  isContactNoMatcher.matches();
    }
}
