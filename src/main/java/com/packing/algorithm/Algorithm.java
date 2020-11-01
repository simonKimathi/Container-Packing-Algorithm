package com.packing.algorithm;

import com.packing.boxAction.BoxActions;
import com.packing.boxAction.BoxActionsI;
import com.packing.model.Box;

import java.util.Map;

public class Algorithm implements AlgorithmI{
    protected final Map<Integer,Box> packingBoxes;
    BoxActionsI containerBoxActionsI;

    public Algorithm(Box container, Map<Integer, Box> packingBoxes) {
        this.packingBoxes = packingBoxes;
        this.containerBoxActionsI =new BoxActions(container);
    }

    @Override
    public double getTotalPackingBoxSA() {
        double totalSurfaceArea=0;
        for (Map.Entry<Integer, Box> entry : this.packingBoxes.entrySet()) {
            Integer integer = entry.getKey();
            Box box = entry.getValue();
            totalSurfaceArea += (integer * (new BoxActions(box).getSurfaceArea()));
        }
        return totalSurfaceArea;
    }

    @Override
    public double getTotalPackingBoxVolume() {
        double totalVolume=0;
        for (Map.Entry<Integer, Box> entry : this.packingBoxes.entrySet()) {
            Integer integer = entry.getKey();
            Box box = entry.getValue();
            totalVolume += (integer * (new BoxActions(box).getVolume()));
        }
        return totalVolume;
    }

    @Override
    public double getContainerSA() {
        return this.containerBoxActionsI.getSurfaceArea();
    }

    @Override
    public double getWastedSpace() {
        return (getContainerSA()-getTotalPackingBoxSA());
    }

    @Override
    public int getNumBoxes() {
        return packingBoxes.keySet().stream().mapToInt(integer -> integer).sum();
    }

    @Override
    public double getContainerVolume() {
        return this.containerBoxActionsI.getVolume();
    }

    @Override
    public String toString() {
        return String.format("Number of Boxes : %s\n" +
                "Volume of packed Boxes : %s\n" +
                "Volume of container : %s\n" +
                "Wasted Space : %s\n",getNumBoxes(),getTotalPackingBoxVolume(),getContainerVolume(),getWastedSpace());
    }
}