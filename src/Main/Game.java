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
    public Game(int difficulty){
        firstPile=new Pile<>(difficulty);
        fillFirstPile(difficulty);
        secondPile=new Pile<>(difficulty);
        thirdPile=new Pile<>(difficulty);
        bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        game();
    }
    public void fillFirstPile(int difficulty){
        for (int i = 1; i <=difficulty; i++) {
            firstPile.push(new Disk(i));
        }
    }
    public void game(){
        boolean exit=false;
        while(!exit){
            output();
            try {
                switch (bufferedReader.readLine()) {
                    case "1":
                        System.out.println("tower");
                        switch (bufferedReader.readLine()){
                            case "1":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()){
                                    case"2":
                                        if(!(secondPile.push(firstPile.pop()))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                    case"3":
                                        if(!(thirdPile.push((firstPile.pop())))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                            case"2":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()){
                                    case"1":
                                        if(!(firstPile.push(secondPile.pop()))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                    case"3":
                                        if(!(thirdPile.push((secondPile.pop())))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                            case "3":
                                System.out.println("where do you want to place the disk?");
                                switch (bufferedReader.readLine()){
                                    case"2":
                                        if(!(secondPile.push(thirdPile.pop()))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                    case"1":
                                        if(!(firstPile.push((thirdPile.pop())))){
                                            System.out.println("the pile is already full");
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                    case"2":
                        exit=true;
                        break;
                    default:
                        System.out.println("wrong input");
                }
            }catch (Exception e){
                System.out.println("Wrong input");
            }
        }
    }
    public void output(){
        System.out.printf("%-22s%-22s%-22s\n","Column 1","Column 2","Column 3");
        System.out.printf("%-22s%-22s%-22s\n",firstPile.toString(),secondPile.toString(),thirdPile.toString());
    }
}
