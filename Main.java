import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    public Polynomial polyOne;
//    public Polynomial polyTwo;

//    public Polynomial result;

    public Main() {
//        polyOne = new Polynomial();
//        polyTwo = new Polynomial();
//        result = new Polynomial();
    }
// 4x^2 + 3x + 6

    public boolean isSign(char c) {
        if ((c == '-') || (c == '+')) {
            return true;
        }
        return false;
    }

    public void parseChars(char[] chars, Polynomial polo) {
        boolean sign;
        if (chars[0] == '-') {
            sign = false;
        } else {
            sign = true;
        }
        int degree = 0;
        int coef = -999;
        Monomial mono;
        boolean coefDone = false;
        for (int i = 0; i < chars.length; i++) {
            if ((Character.isDigit(chars[i]) && (coef == -999))) {
                coef = Character.getNumericValue(chars[i]); //need to change this so it doesnt reset with the degree
                int j = i+1;
                while ((j < chars.length-1) && (Character.isDigit(chars[j])  )) {
                    String temp = String.valueOf(coef);
                    temp += chars[j];
                    coef = Integer.valueOf(temp);
                    j += 1;
                }
            }

            if (chars[i] == '^') {
                degree = Character.getNumericValue(chars[i + 1]);
                coefDone = true;


            }
            if (chars[i] == 'x') {
                degree = 1;

            }


            if (isSign(chars[i])) {
                if (coef != -999) {
                    if (sign) {
                        mono = new Monomial(degree, coef);//sign
                    }else{
                        mono = new Monomial(degree, -coef);//sign
                    }
                    polo.ins(mono);
                    coef = -999;
                    degree = 0;
                    sign = true;
                }
            }
            if (chars[i] == '-') {
                sign = false;
            }

        }
        if (sign) {
            mono = new Monomial(degree, coef);//sign
        }else {
            mono = new Monomial(degree, -coef);//sign
        }
        polo.ins(mono);
    }

    public char[] getInput() {
        String input = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println(e);
        }

        String output = input.replaceAll("\\s", "");

        char[] chars = output.toCharArray();
        return chars;


    }

}





//    public static void main(String[] args) {

//        Main mymain = new Main();
//
//        char[] chars = mymain.getInput();
//        mymain.parseChars(chars,mymain.polyOne);
//        chars = mymain.getInput();
//        mymain.parseChars(chars,mymain.polyTwo);
//        mymain.result = mymain.polyOne.div(mymain.polyTwo);
//        mymain.result.printarray();
//        mymain.result.printPoly();




//    }
