package commands;

import insurances.CarInsurance;
import insurances.HouseInsurance;
import insurances.Insurance;
import insurances.PersonInsurance;

import java.util.ArrayList;
import java.util.Scanner;

public class Add implements Command{

    Scanner scan = new Scanner(System.in);

    @Override
    public void do_command(ArrayList<Insurance> insurances){
        Insurance newIns;
        System.out.println("Choose type: person, house or car");
        while (true){
            String type = scan.next();
            switch (type){
                case "person":
                    int age, helth;
                    System.out.println("enter your age");
                    age = scan.nextInt();
                    System.out.println("estimate your helth level (from 1 to 5)");
                    helth = scan.nextInt();
                    newIns = new PersonInsurance(age, helth);
                    insurances.add(newIns);
                    return;
                case "house":
                    int area, price;
                    System.out.println("enter area");
                    area = scan.nextInt();
                    System.out.println("enter price");
                    price = scan.nextInt();
                    newIns = new HouseInsurance(area, price);
                    insurances.add(newIns);
                    return;
                case "car":
                    String type_of_car;
                    int motor_volume;
                    System.out.println("enter type (motorcycle, car, bus, truck)");
                    type_of_car = scan.next();
                    System.out.println("enter motor volume");
                    motor_volume = scan.nextInt();
                    System.out.println("enter price");
                    price = scan.nextInt();
                    newIns = new CarInsurance(type_of_car, motor_volume, price);
                    insurances.add(newIns);
                    return;
                default:
                    System.out.println("Wrong command. Try again");
            }
        }
    }

}

