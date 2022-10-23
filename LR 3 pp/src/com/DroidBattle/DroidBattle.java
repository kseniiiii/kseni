package com.DroidBattle;
import com.Droid.Droid ;
import com.BattleArena.BattleArena;

import java.util.Scanner;

public class DroidBattle {
    private Droid[] arrOfDroids = new Droid[4];
    private Droid[] team1 = new Droid[arrOfDroids.length / 2];
    private static int index = 0;// використовується для індексації дроїдів

    public Droid createDroid()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("_______________________________");
        System.out.print("|Enter the name of droid: ");
        String droidName = scanner.nextLine();
        System.out.println("``````````````````````````````");
        //перевірка на унікальність імені
        for (int i = 0; (i < arrOfDroids.length && arrOfDroids[i] != null); ++i) {
            while (arrOfDroids[i].getName().equals(droidName))     //провіряє на рівність імен
            {
                System.out.println("\nSorry, but you must chooce another name!");
                System.out.print("Enter the new name of droid: ");
                droidName = scanner.nextLine();
                i = 0;
            }
        }
        System.out.println("_______________________________");
        System.out.print("|Enter the health of droid: ");
        int droidHealth = scanner.nextInt();
        System.out.println("``````````````````````````````");
        System.out.println("_______________________________");
        System.out.print("|Enter the maxDamage of droid: ");
        int droidMaxDamage = scanner.nextInt();
        System.out.println("``````````````````````````````");
        System.out.println();

        return new Droid(droidName, droidHealth, droidMaxDamage);//повертаємо параметри нового дрона
    }

    public void removeDroid()
    {
        boolean droidToRemoveIsFound = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("``````````````````````````````");
        System.out.print("Enter the name of droid to remove: ");
        String name = scanner.nextLine();
        System.out.println("``````````````````````````````");

        //виконується пошук заданого імені дрона в нашому масиві
        //якщо ім'я знайдено, останній дрон стає на його місце
        for (int i = 0; (i < arrOfDroids.length && arrOfDroids[i] != null); ++i)
            if (arrOfDroids[i].getName().equals(name)) {
                arrOfDroids[i] = arrOfDroids[--index];
                arrOfDroids[index] = null;
                droidToRemoveIsFound = true;
                System.out.println("Done!");
            }
        if (droidToRemoveIsFound == false)
            System.out.println("There is no droid with name " + name);
        System.out.println();
    }

    public void showDroids() //функція,яка виводить всі дроїди
    {
        if (arrOfDroids[0] != null)
            for (int i = 0; (i < arrOfDroids.length && arrOfDroids[i] != null); ++i)
                System.out.println(arrOfDroids[i]);
        else
            System.out.println("You haven't created any droids yet!");
        System.out.println();
    }

    public Droid chooceDroidToFight() //функія відбору дроїдів для битви
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of droid to chooce him to fight: ");
        String name = scanner.nextLine();

        for (int i = 0; (i < arrOfDroids.length && arrOfDroids[i] != null); ++i)
            if(arrOfDroids[i].getName().equals(name))
                return arrOfDroids[i]; // якщо дрон знайдений повертаємо його параметри

        return arrOfDroids[0];
    }

    public Droid[] createTeamOfDroids(String numOfTeam) //відбір для командної гри
    {
        Droid teamOfDroids[] = new Droid[team1.length];

        System.out.println("You should define the names of two droids to add them to " + numOfTeam + " team:");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < team1.length; ++i) {
            System.out.print("Enter the name of " + (i + 1) + " droid: ");
            String name = scanner.nextLine();

            for (int j = 0; (j < arrOfDroids.length && arrOfDroids[j] != null); ++j)
                if (arrOfDroids[j].getName().equals(name))
                    teamOfDroids[i] = arrOfDroids[j];
        }
        System.out.println("");
        return teamOfDroids;
    }

    public void startGame() {
        boolean exut = true;
        int userChooce;
        do {
            System.out.println("|```````````````````````````````````|");
            System.out.println("|------------- MENU ----------------|");
            System.out.println("|-[1] To create a droid             |");
            System.out.println("|-[2] To remove a droid             |");
            System.out.println("|-[3] To show a list of droids      |");
            System.out.println("|-[4] To start an [one-vs-one] fight|");
            System.out.println("|-[5] To start [team-vs-team] fight |");
            System.out.println("|-[6] To quit                       |");
            System.out.println("|___________________________________|");
            Scanner scanner = new Scanner(System.in);
            userChooce = scanner.nextInt();
            System.out.println();

            switch (userChooce)
            {
                case 1:
                    if (index < arrOfDroids.length)
                        arrOfDroids[index++] = createDroid();
                    else
                        System.out.println("Sorry, You have created the ultimate number of droids you could!\n");
                    break;

                case  2:
                    if (arrOfDroids[0] != null)
                        removeDroid();
                    else
                        System.out.println("Sorry, You have no droids to remove!\n");
                    break;

                case 3:
                    showDroids();
                    break;

                case 4:
                    if (arrOfDroids[1] != null) {
                        Droid droid1 = chooceDroidToFight();
                        Droid droid2 = chooceDroidToFight();
                        BattleArena simpleBattle = new BattleArena(droid1, droid2);
                        simpleBattle.fight();
                    }
                    else
                        System.out.println("Sorry, but there aren't enough droids to have a fight!\n");
                    break;

                case 5:
                    if (arrOfDroids[arrOfDroids.length - 1] != null) {
                        team1 = createTeamOfDroids("first");
                        Droid[] team2 = createTeamOfDroids("second");
                        int countOfVictories1 = 0, countOfVictories2 = 0;

                        for (int i = 0; i < team1.length; ++i) {
                            BattleArena battle = new BattleArena(team1[i], team2[i]);
                            battle.fight();
                            Droid winner = battle.battleWinner();
                            if (winner.getName().equals(team1[i].getName()))
                                ++countOfVictories1;
                            else
                                ++countOfVictories2;
                        }

                        if (countOfVictories1 > countOfVictories2)
                            System.out.println("The first team has won!\n----------------------------\n");
                        else if (countOfVictories2 > countOfVictories1)
                            System.out.println("The second team has won!\n----------------------------\n");
                        else
                            System.out.println("We have a draw!\n----------------------------\n");
                    }
                    else
                        System.out.println("Sorry, You should create more droids to have them to fight!\n");
                    break;

                case 6:
                    exut = false;
                    System.out.println("You have chosen a wrong variant! Please, try again.\n");
            }
        } while (exut);
        System.out.println("Thanks for playing! We will wait for you!");
    }
}

