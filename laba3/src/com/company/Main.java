package com.company;

import java.util.*;


public class Main {
    private static LinkedList<GetSet> collections = new LinkedList<GetSet>();
    private static String name = "";
    private static int intrParphCount = 0;
    private static ArrayList<Integer> paragraphCount = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount2 = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount3 = new ArrayList<Integer>();
    private static ArrayList<Integer> paragraphCount4 = new ArrayList<Integer>();

    public static void main(String[] args){


        var GameOne = new Games(); // Экземпляры
        var GameTwo = new Games();
        var FilmOne = new Films();
        var FilmTwo = new Films();

        try {
            GameOne.setParagraphСount(paragraphCount);
            paragraphCount.add(10);
            GameOne.setName("Game#1");
            GameOne.setIntrParphCount(1);
            collections.add(GameOne);


            GameTwo.setParagraphСount(paragraphCount2);
            paragraphCount2.add(15);
            GameTwo.setName("Game#2");
            GameTwo.setIntrParphCount(3);
            collections.add(GameTwo);

            FilmOne.setParagraphСount(paragraphCount3);
            paragraphCount3.add(25);
            FilmOne.setName("Film#1");
            FilmOne.setIntrParphCount(2);
            collections.add(FilmOne);

            FilmTwo.setParagraphСount(paragraphCount4);
            paragraphCount4.add(20);
            FilmTwo.setName("Film#2");
            FilmTwo.setIntrParphCount(4);
            collections.add(FilmTwo);
        }

        catch (WrongParException ex)
        {
            System.err.println(ex.getMessage());
        }



        var map = new HashMap<Integer, LinkedList<GetSet>>(); // Массив, содержащий значение и ключ к нему
        int key;
        for (GetSet col : collections) {
            key = col.paragraphCountWithoutIntr(0);
            if (map.containsKey(key)) {
                map.get(key).add(col);
            } else {
                var list = new LinkedList<GetSet>();
                list.add(col);
                map.put(key, list);
            }
        }


        System.out.println(map);

        var Games = new LinkedList<Games>(); // Разбитие на два массива
        var Films = new LinkedList<Films>();
        for (GetSet col : collections) {
            if (col instanceof Games) {
                Games.add((Games) col);
            }

            else if (col instanceof Films) {
                Films.add((Films) col);
            }
        }

        System.out.println("Games");
        System.out.println(Games);
        System.out.println("Films");
        System.out.println(Films);
    }
}