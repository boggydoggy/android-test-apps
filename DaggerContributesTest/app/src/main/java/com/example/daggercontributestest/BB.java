package com.example.daggercontributestest;

public class BB {
    AA aa;
    public BB(AA aa) {
        this.aa = aa;
    }
    public String getString() {
        return aa.getString();
    }
}
