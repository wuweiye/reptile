package app;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * 快速建立main模板
 */

public class Test {

    public static void main(String[] args) {
        ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
        // cache stream
        PrintStream cacheStream = new PrintStream(baoStream);
        // old stream
        PrintStream oldStream = System.out;

        System.setOut(cacheStream);

        System.out.print("hello world!");

        String message = baoStream.toString();

        message = "<-- " + message + " -->";

        // Restore old stream
        System.setOut(oldStream);

        System.out.println(message);

    }
}
