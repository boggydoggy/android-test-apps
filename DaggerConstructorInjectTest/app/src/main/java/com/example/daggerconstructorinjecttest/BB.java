package com.example.daggerconstructorinjecttest;

public class BB {
    AA aa;

    public BB(AA aa) {
        this.aa = aa;
    }
    public String getString() {
        return aa.getString();
    }
}
