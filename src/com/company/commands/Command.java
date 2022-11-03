package com.company.commands;
import com.company.Insurance;
import java.io.IOException;

public abstract class Command {
    Insurance insurance;
    public abstract void execute() throws IOException;
}
