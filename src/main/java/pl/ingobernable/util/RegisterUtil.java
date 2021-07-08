    package pl.ingobernable.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class RegisterUtil {
         public static boolean isPasswordValid(String password){

            Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*^#?&])[A-Za-z\\d@$!%^*#?&]{8,30}$");
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
        }

       public static boolean arePasswordsTheSame(String password, String passwordConfirm){
            return password.equals(passwordConfirm);
        }
    }
