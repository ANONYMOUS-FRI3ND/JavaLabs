package com.company;

import java.util.List;

public class GamesFactory implements GetSetFactory{
    @Override
    public GetSet createInstance() {
        return new Games();
    }

    @Override
    public GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) {

        return new Games(paragraphСount, name, intrParphCount, author);
    }
}