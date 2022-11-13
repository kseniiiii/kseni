package commands;

import insurances.Insurance;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete implements Command{
    Scanner scan = new Scanner(System.in);

    @Override
    public void do_command(ArrayList<Insurance> ins) {
        int numb;
        System.out.println("Enter number of insurance to delete");
        numb = scan.nextInt() - 1;
        if(numb < 0 || numb > ins.size())
            return;
        ins.remove(numb);
        ins.trimToSize();
    }
}

