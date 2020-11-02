package com.packingAlgorithm.shapeAction;

import com.packingAlgorithm.model.Box;
import com.packingAlgorithm.model.Shape;

import java.util.List;

public abstract class ShapeActions extends Shape implements ShapeActionsI {

    private  Box box;



    public ShapeActions() {
    }

    public ShapeActions(Box box) {
        this.box = box;
    }

    @Override
    public int getSurfaceArea() {
        return (2*(box.getLength()*box.getWidth()))
                + (2*(box.getWidth()*box.getHeight()))
                +(2*(box.getLength()*box.getHeight()));
    }

    @Override
    public int getVolume() {
        return box.getHeight()*box.getLength()*box.getWidth();
    }
    // Fields
    protected int X, Y, Z; // position

    public final void setPosition(int X, int Y, int Z) {
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    public final void matchPositionOf(ShapeActions shape) {
        this.setPosition(shape.X, shape.Y, shape.Z);
    }


    public abstract void rotateXY();

    public abstract boolean canContain(Shape shape);

    public abstract boolean attemptToContain(Shape shape);

    public abstract List<Shape> breakUp(Shape spaceOccupied);

    public abstract String toFullString();

    @Override
    public String toString() {
        return "[X=" + X + ", Y=" + Y + ", Z=" + Z + "]";
    }

    @Override
    public boolean equals(Object obj) {
        ShapeActions other = (ShapeActions) obj;
        if (X != other.X || Y != other.Y || Z != other.Z)
            return false;
        return true;
    }

    // Other Members
    public static final int getTotalVolume(List<ShapeActions> shapes) {
        int listTotalVolume = 0;
        for (ShapeActions shape : shapes) {
            listTotalVolume += shape.getVolume();
        }
        return listTotalVolume;
    }
}
