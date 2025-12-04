package com.adventofcode.utils;

import com.adventofcode.model.AbstractDay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCodeUtils {

    public static Scanner getScanner(String filePath) {
        try {
            File f = new File(filePath);

            InputStream inputStream = new FileInputStream(f);

            return new Scanner(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<? extends AbstractDay> getAllDayClasses(String packageName) throws Exception {
        List<Class<?>> classes = getClasses(packageName);

        return classes.stream()
                .filter(cls -> AbstractDay.class.isAssignableFrom(cls) && cls != AbstractDay.class)
                .map(cls -> {
                    try {
                        return (AbstractDay) cls.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
    }

    public static List<Class<?>> getClasses(String packageName) throws Exception {
        String path = packageName.replace('.', '/');
        URL root = Thread.currentThread().getContextClassLoader().getResource(path);

        if (root == null) {
            throw new IllegalArgumentException("Package introuvable : " + packageName);
        }

        File folder = new File(root.toURI());
        File[] files = folder.listFiles();
        List<Class<?>> classes = new ArrayList<>();

        if (files == null) return classes;

        for (File file : files) {
            if (!file.getName().endsWith(".class")) continue;

            String className = file.getName().replace(".class", "");
            String fqcn = packageName + "." + className;

            classes.add(Class.forName(fqcn));
        }

        return classes;
    }
}
