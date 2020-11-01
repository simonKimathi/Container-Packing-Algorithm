package com.packing.boxAction;

import com.packing.model.Box;

public class BoxActions implements BoxActionsI {
    private final Box box;

    public BoxActions(Box box) {
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
