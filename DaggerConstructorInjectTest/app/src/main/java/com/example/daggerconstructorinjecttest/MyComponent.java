package com.example.daggerconstructorinjecttest;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    CC getCC();
}
