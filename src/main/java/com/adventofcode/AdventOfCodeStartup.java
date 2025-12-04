package com.adventofcode;

import com.adventofcode.model.AbstractAdventOfCodeStartup;
import com.adventofcode.year2021.AdventOfCode2021Startup;
import com.adventofcode.year2022.AdventOfCode2022Startup;
import com.adventofcode.year2023.AdventOfCode2023Startup;
import com.adventofcode.year2025.AdventOfCode2025Startup;

import java.util.List;

public class AdventOfCodeStartup {

    private static final List<AbstractAdventOfCodeStartup> allYearlyStartupClasses = List.of(
            new AdventOfCode2021Startup(),
            new AdventOfCode2022Startup(),
            new AdventOfCode2023Startup(),
            new AdventOfCode2025Startup()
    );

    public static void main(String[] args) throws Exception {

        for (AbstractAdventOfCodeStartup yearStartupClass : allYearlyStartupClasses) {
            yearStartupClass.main();
        }
    }
}
