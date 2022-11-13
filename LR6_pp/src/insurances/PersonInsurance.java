package insurances;

import java.util.Scanner;

public class PersonInsurance implements Insurance{

    Scanner scan = new Scanner(System.in);
    double risk;
    int price, payment;
    int age;
    double health_level;
    public PersonInsurance(int age, int health){
        this.age = age;
        health_level = calculate_hel_lev(health);
        calculate_risk();
        calculate_price();
        calculate_payment();
    }

    @Override
    public int GetPrice(){
        return price;
    }

    @Override
    public double GetRisk() {
        return risk;
    }
    public int GetAge(){
        return age;
    }

    @Override
    public void calculate_risk() {
        risk = age*health_level/200;
    }

    @Override
    public void calculate_price() {
        price = (int)(risk*1000);
    }

    @Override
    public void calculate_payment() {
        payment = price*100;
    }

    double calculate_hel_lev(int health){
        switch (health){
            case 1:
                return 1.8;
            case 2:
                return 1.6;
            case 3:
                return  1.4;
            case 4:
                return  1.2;
            default:
                return  1;
        }
    }

    @Override
    public String toString() {
        return "PersonInsurance{" +
                "risk=" + risk +
                ", price=" + price +
                ", payment=" + payment +
                ", age=" + age +
                ", helth_level=" + health_level +
                '}';
    }
}
