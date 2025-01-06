package com.example.daggercontributesnbindtest;

import javax.inject.Inject;

public class BBImpl implements BB{
    CC cc;

    @Inject
    public BBImpl(CC cc) {
        this.cc = cc;
    }

    @Override
    public String getString() {
        String tmp = cc.getString();
        return "this is BB. " + tmp;
    }

}
