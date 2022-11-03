package com.company.commands;
import com.company.Insurance;

public class ListCommand extends Command {
    @Override
    public void execute() {
        System.out.println("\nALL OBLIGATIONS\n");
        for(int i=0; i < insurance.getList().size(); i++) {
            System.out.println(insurance.getList().get(i));
        }
    }

    public ListCommand(Insurance insurance)
    {
        this.insurance = insurance;
    }
}

