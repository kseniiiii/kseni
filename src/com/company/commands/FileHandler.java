package com.company.commands;

import com.company.Insurance;
import com.company.commands.Command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler extends Command {
    @Override
    public void execute() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
        System.out.println("FILE SAVED test.txt!\n");
        writer.write("\nFILE SAVED\n");
        writer.write("\nALL OBLIGATIONS\n");
        Insurance insurance = null;
        for(int i = 0; i < insurance.getList().size(); i++) {
            writer.write(insurance.getList().get(i).toString());
            writer.write("\n");
        }
        writer.close();
    }

    public FileHandler(Insurance insurance)
    {
        this.insurance = insurance;
    }
}

