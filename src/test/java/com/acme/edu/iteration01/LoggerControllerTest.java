package com.acme.edu.iteration01;

import com.acme.edu.LoggerController;
import com.acme.edu.LoggerControllerException;
import com.acme.edu.saver.Saver;
import com.acme.edu.saver.SaverException;
import org.junit.Test;


public class LoggerControllerTest {
    @Test(expected = NullPointerException.class)
    public void shouldGetExceptionWhenOperationaAndSavingEx() throws LoggerControllerException {
        LoggerController loggerToTest = new LoggerController(message -> {
            throw  new SaverException("test exception");
        });
        loggerToTest.close();
    }
}
