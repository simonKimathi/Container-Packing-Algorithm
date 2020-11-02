package com.packing.algorithm.model;

public class Container extends Shape{
    public Container() {
    }

    private double pLength;
    private double pWidth;
    private double pHeight;

    public Container(double height, double width, double length) {
        super(height, width, length);
    }

    public void pack(double height, double width, double length) {
        this.pHeight = height;
        this.pWidth = width;
        this.pLength = length;
    }

    public final void matchPositionOf(Box box) {
        this.pack(box.getHeight(), box.getWidth(), box.getLength());
    }


}
