package handong.jh.calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    static String answer;
    static boolean minus = false;

    public static String Calculation(String str)
    {
        if(str.equals("21900616"))
        {
            MainRunner.opFlag = true;
            return "제작자 임주환";
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
        if(isInteger(strDouble.get(0)))
        {
            double d = strDouble.get(0);
            int x = (int)d;
            answer = Integer.toString(x);
        }


        // 에러 체크
        System.out.println(answer);
        if(strDouble.size() != 1)
        {
            System.out.println("ERROR in strDouble!");

            for(int i = 0 ; i < strDouble.size() ; i++)
                System.out.println(strDouble.get(i));
        }
        else if(!opStr.isEmpty())
        {
            System.out.println("ERROR in opStr!");

            for(int i = 0 ; i < opStr.size() ; i++)
                System.out.println(opStr.get(i));
        }
        return answer;
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
}
