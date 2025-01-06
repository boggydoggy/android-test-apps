package com.example.daggerbindtest;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(BB bb);
}
