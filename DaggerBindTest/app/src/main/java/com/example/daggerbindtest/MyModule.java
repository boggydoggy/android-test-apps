package com.example.daggerbindtest;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class MyModule {
    @Binds
    abstract Alphabets bindBB(BB bb);
}
