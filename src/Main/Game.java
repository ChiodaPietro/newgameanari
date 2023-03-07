package Main;

import objects.Disk;
import objects.Pile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BinaryOperator;

public class Game {
    private Pile<Disk> firstPile;
    private Pile<Disk> secondPile;
    private Pile<Disk> thirdPile;
    private BufferedReader bufferedReader;
    private int moves;

    public Game(int difficulty) {
        moves=0;
        firstPile = new Pile<>(difficulty);
        fillFirstPile(difficulty);
        secondPile = new Pile<>(difficulty);
        thirdPile = new Pile<>(difficulty);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        game();
    }

    public void fillFirstPile(int difficulty) {
        for (int i = difficulty; i > 0; i--) {
            firstPile.push(new Disk(i));
        }
    }

    public void game() {
        boolean exit = false;
        while (!exit) {
            output();
            System.out.println("continue with 1 exit with 2");
            try {
                switch (bufferedReader.readLine()) {
                    case "1":
                        System.out.println("tower");
                        switch (bufferedReader.readLine()) {
                            case "1":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()) {
                                    case "2":
                                        if (secondPile.getSize() > 0) {
                                            if (secondPile.getLastElement().getSize() < firstPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(secondPile.push(firstPile.pop()))) {
                                            System.out.println("the pile is already full");
                                        }

                                        break;
                                    case "3":
                                        if (thirdPile.getSize() > 0) {
                                            if (thirdPile.getLastElement().getSize() < firstPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(thirdPile.push((firstPile.pop())))) {
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                            case "2":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()) {
                                    case "1":
                                        if (firstPile.getSize() > 0) {
                                            if (firstPile.getLastElement().getSize() < secondPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(firstPile.push(secondPile.pop()))) {
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                    case "3":
                                        if (thirdPile.getSize() > 0) {
                                            if (thirdPile.getLastElement().getSize() < secondPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(thirdPile.push((secondPile.pop())))) {
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                            case "3":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()) {
                                    case "2":
                                        if (secondPile.getSize() > 0) {
                                            if (secondPile.getLastElement().getSize() < thirdPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(secondPile.push(thirdPile.pop()))) {
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                    case "1":
                                        if (firstPile.getSize() > 0) {
                                            if (firstPile.getLastElement().getSize() < thirdPile.getLastElement().getSize()) {
                                                break;
                                            }
                                        }
                                        if (!(firstPile.push((thirdPile.pop())))) {
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case "2":
                        exit = true;
                        break;
                    default:
                        System.out.println("wrong input");
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
            moves++;
            if(check_second_pile()||check_third_pile()){
                System.out.println("you won!");
                System.out.println("total moves: " +moves);
                exit=true;
            }
        }
    }

    public boolean check_third_pile() {
        try {
            for (int i = 0; i < thirdPile.getCapacity(); i++) {
                if (thirdPile.get(i).getSize() != thirdPile.getCapacity() - i) {
                    return false;
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("not finished yet");
            return false;
        }
        return true;
    }
        public boolean check_second_pile() {
        try {
            for (int i = 0; i < secondPile.getCapacity(); i++) {
                if (secondPile.get(i).getSize() != secondPile.getCapacity() - i) {
                    return false;
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("not finished yet");
            return false;
        }
            return true;
        }

    public void output() {
        System.out.printf("%-22s%-22s%-22s\n", "Column 1", "Column 2", "Column 3");
        System.out.printf("%-22s%-22s%-22s", firstPile.toString(), secondPile.toString(),thirdPile.toString());
    }
}
