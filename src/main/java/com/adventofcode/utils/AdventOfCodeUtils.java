package com.adventofcode.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

}
