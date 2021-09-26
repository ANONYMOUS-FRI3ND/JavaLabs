package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Длина вектора:");
        int length = Integer.parseInt(reader.readLine());

        var vector = new Vector(length);

        System.out.println("Значения:");
        for (int i = 0; i < length; ++i) {
            vector.set(i, Double.parseDouble(reader.readLine()));
        }

        System.out.println("Min: " + vector.getMin());
        System.out.println("Max: " + vector.getMax());
        System.out.println("Norm: " + vector.norm());

        System.out.println("До сортировки:");
        System.out.println(vector);
        vector.sort();
        System.out.println("После сортировки:");
        System.out.println(vector);

        System.out.println("Умножение на число:");
        vector.multiply(Double.parseDouble(reader.readLine()));
        System.out.println("После умножения:");
        System.out.println(vector);

        System.out.println("Сумма:");
        vector.sum(vector);
        System.out.println(vector);

        System.out.println("Скалярное произведение:");
        vector.scalar(vector);
        System.out.println(vector);
    }
}