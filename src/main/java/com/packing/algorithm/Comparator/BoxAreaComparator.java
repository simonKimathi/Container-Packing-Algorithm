package com.packing.algorithm.Comparator;

import com.packing.algorithm.Shape;

import java.util.Comparator;

public class BoxAreaComparator  implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return (o1.getArea() - o2.getArea());
    }
}
