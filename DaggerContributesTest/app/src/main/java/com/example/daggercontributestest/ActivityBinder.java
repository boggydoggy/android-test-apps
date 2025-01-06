package com.example.daggercontributestest;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract public class ActivityBinder {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
