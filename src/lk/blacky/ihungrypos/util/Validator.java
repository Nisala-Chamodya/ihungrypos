package lk.blacky.ihungrypos.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern numberPattern = Pattern.compile("[0-9]{10}+");
    public static boolean isCustomerTelephoneNoMatcher(String text){
        Matcher telephoneNoMatcher = numberPattern.matcher(text);
        return telephoneNoMatcher.matches();
    }
}
