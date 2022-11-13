package commands;

import insurances.Insurance;

import java.util.ArrayList;

public class Exit implements Command{
    @Override
    public void do_command(ArrayList<Insurance> ins){
        System.exit(0);
    }
}
