package com.example.daggercontributesnbindtest;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MyBinder {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
