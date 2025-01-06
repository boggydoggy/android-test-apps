package com.example.daggercontributesnbindtest;

import javax.inject.Inject;

public class CC {
    @Inject
    public CC() {}

    public String getString() {
        return "This is CC.";
    }
}
