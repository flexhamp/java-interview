package com.flexhamp.function;

@FunctionalInterface
public interface ExceptionalSupplier<T> {
    T get() throws Exception;
}
