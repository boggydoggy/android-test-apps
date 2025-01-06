package com.example.daggercontributestest;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                MyModule.class,
                ActivityBinder.class,
                AndroidSupportInjectionModule.class
        })
public interface MyComponent extends AndroidInjector<App> {
}
