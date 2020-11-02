package com.packingAlgorithm.model;

public class Container extends Shape{
    public Container() {
    }

    private int pLength;
    private int pWidth;
    private int pHeight;

    public Container(int height, int width, int length) {
        super(height, width, length);
    }

    public void pack(int height, int width, int length) {
        this.pHeight = height;
        this.pWidth = width;
        this.pLength = length;
    }

    public final void matchPositionOf(Box box) {
        this.pack(box.getHeight(), box.getWidth(), box.getLength());
    }


}
