package com.example.daggerbasictest;

import javax.inject.Inject;

public class CC {
    @Inject
    protected BB bb;

    public String getString() {
        return bb.getString();
    }
}
