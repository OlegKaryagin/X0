package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int[] playingField = new int[9];
        int com;
        printPlayingField(playingField);
        while (true)
        {
            com = command(playingField,1);
            if (chekTheWin(playingField,com) == true)
            {
                printPlayingField(playingField);
                break;
            }
            printPlayingField(playingField);
            if (chekDraw(playingField) == true) break;
            com = command(playingField,2);
            if (chekTheWin(playingField,com) == true)
            {
                printPlayingField(playingField);
                break;
            }
            printPlayingField(playingField);
            if (chekDraw(playingField) == true) break;
        }
    }

    static boolean chekDraw(int[] field)
    {
        int notNull = 1;
            for (int i = 0; i < 9; i++)
            {
                notNull *= field[i];
            }
            if (notNull != 0)
            {
                System.out.println("Ничья!");
                return true;
            }
        return false;
    }

    static void printPlayingField(int[] field)
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                if (field[3*i+j] == 1)
                {
                    System.out.print("|x|");
                }
                else if (field[3*i+j] == 2)
                {
                    System.out.print("|0|");
                }
                else
                {
                    System.out.print("|-|");
                }
            }
            System.out.println();
        }
    }

    static int command(int[] field, int player)
    {
        int num1;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Выберите клетку:");
            int num = in.nextInt();
            num1=num-1;

            if (field[num - 1] == 0) {
                field[num - 1] = player;
                break;
            } else {
                System.out.println("Выберите другую клетку.");
            }
        }
        return num1;
    }

    static boolean chekTheWin(int[] field, int cell)
    {
        if (chekTheDiagonal(field,cell) == true) return true;
        if (chekTheLine(field, cell) == true) return true;
        if (chekTheColumn(field,cell) == true) return true;
        return false;
    }

    static boolean chekTheDiagonal(int[] field,int cell)
    {
        if (field[4]*field[0]*field[8]==1 || field[4]*field[2]*field[6]==1)
        {
            System.out.println("Победа Первого игрока!");
            return true;
        }
        if (field[4]*field[2]*field[6]==8 || field[4]*field[0]*field[8]==8)
        {
            System.out.println("Победа Второго игрока!");
            return true;
        }
        return false;
    }

    static boolean chekTheLine(int[] field,int cell) //проверка победы по горизонтали
    {
        int line = cell / 3;
        int proizvedenie = 1;
        for (int i = 0; i < 3; i++) {
            proizvedenie *= field[3 * line + i];
        }
        if (proizvedenie == 1)
        {
            System.out.println("Победа Первого игрока");
            return true;
        }
        if (proizvedenie == 8)
        {
            System.out.println("Победа Второго игрока");
            return true;
        }
        return false;
    }

    static boolean chekTheColumn(int[] field,int cell) //проверка победы по горизонтали
    {
        int column = cell % 3;
        int proizvedenie = 1;
        for (int i = 0; i < 3; i++) {
            proizvedenie *= field[3 * i + column];
        }
        if (proizvedenie == 1)
        {
            System.out.println("Победа Первого игрока");
            return true;
        }
        if (proizvedenie == 8)
        {
            System.out.println("Победа Второго игрока");
            return true;
        }
        return false;
    }
}
