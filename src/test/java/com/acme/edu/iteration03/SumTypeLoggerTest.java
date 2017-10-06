package com.acme.edu.iteration03;

import com.acme.edu.SumTypeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SumTypeLoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogIntegersArray() throws IOException {
        try{
            SumTypeLogger.log((int[])null);
        }catch (IllegalArgumentException e){}
        //region when
        SumTypeLogger.log(new int[] {-1, 0, 1});
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}" + LINE_SEPARATOR
        );
        //endregion
    }

    /*
    TODO: implement SumTypeLogger solution to match specification as tests

    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        SumTypeLogger.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {\r\n" +
                "{-1, 0, 1}\r\n" +
                "{1, 2, 3}\r\n" +
                "{-1, -2, -3}\r\n" +
            "}\r\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        SumTypeLogger.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {\r\n" +
                "{\r\n" + "{\r\n" + "{\r\n" +
                    "0\r\n" +
                "}\r\n" + "}\r\n" + "}\r\n" +
            "}\r\n"
        );
        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        SumTypeLogger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1\r\nstring 2\r\nstr 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        SumTypeLogger.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        SumTypeLogger.log(1);
        SumTypeLogger.log("str");
        SumTypeLogger.log(Integer.MAX_VALUE - 10);
        SumTypeLogger.log(11);
        //endregion

        //region then
        assertSysoutContains(1);
        assertSysoutContains("str");
        assertSysoutContains(Integer.MAX_VALUE - 10);
        assertSysoutContains(11);
        //endregion
    }

    */
}