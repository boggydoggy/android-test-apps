package com.example.daggerbindtest;

import javax.inject.Inject;

public class Temp {
    @Inject
    public Temp() {}

    public String getString() {
        return "Temp String";
    }
}
