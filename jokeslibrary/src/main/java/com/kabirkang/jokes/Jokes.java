package com.kabirkang.jokes;

import java.util.Random;

public class Jokes {
    private String[] jokes;
    private Random random;

    public Jokes() {
        jokes = new String[3];
        jokes[0] = "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"";
        jokes[1] = "Q: how many programmers does it take to change a light bulb? A: none, that's a hardware problem";
        jokes[2] = "When your hammer is C++, everything begins to look like a thumb.";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
