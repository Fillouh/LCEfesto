package com.lcefesto.utility;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OpsPackage {

    public static Set<Class<?>> findAllClassesUsingGoogleGuice(String packageName) throws IOException {
        Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        reflections.getSubTypesOf(Object.class).forEach(s -> System.out.println(s.getName()));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }
}
