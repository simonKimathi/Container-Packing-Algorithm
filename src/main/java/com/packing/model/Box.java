package com.packing.model;

import java.io.Serializable;
import java.util.Objects;

public class Box implements Serializable {
     private double height;
     private double width;
     private double length;

    public Box() {
    }

    public Box(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return Double.compare(box.getHeight(), getHeight()) == 0 &&
                Double.compare(box.getWidth(), getWidth()) == 0 &&
                Double.compare(box.getLength(), getLength()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getWidth(), getLength());
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
