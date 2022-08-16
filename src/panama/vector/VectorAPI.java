package panama.vector;

import java.util.Arrays;

import jdk.incubator.vector.*;

public class VectorAPI {
	public static void main(String[] args) {
		int[] first = new int[] { 1, 2, 3, 4 };
		int[] second = new int[] { 5, 6, 7, 8 };// SPECIES_PREFERRED
		// VectorSpecies<Integer> species = IntVector.SPECIES_128;
		VectorSpecies<Integer> species = IntVector.SPECIES_PREFERRED;
		VectorMask<Integer> mask = VectorMask.fromLong(species, 0xF);
		IntVector firstVector = IntVector.fromArray(species, first, 0, mask);
		System.out.println(Arrays.toString(firstVector.mul(2).toArray()));
		IntVector secondVector = IntVector.fromArray(species, second, 0, mask);
		IntVector result = firstVector.add(secondVector);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
