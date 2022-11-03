package com.company;
import java.util.Scanner;

public class Obligation {
    private String obligate = null;
    private double price = 0.0;
    private double derivative = 0.0;
    private double range = 0.0;

    public Obligation() {}

    public Obligation(boolean bool) {
        if (bool) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter obligation:");
            this.obligate = scanner.nextLine();
            System.out.println("Enter price $:");
            this.price = scanner.nextDouble();
            System.out.println("Enter derivative $:");
            this.derivative = scanner.nextDouble();
            System.out.println("Enter range:");
            this.range = scanner.nextDouble();
            scanner.nextLine();
        }
    }

    public String getInsurance() {
        return obligate;
    }
    public double getPrice() {return price;}
    public double getObligate() {
        return derivative;
    }
    public double getMax() {
        return range;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                " Obligation= " + obligate +
                ", price= " + price + "$" +
                ", derivative= " + derivative + "$" +
                ", range= " + range +
                '}';
    }
}

