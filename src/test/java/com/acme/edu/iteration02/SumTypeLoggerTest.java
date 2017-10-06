package com.acme.edu.iteration02;

import com.acme.edu.SumTypeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.sun.xml.internal.bind.v2.runtime.InlineBinaryTransducer;
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
        assertSysoutContains("str 1" + LINE_SEPARATOR);
        assertSysoutContains("3" + LINE_SEPARATOR);
        assertSysoutContains("str 2" + LINE_SEPARATOR);
        assertSysoutContains("0" + LINE_SEPARATOR);

        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException{
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log((int) 10);
        SumTypeLogger.log((int) Integer.MAX_VALUE);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.log((int) Integer.MIN_VALUE);
        SumTypeLogger.log((int)Integer.MIN_VALUE);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("str 1" + LINE_SEPARATOR );
        assertSysoutContains("10" + LINE_SEPARATOR );
        assertSysoutContains( Integer.MAX_VALUE + LINE_SEPARATOR );
        assertSysoutContains("str 2" + LINE_SEPARATOR );
        assertSysoutContains("0"+LINE_SEPARATOR);
        assertSysoutContains(Integer.MIN_VALUE + LINE_SEPARATOR);
        assertSysoutContains(Integer.MIN_VALUE+ LINE_SEPARATOR);

        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws  IOException{
        //region when
        SumTypeLogger.log("str 1");
        SumTypeLogger.log((byte) 10);
        SumTypeLogger.log((byte) Byte.MAX_VALUE);
        SumTypeLogger.log("str 2");
        SumTypeLogger.log(0);
        SumTypeLogger.log((byte)(-10));
        SumTypeLogger.log((byte) Byte.MIN_VALUE);
        SumTypeLogger.log("str 3");
        SumTypeLogger.log((byte) Byte.MIN_VALUE);
        SumTypeLogger.log((byte) Byte.MAX_VALUE);
        SumTypeLogger.log((byte) Byte.MAX_VALUE);

        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("str 1" + LINE_SEPARATOR);
        assertSysoutContains("10" + LINE_SEPARATOR);
        assertSysoutContains(Byte.MAX_VALUE + LINE_SEPARATOR);
        assertSysoutContains("str 2" + LINE_SEPARATOR);
        assertSysoutContains("-10" + LINE_SEPARATOR);
        assertSysoutContains(Byte.MIN_VALUE + LINE_SEPARATOR);
        assertSysoutContains("str 3"+LINE_SEPARATOR);
        assertSysoutContains("126"+LINE_SEPARATOR);
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
        assertSysoutContains("str 1" + LINE_SEPARATOR);
        assertSysoutContains("str 2 (x2)" + LINE_SEPARATOR);
        assertSysoutContains("0" + LINE_SEPARATOR);
        assertSysoutContains("str 2" + LINE_SEPARATOR);
        assertSysoutContains("str 3 (x3)" + LINE_SEPARATOR);
        //endregion
    }
}