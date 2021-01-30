package tech.ajlanza.io;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CountryExplorer {
    public List<Double> readFile(String path) {
        List<Double> population = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if(line.trim().length() > 0) {
                    String[] tokens = line.split("\\s");
                    double pop = Double.parseDouble(tokens[1]);
                    population.add(pop);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
             }
        }
        return population;
    }
}
