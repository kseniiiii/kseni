package commands;

import insurances.Insurance;

import java.util.ArrayList;

public class Help implements Command{


    @Override
    public void do_command(ArrayList<Insurance> ins) {
        System.out.println("add - to add insurance");
        System.out.println("delete - to delete insurance");
        System.out.println("help - to get commands");
        System.out.println("exit - to finish process");
        System.out.println("show - to show all insurances");
        System.out.println("derivative - to create derivative");
    }
}
