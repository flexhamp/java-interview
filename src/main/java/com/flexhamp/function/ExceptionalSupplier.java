package com.flexhamp.function;

import java.util.function.Supplier;

@FunctionalInterface
public interface ExceptionalSupplier<T> {
    T get() throws Exception;
}
