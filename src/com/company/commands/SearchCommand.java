package com.company.commands;
import com.company.Insurance;
import java.util.Scanner;

public class SearchCommand extends Command {
    @Override
    public void execute(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range");
        System.out.print("\nEnter x1: ");
        double range1 = sc.nextInt();
        System.out.print("Enter x2:");
        double range2 = sc.nextInt();
        sc.nextLine();

        System.out.println("\nSEARCH\n");
        for (int i=0; i<insurance.getList().size(); i++) {
            if(insurance.getList().get(i).getMax()>=range1
                    &&insurance.getList().get(i).getMax()<=range2) {
                System.out.println(insurance.getList().get(i));
            }
        }
    }

    public SearchCommand(Insurance insurance)
    {
        this.insurance = insurance;
    }
}
