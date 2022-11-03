package com.company;

import com.company.commands.*;

import java.io.IOException;

import java.util.Scanner;



public class Program {

    Insurance insuranc = new Insurance();

    Developer devoloper = new Developer(

            new AddCommand(insuranc),

            new AllPriceCommand(insuranc),

            new ListCommand(insuranc),

            new SearchCommand(insuranc),

            new SortCommand(insuranc),

            new FileHandler(insuranc),

            new Certificate(insuranc)

    );



    int select;

    Scanner scanner = new Scanner(System.in);



    private void PrintMenu() {

        System.out.println("\n_____________________________________"+

                "\n|    Choose what you want to do:     |" +

                "\n|                                    |" +

                "\n| 1. Add a new obligation.           |" +

                "\n| 2. Price of the obligation.        |" +

                "\n| 3. Obligation list.                |" +

                "\n| 4. Search obligation.              |" +

                "\n| 5. Sort obligation.                |" +

                "\n| 6. Save file.                      |" +

                "\n| 7. Certificate.                    |" +

                "\n| 8. Exit.                           |" +

                "\n|____________________________________|"

        );

    }



    public void Work() throws IOException {

        while (true) {

            PrintMenu();

            SelectMenuItem();

        }

    }



    private void SelectMenuItem() throws IOException {

        select = scanner.nextInt();

        switch (select) {

            case 1 -> devoloper.Execute(0);

            case 2 -> devoloper.Execute(1);

            case 3 -> devoloper.Execute(2);

            case 4 -> devoloper.Execute(3);

            case 5 -> devoloper.Execute(4);

            case 6 -> devoloper.Execute(5);

            case 7 -> devoloper.Execute(6);

            case 8 -> System.exit(0);

            default -> System.out.println("Oops error...\n" + "Try typing again ->");

        }

    }

}
