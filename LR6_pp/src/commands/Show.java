package commands;

import insurances.Insurance;

import java.util.ArrayList;

public class Show implements Command{

    @Override
    public void do_command(ArrayList<Insurance> ins) {
        for (Insurance insurance : ins) {
            System.out.println(insurance);
        }
    }
}
