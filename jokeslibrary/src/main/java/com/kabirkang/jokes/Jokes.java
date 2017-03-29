package com.kabirkang.jokes;

import java.util.Random;

public class Jokes {
    final static String[] Jokes = new String[]{
        "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
        "Q: how many programmers does it take to change a light bulb? A: none, that's a hardware problem",
        "When your hammer is C++, everything begins to look like a thumb."
    };

    public static String[] getJokes() {
        return Jokes;
    }

    public static String getJoke() {
        Random random = new Random();
        return Jokes[random.nextInt(Jokes.length)];
    }
}
