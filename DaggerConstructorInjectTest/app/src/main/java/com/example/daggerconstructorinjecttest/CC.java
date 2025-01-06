package com.example.daggerconstructorinjecttest;

import javax.inject.Inject;

public class CC {
    BB bb;

    @Inject
    public CC(BB bb) {
        this.bb = bb;
    }
    public String getString() {
        return bb.getString();
    }
}
