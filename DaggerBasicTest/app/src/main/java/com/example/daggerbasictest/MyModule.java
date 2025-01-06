package com.example.daggerbasictest;

import dagger.Module;
import dagger.Provides;


@Module
public class MyModule {
    @Provides
    AA provideAA() {
        return new AA();
    }
    @Provides
    BB provideBB(AA aa) {
        return new BB(aa);
    }
}
