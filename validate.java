package com.example.henri.pwsm;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validate implements validator {


    public int validate(String aux) {
        String pass;
        pass = aux;
        int score = 0;

        //kollar om lösenordet är minst 8 bokstäver långt.
        if (pass.length() >= 8) {
            score++;
        }
//om det skrivs in hej kommer hasLower bli true, men hasUpper == false, om HEJ skrivs kommer  hasUppercase bli ture, men hasLowercase bli false.
        boolean hasUppercase = !pass.equals(pass.toLowerCase());
        boolean hasLowercase = !pass.equals(pass.toUpperCase());


        if (hasLowercase && hasUppercase) {
            Log.e("MINTAGG", "HAR BÅDA");
            score++;
        }
        // här skapar vi ett RexEx pattern för siffrorna 0-9, därefter ser vi om vi får en matchning på vårat pass.
        Pattern p1 = Pattern.compile("[0-9]");
        Matcher m1 = p1.matcher(pass);

        if (m1.find()) {
            score++;
        }
        // kollar om det finns specialtecken
        Pattern p2 = Pattern.compile("[a-zA-Z0-9]*");
        Matcher m2 = p2.matcher(pass);


        //vad är skillnaden på find och matches? Jag förstår inte skillnaden.
        if (!m2.matches()) {
            score++;
        }

        if (pass.length() >= 12) {
            score++;
        }


        Log.e("MINTAGG", "SCORE" + score);


        return score;

    }


}




