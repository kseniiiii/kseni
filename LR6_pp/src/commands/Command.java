package commands;

import insurances.Insurance;

import java.util.ArrayList;

public interface Command {
    void do_command(ArrayList<Insurance> ins);
}

