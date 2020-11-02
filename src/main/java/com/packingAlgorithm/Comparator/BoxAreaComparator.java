package com.packingAlgorithm.Comparator;


import com.packingAlgorithm.shapeAction.ShapeActions;

import java.util.Comparator;

public class BoxAreaComparator  implements Comparator<ShapeActions> {

    @Override
    public int compare(ShapeActions o1, ShapeActions o2) {
        return (int) (o1.getSurfaceArea() - o2.getSurfaceArea());
    }
}
