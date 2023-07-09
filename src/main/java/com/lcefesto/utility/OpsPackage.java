package com.lcefesto.utility;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OpsPackage {
    /**
     * Static methods that scans the desired package for Java Classes, returning a Set of Generic Class objects.
     *
     * @param packageName String containing the pathname
     */
    public static Set<Class<?>> findPackageClasses(String packageName) throws IOException {
        Reflections reflections = new Reflections(packageName, Scanners.SubTypes.filterResultsBy(c -> true));
        reflections.getSubTypesOf(Object.class).forEach(s -> System.out.println(s.getName()));
        return new HashSet<>(reflections.getSubTypesOf(Object.class));
    }
}
