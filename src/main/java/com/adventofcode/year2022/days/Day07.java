package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day07 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        Directory currentDirectory = new Directory();
        currentDirectory.parent = null;
        currentDirectory.name = "";

        sc.nextLine(); // cd /

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.startsWith("$ ")) {
                // Command
                final String[] s = line.split(" ");

                switch (s[1]) {
                    case "cd" -> {
                        if ("..".equals(s[2])) {
                            currentDirectory = currentDirectory.parent;
                        } else {
                            currentDirectory = currentDirectory.goToDir(s[2]);
                        }
                    }
                    case "ls" -> {

                    }
                    default -> new RuntimeException("Command not handled");
                }

            } else {
                // Response

                final String[] s = line.split(" ");

                if ("dir".equals(s[0])) {
                    final String subDir = s[1];
                    if (!currentDirectory.hasSubDirectory(subDir)) {
                        Directory newDir = new Directory();
                        newDir.parent = currentDirectory;
                        newDir.name = subDir;
                        currentDirectory.subDirectories.add(newDir);
                    }
                } else {
                    final int fileSize = Integer.parseInt(s[0]);
                    final String fileName = s[1];
                    if(!currentDirectory.hasSubFilz(fileName)) {
                        Filz newFilz = new Filz();
                        newFilz.name = fileName;
                        newFilz.size = fileSize;
                        currentDirectory.filz.add(newFilz);
                    }
                }
            }
        }

        while (currentDirectory.parent != null) {
            currentDirectory = currentDirectory.parent;
        }

        return sumDirLte100000(currentDirectory);
    }

    static int sumDirLte100000(Directory currentDirectory) {
        int sum = 0;

        final int size = currentDirectory.getSize();
        if (size <= 100000) {
            sum += size;
        }

        for (Directory subDirectory : currentDirectory.subDirectories) {
            sum += sumDirLte100000(subDirectory);
        }

        return sum;
    }

    private static String getPath(Directory dir) {
        String out = "";
        if (dir.parent != null) {
            out += getPath(dir.parent) + "/";
        }
        return out + dir.name;
    }

    public static Integer answer2() {

        Scanner sc = AdventOfCodeUtils.getScanner(FILE_PATH);

        return 0;
    }

    static class Directory {

        Directory parent;

        String name;
        List<Directory> subDirectories = new ArrayList<>();
        List<Filz> filz = new ArrayList<>();

        public Directory() {
        }

        boolean hasSubDirectory(String name) {
            return subDirectories.stream().anyMatch(s -> name.equals(s.name));
        }

        boolean hasSubFilz(String name) {
            return filz.stream().anyMatch(s -> name.equals(s.name));
        }

        Directory goToDir(String dirName) {
            return subDirectories.stream().filter(s -> dirName.equals(s.name)).findFirst().orElseThrow(() -> new RuntimeException("No dir"));
        }

        void print(int p) {
            final String tabs = new String(new char[p]).replace("\0", "\t");
            System.out.println(tabs + " d " +  name);
            for (Directory subDirectory : subDirectories) {
                subDirectory.print(p+1);
            }
            for (Filz file : filz) {
                System.out.println(tabs + " f " + file.name + " " + file.size);
            }
        }

        int getSize() {
            int sum = 0;

            for (Directory subDirectory : subDirectories) {
                sum += subDirectory.getSize();
            }

            for (Filz file : filz) {
                sum += file.size;
            }

            return sum;
        }
    }

    static class Filz {
        String name;
        int size;

        public Filz() {
        }
    }
}


