package com.company;

import java.util.List;

public class FilmsFactory implements GetSetFactory {
    @Override
    public GetSet createInstance() {
        return new Films();
    }

    @Override
    public GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) {

        return new Films(paragraphСount, name, intrParphCount, author);
    }
}