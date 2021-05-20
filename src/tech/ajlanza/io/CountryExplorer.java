package tech.ajlanza.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CountryExplorer {
    public List<Country> readFile(String path) {
        List<Country> countries = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                if(line.trim().length() > 0) {
                    String[] tokens = line.split("\\s");
                    String name = tokens[0];
                    double pop = Double.parseDouble(tokens[1]);
                    countries.add(new Country(name, pop));
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
        return countries;
    }

    public Country findHighest(List<Country> countries) {
        Country highest = new Country();
        for(Country c: countries) {
            if(c.getPopulation() > highest.getPopulation()) {
                highest = c;
            }
        }
        return highest;
    }

    public Country findLowest(List<Country> countries) {
        Country lowest = new Country("", Double.POSITIVE_INFINITY);
        for(Country c: countries) {
            if(c.getPopulation() < lowest.getPopulation()) {
                lowest = c;
            }
        }
        return lowest;
    }

    public double findAverage(List<Country> countries) {
        double sum = 0;
        for(Country c: countries) {
            sum = sum + c.getPopulation();
        }
        return sum / countries.size();
    }

    public void writeFile(List<Country> countries) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            Country highest = findHighest(countries);
            Country lowest = findLowest(countries);
            double average = findAverage(countries);

            out.printf("The country with the largest population is: %s\n", highest);
            out.printf("The country with the lowest population is : %s\n", lowest);
            out.printf("The average population of all %d countries is %.2f millions\n", countries.size(), average);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }
}
