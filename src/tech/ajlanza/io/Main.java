package tech.ajlanza.io;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryExplorer ce = new CountryExplorer();
        List<Country> population = ce.readFile("data.txt");

        for(Country c: population) {
            System.out.println(c);
        }
    }
}
