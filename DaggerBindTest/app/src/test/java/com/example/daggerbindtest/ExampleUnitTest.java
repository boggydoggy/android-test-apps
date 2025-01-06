package com.example.daggerbindtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void myTest() {
        MyComponent component = DaggerMyComponent.create();
        BB bb = new BB();
        component.inject(bb);

        System.out.println(bb.getString());
        System.out.println(bb.getTempString());
    }
}