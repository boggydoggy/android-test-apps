package com.example.daggercontributestest;

public class CC {
    BB bb;

    public CC(BB bb) {
        this.bb = bb;
    }
    public String getString() {
        return bb.getString();
    }
    public String getTest() {
        return "test";
    }
}
