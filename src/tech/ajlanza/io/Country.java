package tech.ajlanza.io;

public class Country {
    private String name;
    private double population;

    public Country() {
        this("", 0);
    }

    public Country(String name, double population) {
        this.setName(name);
        this.setPopulation(population);
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f)", getName(), getPopulation());
    }
}
