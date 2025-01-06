package com.example.daggerbindtest;

import javax.inject.Inject;

public class AA implements Alphabets{
    @Inject
    public AA() {}

    @Override
    public String getString() {
        return "Hello World! - A";
    }
}
