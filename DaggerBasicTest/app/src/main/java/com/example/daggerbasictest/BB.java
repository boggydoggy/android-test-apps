package com.example.daggerbasictest;

import javax.inject.Inject;

public class BB {
    AA aa;

    public BB(AA aa) {
        this.aa = aa;
    }

    public String getString() {
        return aa.getString();
    }
}
