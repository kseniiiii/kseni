package menu;

import commands.*;
import insurances.Insurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    private Map<String, Command> commands_tab;
    private ArrayList<Insurance> insurances= new ArrayList<>();

    public Menu() {
        commands_tab = new HashMap<>();
        commands_tab.put("add", new Add());
        commands_tab.put("delete", new Delete());
        commands_tab.put("help", new Help());
        commands_tab.put("exit", new Exit());
        commands_tab.put("show", new Show());
        commands_tab.put("derivative", new Create_Derivative());
    }

    public void execute(){
        new Help().do_command(insurances);
        while(true){
            String command = scan.next();
            try {
                commands_tab.get(command).do_command(insurances);
            }catch (Exception e){
                System.out.println("Wrong command");
                System.exit(1);
            }
        }
    }
}


