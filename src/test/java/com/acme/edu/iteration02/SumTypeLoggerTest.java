package com.acme.edu.iteration02;

import com.acme.edu.SumTypeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SumTypeLoggerTest implements SysoutCaptureAndAssertionAbility {
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
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log(1);
        SumTypeLogger.log(2);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("str 1\r\n");
        assertSysoutContains("3\r\n");
        assertSysoutContains( "str 2\r\n");
        assertSysoutContains("0\r\n");

        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log((int)10);
        SumTypeLogger.log((int)Integer.MAX_VALUE);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "str 1\r\n" +
            "10\r\n" +
            Integer.MAX_VALUE + "\r\n" +
            "str 2\r\n" +
            "0\r\n"
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log((byte)10);
        SumTypeLogger.log((byte)Byte.MAX_VALUE);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("str 1\r\n");
        assertSysoutContains("10\r\n" );
        assertSysoutContains(Byte.MAX_VALUE + "\r\n");
        assertSysoutContains("str 2\r\n");
        assertSysoutContains("0\r\n");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log("str 2");
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log("str 3");
        SumTypeLogger.log("str 3");
        SumTypeLogger.log("str 3");
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("str 1\r\n");
        assertSysoutContains("str 2 (x2)\r\n");
        assertSysoutContains("0\r\n");
         assertSysoutContains( "str 2\r\n");
         assertSysoutContains( "str 3 (x3)\r\n");
        //endregion
    }
}