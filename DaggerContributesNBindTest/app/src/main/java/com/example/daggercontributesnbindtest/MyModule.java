package com.example.daggercontributesnbindtest;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MyModule {
    @Binds
    abstract BB bindBB(BBImpl bb);
}
