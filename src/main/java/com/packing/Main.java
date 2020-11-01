package com.packing;

import com.packing.algorithm.Algorithm;
import com.packing.model.Box;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        Box container = new Box();
        Map<Integer, Box> packingBoxes = new HashMap<>();

        System.out.println("Enter container dimensions\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter container length:");
        container.setLength(in.nextDouble());
        in.nextLine();
        System.out.println("Enter container width:");
        container.setWidth(in.nextDouble());
        in.nextLine();
        System.out.println("Enter container height:");
        container.setHeight(in.nextDouble());
        in.nextLine();

        System.out.println("\n");
        /*
        Enter boxes of different sizes
         */
        boolean isEnd = true;
        do {
            in = new Scanner(System.in);
            Box box = new Box();
            System.out.println("Enter box length:");
            box.setLength(in.nextDouble());
            in.nextLine();
            System.out.println("Enter box width:");
            box.setWidth(in.nextDouble());
            in.nextLine();
            System.out.println("Enter box height:");
            box.setHeight(in.nextDouble());
            in.nextLine();
            System.out.println("Enter number of boxes of this size");

            int num = in.nextInt();
            in.nextLine();

            packingBoxes.put(num, box);

            System.out.println("Continue? y/n");
            String yN = in.nextLine();
            if (yN.toLowerCase().equalsIgnoreCase("n")) {
                isEnd = false;
            }
        } while (isEnd);

        Algorithm algorithm = new Algorithm(container, packingBoxes);
        System.out.println(algorithm.toString());
    }

}
