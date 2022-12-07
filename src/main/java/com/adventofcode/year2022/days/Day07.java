package com.adventofcode.year2022.days;

import com.adventofcode.utils.AdventOfCodeUtils;

import java.lang.invoke.MethodHandles;
import java.util.*;

public class Day07 {

    private static final String FILE_PATH = "src/main/resources/year2022/input-" + MethodHandles.lookup().lookupClass().getSimpleName().toLowerCase();

    public static Integer answer1() {

        Directory currentDirectory = getRootDirectory(AdventOfCodeUtils.getScanner(FILE_PATH));

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

    public static Integer answer2() {

        Directory rootDirectory = getRootDirectory(AdventOfCodeUtils.getScanner(FILE_PATH));

        int spaceLeft = 70000000 - rootDirectory.getSize();

        Set<Integer> dirSizes = new HashSet<>();

        fillDirSize(dirSizes, rootDirectory);

        return dirSizes.stream()
                .filter(e -> e >= (30000000 - spaceLeft))
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("Smelly smelly"));
    }

    private static String getPath(Directory dir) {
        String out = "";
        if (dir.parent != null) {
            out += getPath(dir.parent) + "/";
        }
        return out + dir.name;
    }

    private static Directory getRootDirectory(Scanner sc) {
        Directory currentDirectory = new Directory();
        currentDirectory.parent = null;
        currentDirectory.name = "";

        sc.nextLine(); // cd /

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            final String[] s = line.split(" ");

            if (line.startsWith("$ ")) { // Command
                switch (s[1]) {
                    case "cd" -> {
                        if ("..".equals(s[2])) {
                            currentDirectory = currentDirectory.parent;
                        } else {
                            currentDirectory = currentDirectory.goToDir(s[2]);
                        }
                    }
                    case "ls" -> {}
                    default -> new RuntimeException("Command not handled");
                }
            } else { // Response
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
                    if (!currentDirectory.hasSubFilz(fileName)) {
                        Filz newFilz = new Filz();
                        newFilz.name = fileName;
                        newFilz.size = fileSize;
                        currentDirectory.filz.add(newFilz);
                    }
                }
            }
        }

        // cd /
        while (currentDirectory.parent != null) {
            currentDirectory = currentDirectory.parent;
        }

        return currentDirectory;
    }

    static void fillDirSize(Set<Integer> dirSize, Directory directory) {
        dirSize.add(directory.getSize());
        directory.subDirectories.forEach(d -> fillDirSize(dirSize, d));
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


