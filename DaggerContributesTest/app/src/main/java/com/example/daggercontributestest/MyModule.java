package com.example.daggercontributestest;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {
    @Provides
    public AA provideAA() {
        return new AA();
    }
    @Provides
    public BB provideBB(AA aa) {
        return new BB(aa);
    }
    @Provides
    public CC provideCC(BB bb) {
        return new CC(bb);
    }
}
