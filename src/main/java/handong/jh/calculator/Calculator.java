package handong.jh.calculator;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    static String answer;
    static boolean minus = false;

    static ArrayList<String> birthArr = new ArrayList<>();

    public static String Calculation(String str)
    {
        if(!(str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/")))
        {
            if(birthArr.contains(str))
            {
                MainRunner.opFlag = true;
                MainRunner.label.setHorizontalAlignment(SwingConstants.CENTER);
                return "🥳HBD!!🎉";
            }
        }
        if(str.equals("21900616"))
        {
            MainRunner.opFlag = true;
            return "제작자 임주환";
        }
        if(str.equals("20220221"))
        {
            MainRunner.opFlag = true;
            return "💜애기새내기들💜";
        }
        if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '*' || str.charAt(str.length() - 1) == '/')
        {
            MainRunner.opFlag = true;
            return "불완전한 식";
        }
        if(str.charAt(0) == '-')
        {
            minus = true;
            str = str.replaceFirst("-", "");
        }
        String[] numStr = str.split("\\+|-|\\*|/");
        String opString = str.replaceAll("[a-f0-9]", "");
        opString = opString.replaceAll("\\.", "");
        String[] opStrArray = opString.split("");

        ArrayList<String> opStr = new ArrayList<>(opStrArray.length);

        for(int i = 0 ; i < opStrArray.length ; i++)
            opStr.add(opStrArray[i]);

        ArrayList<Double> strDouble;
        strDouble = strToDouble(numStr);

        if(minus)
            strDouble.set(0, strDouble.get(0) * (-1));

        // 우선순위(*, /) 먼저 처리
        for(int i = 0 ; i < opStr.size() ; i++)
        {
            // 곱하기(*) 처리
            if(opStr.get(i).equals("*"))
            {
                strDouble.set(i, strDouble.get(i) * strDouble.get(i + 1));
                strDouble.remove(i + 1);
                opStr.remove(i);
                i--;
            }
            // 나누기(/) 처리
            else if(opStr.get(i).equals("/"))
            {

                if(strDouble.get(i + 1) == 0)
                {
                    MainRunner.opFlag = true;
                    return "ERROR!!!!";
                }
                strDouble.set(i, strDouble.get(i) / strDouble.get(i + 1));
                strDouble.remove(i + 1);
                opStr.remove(i);
                i--;
            }
        }

        // 나중순위(+, -) 처리
        for(int i = 0 ; i < opStr.size() ; i++)
        {
            if(opStr.get(i).equals("+"))
            {
                strDouble.set(i, strDouble.get(i) + strDouble.get(i + 1));
                strDouble.remove(i + 1);
                opStr.remove(i);
                i--;
            }
            else if(opStr.get(i).equals("-"))
            {
                strDouble.set(i, strDouble.get(i) - strDouble.get(i + 1));
                strDouble.remove(i + 1);
                opStr.remove(i);
                i--;
            }
        }

        answer = strDouble.get(0).toString();
        double tmpStr;
        tmpStr = (double)Math.round(strDouble.get(0) * 1000000);
        tmpStr = tmpStr / 1000000.0;
        answer = Double.toString(tmpStr);
        if(isInteger(strDouble.get(0)))
        {
            double d = strDouble.get(0);
            int x = (int)d;
            answer = Integer.toString(x);
        }
        return answer;
    }

    public static String cosCalc(String str)
    {
        String ready = Calculation(str);
        double answer = Math.cos(Math.toRadians(Double.parseDouble(ready)));

        double tmpStr;
        tmpStr = (double)Math.round(answer * 1000000) / 1000000;

        return String.valueOf(tmpStr);
    }

    public static String sinCalc(String str)
    {
        String ready = Calculation(str);
        double answer = Math.sin(Math.toRadians(Double.parseDouble(ready)));

        double tmpStr;
        tmpStr = (double)Math.round(answer * 1000000) / 1000000;

        return String.valueOf(tmpStr);
    }

    public static String tanCalc(String str)
    {
        String ready = Calculation(str);

        if(Double.parseDouble(str) % 90 == 0 && !(Double.parseDouble(str) == 0) && !(Double.parseDouble(str) % 180 == 0))
        {
            MainRunner.opFlag = true;
            return "ERROR!!";
        }
        double answer = Math.tan(Math.toRadians(Double.parseDouble(ready)));
        System.out.println(answer);

        double tmpStr;
        tmpStr = (double)Math.round(answer * 1000000) / 1000000;

        return String.valueOf(tmpStr);
    }

    private static ArrayList<Double> strToDouble(String[] str)
    {
        ArrayList<Double> strDouble = new ArrayList<Double>(str.length);
        for(int i = 0 ; i < str.length ; i++)
            strDouble.add(Double.parseDouble(str[i]));

        return strDouble;
    }

    public static boolean isInteger(double number)
    {
        return Math.ceil(number) == Math.floor(number);
    }

    public static String birth(String str)
    {
        MainRunner.opFlag = true;

        if(str.contains("+") || str.contains("-") || str.contains("*") || str.contains("/"))
            return "ERROR!";
        else if(!birthArr.contains(str))
        {
            birthArr.add(str);
            return "SAVE!";
        }
        else
        {
            birthArr.remove(str);
            return "DELETE!";
        }
    }
}
