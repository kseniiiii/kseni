package com.company.commands;
import com.company.Insurance;

public class AllPriceCommand extends Command {
    @Override
    public void execute() {
        double rez1 = 0, rez2 = 0, rez3 = 0;
        System.out.println("\nALL PRICE\n");
        for (int i = 0; i < insurance.getList().size(); i++) {
            rez1 += insurance.getList().get(i).getObligate();
        }
        System.out.printf("The total amount of the derivative is %.2f $.\n", rez1);

        for (int i = 0; i < insurance.getList().size(); i++) {
            rez2 += insurance.getList().get(i).getPrice();
        }
        System.out.printf("The total amount at price is %.2f $.\n", rez2);
    }

    public AllPriceCommand(Insurance insurance)
    {
        this.insurance = insurance;
    }
}
