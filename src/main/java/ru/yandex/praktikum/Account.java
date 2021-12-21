package ru.yandex.praktikum;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        int count = 0;
        for(int i = 0; i < name.length(); i++) {
            if(Character.isWhitespace(name.charAt(i))) count++;
        }
        return name.length() >= 3 & name.length() <= 19 & !name.startsWith(" ") & !name.endsWith(" ") & count == 1;
    }
}