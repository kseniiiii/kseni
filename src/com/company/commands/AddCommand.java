package com.company.commands;
import com.company.Obligation;
import com.company.Insurance;

public class AddCommand extends Command {
    @Override
    public void execute() {
        insurance.getList().add(new Obligation(true));
    }
    public AddCommand(Insurance insurance)
    {
        this.insurance = insurance;
    }
}
