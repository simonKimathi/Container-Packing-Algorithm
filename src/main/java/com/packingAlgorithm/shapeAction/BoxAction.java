package com.packingAlgorithm.shapeAction;

import com.packingAlgorithm.model.Shape;
import com.packingAlgorithm.model.Container;
import com.packingAlgorithm.model.Box;

import java.util.Arrays;
import java.util.List;

public class BoxAction extends ShapeActions {

    public BoxAction(Box box) {
        super(box);
    }

    // Fields
    protected int Width, Length, Height; // dimensions

    public BoxAction(int Width, int Length, int Height) {
        this.Width = Width;
        this.Length = Length;
        this.Height = Height;
    }

    public BoxAction(int Width, int Length, int Height, int X, int Y, int Z) {

        super.setPosition(X, Y, Z);
        this.Width = Width;
        this.Length = Length;
        this.Height = Height;
    }



    @Override
    public void rotateXY() {
        // swap width and length
        int refWidth = this.Width;
        this.Width = this.Length;
        this.Length = refWidth;
    }

    @Override
    public boolean canContain(Shape shape) {
        if (shape instanceof Box)
            return canContain((Box) shape);
        return false;
    }

    public boolean canContain(BoxAction box) {
        return (box.Width <= this.Width
                && box.Length <= this.Length && box.Height <= this.Height);
    }

    @Override
    public boolean attemptToContain(Shape shape) {
        if (shape instanceof Box)
            return attemptToContain((Box) shape);
        return false;
    }



    public boolean attemptToContain(Box box) {
        if (canContain(box))
            return true;
        rotateXY();
        if (canContain(box))
            return true;
        rotateXY(); // back to default
        return false;
    }

    public List<ShapeActions> breakUp(ShapeActions shape) {
        if (shape instanceof BoxAction)
            return breakUp( shape);
        return null;
    }

    public List<ShapeActions> breakUp(BoxAction box) {
        ShapeActions SubBoxX = new BoxAction(box.Width - this.Width, box.Length,
                box.Height, this.X + this.Width, box.Y, box.Z);
        ShapeActions SubBoxY = new BoxAction(this.Width, box.Length - this.Length,
                box.Height, this.X, box.Y + this.Length, box.Z);
        ShapeActions SubBoxZ = new BoxAction(this.Width, this.Length, box.Height
                - this.Height, this.X, box.Y, box.Z + this.Height);
        return Arrays.asList(SubBoxX, SubBoxY, SubBoxZ);
    }


    @Override
    public String toFullString() {
        return "Box [Width=" + Width + ", Length=" + Length + ", Height="
                + Height + ", Position=" + super.toString() + "]";
    }

    @Override
    public String toString() {
        return "Box [Width=" + Width + ", Length=" + Length + ", Height="
                + Height + "]";
    }


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
        BoxAction otherBox = (BoxAction) obj;
        if (Width != otherBox.Width || Length != otherBox.Length
                || Height != otherBox.Height)
            return false;
        return true;
    }
}
