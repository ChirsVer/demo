package Helpers;


import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class LogSuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try (PrintStream out = new PrintStream(new FileOutputStream("/tmp/test-list.txt"))) {
            suite.getAllMethods().stream()
                    .map(m -> m.getTestClass().getName() + "." + m.getMethodName())
                    .forEach(out::println);
        } catch (IOException e) {
            System.err.println("FAILED TO WRITE TO FILE!");
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ISuite suite) {
    }
}

