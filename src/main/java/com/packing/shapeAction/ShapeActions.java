package com.packing.shapeAction;

import com.packing.model.Box;
import com.packing.model.Shape;

public class ShapeActions extends Shape implements ShapeActionsI {
    private final Box box;

    public ShapeActions(Box box) {
        this.box = box;
    }

    @Override
    public double getSurfaceArea() {
        return (2*(box.getLength()*box.getWidth()))
                + (2*(box.getWidth()*box.getHeight()))
                +(2*(box.getLength()*box.getHeight()));
    }

    @Override
    public double getVolume() {
        return box.getHeight()*box.getLength()*box.getWidth();
    }
}
