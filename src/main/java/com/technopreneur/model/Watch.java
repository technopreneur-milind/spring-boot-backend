package com.technopreneur.model;

public enum Watch {
    SEARCH_REPO("search_repo");
    private final String name;

    Watch(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
