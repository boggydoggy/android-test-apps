package com.example.daggerbasictest;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(CC cc);
}
