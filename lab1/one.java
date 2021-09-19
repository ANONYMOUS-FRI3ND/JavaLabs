package com.company;



class one {


    public static void main (String[] args) {
        var o = new two (0, 0);
        int i, j;
        for (i = 1; i <= 8; i++) {
            for (j = 1; j <= 8; j++) {
                o.setX(i);
                o.setY(j);
                System.out.print(o.mult());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}