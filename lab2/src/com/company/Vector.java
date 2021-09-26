package com.company;
import java.util.Arrays;

public class Vector {
    private double[]vector;

    public Vector(int length) {
        vector = new double[length];
    }

    public double get(int index) {
        return vector [index];
    }

    public void set(int index, double value) {
        vector[index] = value;
    }

    public int getLength() {
        return vector.length;
    }

    public double getMin() {
        var min = vector[0];

        for (var item : vector) {
            if (item < min) {
                min = item;
            }
        }

        return min;
    }

    public double getMax() {
        var max = vector[0];

        for (var item : vector) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    public void sort() {
        for (var i = 0; i < vector.length - 1; ++i) {
            for (var j = 0; j < vector.length - i - 1; ++j) {
                if (vector[j] > vector[j + 1]) {
                    var temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }

    public double norm() {
        var norm = 0;
        for (var item : vector) {
            norm += item * item;
        }
        return Math.sqrt(norm);
    }

    public void multiply(double k) {
        for (var i = 0; i < vector.length; ++i) {
            vector[i] *= k;
        }
    }

    public void sum(Vector v) {
        for (var i = 0; i < vector.length; ++i) {
            vector[i] += v.get(i);
        }
    }

    public void scalar(Vector v) {
        for (var i = 0; i < vector.length; ++i) {
            vector[i] *= v.get(i);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }
}