package com.company;
import com.company.commands.Command;
import java.io.IOException;

public class Developer {
    Command[] arr = new Command[7];
    public Developer(Command addNew, Command allPrice, Command list, Command search, Command sort, Command file, Command certificate) {
        this.arr[0] = addNew;
        this.arr[1] = allPrice;
        this.arr[2] = list;
        this.arr[3] = search;
        this.arr[4] = sort;
        this.arr[5] = file;
        this.arr[6] = certificate;
    }

    public void Execute(int num) throws IOException {this.arr[num].execute();}
}
