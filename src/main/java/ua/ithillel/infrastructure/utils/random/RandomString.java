package ua.ithillel.infrastructure.utils.random;

import java.util.Random;

public class RandomString {

    public enum Mode {
        ALPHA,
        NUMERIC,
        ALPHANUMERIC
    }

    public static String randomString(Mode mode, int length){
        String alphabet;
        switch(mode){
            case ALPHA:
                alphabet = "abcdefghijklmnopqrstuvwxyz";
                break;
            case NUMERIC:
                alphabet = "0123456789";
                break;
            case ALPHANUMERIC:
                alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
                break;
            default:
                return "";
        }
        StringBuilder randomStr= new StringBuilder();
        for (int i = 0; i < length; i++) {
            randomStr.append(alphabet.charAt(new Random().nextInt(alphabet.length())));
        }
        return randomStr.toString();
    }
}
