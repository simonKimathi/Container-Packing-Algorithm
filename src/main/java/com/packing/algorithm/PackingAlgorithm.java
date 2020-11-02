package com.packing.algorithm;


import java.util.*;

public class PackingAlgorithm {

	private static boolean ibShowProgress = false; // show progress? (slows algorithm)


	public void statPack(Shape aoContainer, List<Shape> aoShapes) {
		System.out.println("Starting to pack.");

		// Create clone of shapes
		ArrayList loShapesCopy = new ArrayList<Shape>(Arrays.asList(aoShapes
				.toArray(new Shape[0])));
		
		// Start time stamp
		long llStartTime = System.currentTimeMillis();

		// Run Algorithm
		int liNumContainers = this.pack(aoContainer, loShapesCopy);
		
		// End time stamp
		long llEndTime = System.currentTimeMillis();

		// Compute statistics
		long llElapsedTime = llEndTime - llStartTime;
		int liNumBoxesPacked = (aoShapes.size() - loShapesCopy.size());
		int liTotalBoxVolume = Shape.getTotalVolume(aoShapes);
		int liTotalContainerVolume = (liNumContainers * aoContainer.getVolume());
		float lfPackingEfficiency = ((float) liTotalBoxVolume / liTotalContainerVolume);

		// Output results
		System.out.println("Complete.");
		System.out.println("Packed " + liNumBoxesPacked + " of " + aoShapes.size()
				+ " boxes into " + liNumContainers + " container(s) of "
				+ aoContainer);
		System.out.println("Statistics:");
		System.out.println("Time elapsed: \t\t" + llElapsedTime
				+ " milliseconds");
		System.out.println("Average: \t\t"
				+ ((float) liNumBoxesPacked / liNumContainers)
				+ " boxes/container");
		System.out.println("Packing efficiency: \t"
				+ (lfPackingEfficiency * 100) + "%");
	}
	
	/**
	 * Ports to packing algorithm.
	 * @param  aoContainer the container to use
	 * @param  aoShapes    the shapes to fit
	 * @return 			   the number of containers used
	 * @see 	           PackingAlgorithm#pack(Shape, List, int, boolean)
	 */
	public int pack(Shape aoContainer, List<Shape> aoShapes) {
		// Optimize algorithm performance by sorting the boxes (area ascending)
		Collections.sort(aoShapes, new shapeAreaComparator());
		Collections.reverse(aoShapes);
		return this.pack(aoContainer, aoShapes, 0, false);
	}

	/**
	 * A recursive packing algorithm that attempts to pack the specified boxes
	 * into the specified container. (No validation is done. e.g. it may not
	 * work if a box is too large to fit into the container)
	 * 
	 * @param  aoContainer    the container to use
	 * @param  aoShapes    	  the shapes to fit
	 * @param  aiContainerNum the container's number (starts at 0)
	 * @param  abSubContainer If container is whole or a split
	 * @return 				  the number of containers used
	 */
	private int pack(Shape aoContainer, List<Shape> aoShapes,
			int aiContainerNum, boolean abSubContainer) {

		// Step 1: Find a shape that fits into the container
		Iterator<Shape> loIterator = aoShapes.iterator();
		Shape loCurrentShape = null;
		boolean lbFoundFit = false;
		while (!lbFoundFit && loIterator.hasNext()) {
			loCurrentShape = loIterator.next();
			// Can this shape fit inside the container?
			if (aoContainer.attemptToContain(loCurrentShape))
				lbFoundFit = true;
		}

		if (lbFoundFit) {
			// Step 2: If found, position shape inside container
			loCurrentShape.matchPositionOf(aoContainer);
			aoShapes.remove(loCurrentShape);
			
			if (ibShowProgress)
				System.out.println("Packed " + loCurrentShape.toFullString()
						+ " into container " + aiContainerNum + ".");

			// Step 3: Split the unoccupied region around this shape into sub 
			// containers and run algorithm along each
			List<Shape> loSubContainers = loCurrentShape.breakUp(aoContainer);
			for (Shape loSubContainer : loSubContainers) {
				this.pack(loSubContainer, aoShapes, aiContainerNum, true);
			}
		}

		// Step 4: If there are boxes left to pack, use an additional container
		if (abSubContainer == false && aoShapes.size() > 0) {
			return this.pack(aoContainer, aoShapes, aiContainerNum + 1, false);
		} else {
			// Otherwise, return total number of containers used
			return aiContainerNum + 1;
		}
	}
}
