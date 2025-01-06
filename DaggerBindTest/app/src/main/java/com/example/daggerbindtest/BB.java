package com.example.daggerbindtest;

import javax.inject.Inject;

public class BB implements Alphabets{
    @Inject
    Temp tmp;

    public BB() {}

    @Override
    public String getString() {
        return "Hello World! - B";
    }

    public String getTempString() {
        return tmp.getString();
    }
}
