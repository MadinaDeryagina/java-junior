package com.acme.edu.iteration01;

import com.acme.edu.SumTypeLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void shouldLogInteger() throws IOException {
        //region when
        SumTypeLogger.log(1);
        SumTypeLogger.log(0);
        SumTypeLogger.log(-1);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 0" + LINE_SEPARATOR);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        SumTypeLogger.log((byte)1);
        SumTypeLogger.log((byte)0);
        SumTypeLogger.log((byte)-1);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        //assertSysoutContains("1");
        assertSysoutContains("0");
        //assertSysoutContains("-1");
        //endregion
    }


    //TODO: implement SumTypeLogger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        SumTypeLogger.log('a');
        SumTypeLogger.log('b');
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        SumTypeLogger.log("test string 1");
        SumTypeLogger.log("other str");
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        SumTypeLogger.log(true);
        SumTypeLogger.log(false);
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }
    @Test
    public void shouldLogReference() throws IOException {
        //region when
        SumTypeLogger.log(new Object());
        SumTypeLogger.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


}