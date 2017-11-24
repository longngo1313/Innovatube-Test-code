package com.example.solution;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Admin on 11/24/2017.
 */

public class UnitTestSolution {

    @Test
    public void wrongCase()
    {
        String data = "([{<)]}>";
        assertEquals(0, Solution.solution(data));
    }


    @Test
    public void rightCase()
    {
        String data = "(([]{})(())(<>))";
        assertEquals(1, Solution.solution(data));
    }


    @Test
    public void abnormalCase()
    {
        String data = "(([]{})(sdfdsf())(<>))";
        assertEquals(0, Solution.solution(data));
    }

    @Test
    public void minimumCase()
    {
        String data = "";
        assertEquals(1, Solution.solution(data));
    }


    @Test
    public void rightCase2()
    {
        String data = "(([]{})(())(<>))()()()()()()()()()()";
        assertEquals(1, Solution.solution(data));
    }

    @Test
    public void limitCase1()
    {
        String data = createMaxLimitString(true, 1000000);
        assertEquals(1, Solution.solution(data));
    }

    @Test
    public void limitCase2()
    {
        String data = createMaxLimitString(false, 1000000);
        assertEquals(0, Solution.solution(data));
    }

    public static String createMaxLimitString (boolean isNested, int limit){

        String string = "";

        String coupleChar = "";

        if (isNested){
            coupleChar = "()";
        }else {
            coupleChar = "(}";
        }

        for (int i = 0 ; i < limit; i = i +2){
            string = string + coupleChar;
        }

        return string;
    }

}
