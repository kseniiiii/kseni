package com.company.commands;
import com.company.Insurance;

public class SortCommand extends Command {
    @Override
    public void execute(){
        insurance.getList().sort((o1, o2) -> (((int)(o2.getPrice()-o2.getObligate())) - ((int)(o1.getPrice()-o1.getObligate()))));
        System.out.println("\nSORTING\n");
        for(int i=0; i < insurance.getList().size(); i++) {
            System.out.println(insurance.getList().get(i));
        }
    }

    public SortCommand(Insurance insurance)
    {
        this.insurance = insurance;
    }
}
