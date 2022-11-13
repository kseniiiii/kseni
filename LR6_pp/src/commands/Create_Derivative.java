package commands;

import insurances.CarInsurance;
import insurances.HouseInsurance;
import insurances.Insurance;
import insurances.PersonInsurance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Create_Derivative implements Command{

    Scanner scan = new Scanner(System.in);
    @Override
    public void do_command(ArrayList<Insurance> ins) {
        System.out.println("Derivative is created");
        Der_menu();
        String command;
        while (true){
            command = scan.next();
            switch (command){
                case "price":
                    Calc_total_pr(ins);
                    break;
                case "sort":
                    Sort(ins);
                    break;
                case "find":
                    Find(ins);
                    break;
                case "return":
                    return;
                default:
                    System.out.println("Wrong command. Try again");
            }
        }
    }

    private void Der_menu(){
        System.out.println("price - to calculate total price");
        System.out.println("sort - to sort by risk");
        System.out.println("find - to find insurances by parameters");
        System.out.println("return - to return to the main menu");
    }

    private void Calc_total_pr(ArrayList<Insurance> ins){
        int total_price = 0;
        for (Insurance insurance : ins) {
            total_price += insurance.GetPrice();
        }
        System.out.println("Total price is " + total_price);
    }

    private void Sort(ArrayList<Insurance> ins){
        for (int i = 0; i < ins.size()-1; i++)
            for (int j = 0; j < ins.size()-i-1; j++) {
                if (ins.get(j).GetRisk() < ins.get(j + 1).GetRisk()) {
                    ins.add(j, ins.get(j+1));
                    ins.remove(j+2);
                }
            }
    }
    private void Find(ArrayList<Insurance> ins){
        System.out.println("Choose a type of insurance you want to find");
        String str = scan.next();
        switch (str){
            case "person":
                System.out.println("Enter the age interval");
                int min, max;
                min = scan.nextInt();
                max = scan.nextInt();
                for (Insurance insurance : ins)
                    if(insurance instanceof PersonInsurance &&
                            ((PersonInsurance) insurance).GetAge() > min &&
                            ((PersonInsurance) insurance).GetAge() < max)
                        System.out.println(insurance);
                break;
            case "car":
                int min_vol, max_vol, min_pr, max_pr;
                System.out.println("Enter the motor volume interval");
                min_vol = scan.nextInt();
                max_vol = scan.nextInt();
                System.out.println("Enter the price interval");
                min_pr = scan.nextInt();
                max_pr = scan.nextInt();
                for (Insurance insurance : ins)
                    if(insurance instanceof CarInsurance &&
                            ((CarInsurance) insurance).getMotor_volume() > min_vol &&
                            ((CarInsurance) insurance).getMotor_volume() < max_vol &&
                            insurance.GetPrice() > min_pr && insurance.GetPrice() < max_pr)
                        System.out.println(insurance);
                break;
            case "house":
                int min_area, max_area, min_h_pr, max_h_pr;
                System.out.println("Enter the area interval");
                min_area = scan.nextInt();
                max_area = scan.nextInt();
                System.out.println("Enter the price interval");
                min_pr = scan.nextInt();
                max_pr = scan.nextInt();
                for (Insurance insurance : ins)
                    if(insurance instanceof HouseInsurance &&
                            ((HouseInsurance) insurance).getArea() > min_area &&
                            ((HouseInsurance) insurance).getArea() < max_area &&
                            ((HouseInsurance) insurance).getHouse_price() > min_pr &&
                            ((HouseInsurance) insurance).getHouse_price() < max_pr)
                        System.out.println(insurance);
                break;
            default:
                System.out.println("There is no such insurance");
        }
    }
}

