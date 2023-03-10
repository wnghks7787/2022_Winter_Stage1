package handong.jh.calculator;

import javax.swing.*;
import java.util.ArrayList;

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
                return "ð¥³HBD!!ð";
            }
        }
        if(str.equals("21900616"))
        {
            MainRunner.opFlag = true;
            return "ì ìì ìì£¼í";
        }
        if(str.equals("20220221"))
        {
            MainRunner.opFlag = true;
            return "ðì ê¸°ìë´ê¸°ë¤ð";
        }
        if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-' || str.charAt(str.length() - 1) == '*' || str.charAt(str.length() - 1) == '/')
        {
            MainRunner.opFlag = true;
            return "ë¶ìì í ì";
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

        // ì°ì ìì(*, /) ë¨¼ì  ì²ë¦¬
        for(int i = 0 ; i < opStr.size() ; i++)
        {
            // ê³±íê¸°(*) ì²ë¦¬
            if(opStr.get(i).equals("*"))
            {
                strDouble.set(i, strDouble.get(i) * strDouble.get(i + 1));
                strDouble.remove(i + 1);
                opStr.remove(i);
                i--;
            }
            // ëëê¸°(/) ì²ë¦¬
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

        // ëì¤ìì(+, -) ì²ë¦¬
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
