package com.pierless.space;

import org.junit.Assert;
import org.junit.Test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by dschrimpsher on 7/27/15.
 */
public class TestJS {

    @Test
    public void testConversion() {
        double ra = 265.5;
        double dec = -28.0;
        double expectedLong = 0.3802;
        double expectedLat = 1.1682;
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
// read script file
            engine.eval(Files.newBufferedReader(Paths.get("./src/main/resources/convert.js"), StandardCharsets.UTF_8));

            Invocable inv = (Invocable) engine;
// call function from script file
            String temp = (String) inv.invokeFunction("CalcX", ra, dec);
            System.out.println(temp);

            int index = temp.indexOf(",");
            double actualLong = Double.parseDouble(temp.substring(0, index));
            double actualLat = Double.parseDouble(temp.substring(index+1));

            Assert.assertEquals(actualLong, expectedLong, 0.0001);
            Assert.assertEquals(actualLat, expectedLat, 0.0001);


            ra = 100.0;
            dec = 0.0;
            expectedLong = 211.6272;
            expectedLat = -2.5447;

             temp = (String) inv.invokeFunction("CalcX", ra, dec);

             index = temp.indexOf(",");
             actualLong = Double.parseDouble(temp.substring(0, index));
             actualLat = Double.parseDouble(temp.substring(index+1));

            Assert.assertEquals(actualLong, expectedLong, 0.0001);
            Assert.assertEquals(actualLat, expectedLat, 0.0001);


        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        catch (NoSuchMethodException e2) {
            System.err.println(e2.getMessage());
        }
        catch (ScriptException e2) {
            System.err.println(e2.getMessage());
        }

    }
}
