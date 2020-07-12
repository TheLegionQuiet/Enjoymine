package ru.enjoymine.CivCraft.items;

public abstract class CustomItem {
    private final String name;

    public CustomItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    static {

    }
}
