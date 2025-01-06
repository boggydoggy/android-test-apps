package com.example.daggercontributesnbindtest;

import javax.inject.Inject;

public class AA {
    BB bb;

    @Inject
    public AA(BB bb) {
        this.bb = bb;
    }

    public String getString() {
        String tmp = bb.getString();
        return "This is AA. " + tmp;
    }
}
