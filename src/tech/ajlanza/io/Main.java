package tech.ajlanza.io;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryExplorer ce = new CountryExplorer();
        List<Double> population = ce.readFile("data.txt");

        for(Double d: population) {
            System.out.println(d);
        }
    }
}
