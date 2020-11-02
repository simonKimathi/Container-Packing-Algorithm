package com.packingAlgorithm;

import com.packingAlgorithm.Algorithm.PackingAlgorithm;
import com.packingAlgorithm.model.Box;
import com.packingAlgorithm.model.Container;
import com.packingAlgorithm.model.Shape;
import com.packingAlgorithm.shapeAction.BoxAction;
import com.packingAlgorithm.shapeAction.ShapeActions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Set up input reader
        Scanner loInput = new Scanner(System.in);

        // enter container dimensions
        System.out.println("welcome to the program \n********************************************");
        System.out.println("Enter container width");
        int CntWidth = loInput.nextInt();
        System.out.println("Enter container Length");
        int CntLength = loInput.nextInt();
        System.out.println("Enter container Height");
        int CntHeight = loInput.nextInt();

        // Create container
        Shape loContainer = new Container(CntHeight,  CntWidth, CntLength);

        // Read box count
        System.out.println("Enter Number of boxes");
        int liBoxCount = loInput.nextInt();

        // Compile list of boxes from input
        List<ShapeActions> loBoxes = new ArrayList<>();
        while (liBoxCount-- > 0) {
            System.out.println("Enter Box width");
            int liBoxWidth = loInput.nextInt();
            System.out.println("Enter Box length");
            int liBoxLength = loInput.nextInt();
            System.out.println("Enter Box Height");
            int liBoxHeight = loInput.nextInt();
            loBoxes.add(new BoxAction(liBoxHeight,liBoxWidth, liBoxLength));



        }

        // Apply packing algorithm to input
        PackingAlgorithm loAlg = new PackingAlgorithm();
        loAlg.statPack((ShapeActions) loContainer, loBoxes);
    }
}
