package com.packing.shapeAction;

import com.packing.algorithm.Shape;
import com.packing.algorithm.model.Container;
import com.packing.model.Box;

import java.util.Arrays;
import java.util.List;

public class BoxAction extends ShapeActions {
    public BoxAction(Box box) {
        super(box);
    }

    protected Box box;


    public BoxAction(Box box, Container container) {
        super(box);
        container.pack(container.getHeight(),container.getWidth(),container.getLength());

    }




    public void rotateXY() {
        // swap width and length
        double loWidth = box.getWidth();
        box.setWidth(box.getLength());
        box.setLength(loWidth);
    }


    public boolean canContain(Box box) {
        if (box instanceof(BoxAction) BoxAction)
            return canContain( box);
        return false;
    }

    /**
     * Box implementation.
     * @see Shape#canContain(Shape)
     */
    public boolean canContain(com.packing.algorithm.Box aoBox) {
        return (aoBox.iiWidth <= this.iiWidth
                && aoBox.iiLength <= this.iiLength && aoBox.iiHeight <= this.iiHeight);
    }

    /**
     * @see Shape#attemptToContain(Shape)
     */
    @Override
    public boolean attemptToContain(Shape aoShape) {
        if (aoShape instanceof com.packing.algorithm.Box)
            return attemptToContain((com.packing.algorithm.Box) aoShape);
        return false;
    }

    /**
     * Box implementation.
     * @see Shape#attemptToContain(Shape)
     */
    public boolean attemptToContain(com.packing.algorithm.Box aoBox) {
        if (canContain(aoBox))
            return true;
        rotateXY();
        if (canContain(aoBox))
            return true;
        rotateXY(); // back to default
        return false;
    }

    /**
     * @see Shape#breakUp(Shape)
     */
    @Override
    public List<Shape> breakUp(Shape aoShape) {
        if (aoShape instanceof com.packing.algorithm.Box)
            return breakUp((com.packing.algorithm.Box) aoShape);
        return null;
    }

    /**
     * Box implementation (Assumes this shape can fit into specified shape).
     * @see Shape#breakUp(Shape)
     */
    public List<Shape> breakUp(com.packing.algorithm.Box aoBox) {
        Shape loSubBoxX = new com.packing.algorithm.Box(aoBox.iiWidth - this.iiWidth, aoBox.iiLength,
                aoBox.iiHeight, this.iiX + this.iiWidth, aoBox.iiY, aoBox.iiZ);
        Shape loSubBoxY = new com.packing.algorithm.Box(this.iiWidth, aoBox.iiLength - this.iiLength,
                aoBox.iiHeight, this.iiX, aoBox.iiY + this.iiLength, aoBox.iiZ);
        Shape loSubBoxZ = new com.packing.algorithm.Box(this.iiWidth, this.iiLength, aoBox.iiHeight
                - this.iiHeight, this.iiX, aoBox.iiY, aoBox.iiZ + this.iiHeight);
        return Arrays.asList(loSubBoxX, loSubBoxY, loSubBoxZ);
    }

    /**
     * Returns a string formated representation of box's dimensions and position.
     * @see Shape#toFullString()
     */
    @Override
    public String toFullString() {
        return "Box [Width=" + iiWidth + ", Length=" + iiLength + ", Height="
                + iiHeight + ", Position=" + super.toString() + "]";
    }

    /**
     * Returns a string formated representation of box's dimensions
     * @see Shape#toString()
     */
    @Override
    public String toString() {
        return "Box [Width=" + iiWidth + ", Length=" + iiLength + ", Height="
                + iiHeight + "]";
    }

    /**
     * Compares this box to the specified object.
     * @see Shape#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        if (!super.equals(obj))
            return false;
        com.packing.algorithm.Box other = (com.packing.algorithm.Box) obj;
        if (iiWidth != other.iiWidth || iiLength != other.iiLength
                || iiHeight != other.iiHeight)
            return false;
        return true;
    }
}
