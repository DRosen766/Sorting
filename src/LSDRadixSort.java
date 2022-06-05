import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.print.event.PrintEvent;

// T must extend Integer to it is compatible with a mod command
public class LSDRadixSort<T extends Comparable<T>> extends Sorter<T> {
	private int elementMaxLength;
	public LSDRadixSort(T[] elements, int elementMaxLength, FileWriter outputFile) throws IOException {
		super(elements, outputFile);
		this.elementMaxLength = elementMaxLength;
	}
	
//	Performs LSDRadixSort
//	Digitwise version
// 	assume all values are x digit ints
	public T[] sort(Comparator<T> comparator) throws IOException {
		// instantiate bins
		ArrayList<ArrayList<Integer>> bin1 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> bin2 = new ArrayList<ArrayList<Integer>>();

		// instantiate both bins
		for(int i = 0; i < 10; i++){
			bin1.add(new ArrayList<Integer>());
			bin2.add(new ArrayList<Integer>());
		}

		// insert values into bin1
		for(T elem : this.elements){
			// select slot in bin to add to
			int slotIndex = (Integer) elem % 10;
			bin1.get(slotIndex).add((Integer)elem);
		}
		// create additional pointers to determine which bin is active and which is inactive
		ArrayList<ArrayList<Integer>> activeBin = bin1;
		ArrayList<ArrayList<Integer>> inactiveBin = bin2;

		
		// iterate through all remaining digits in elements
		for(int digit = 1; digit < this.elementMaxLength; digit++){
			// iterate through slots in active bin
			for(ArrayList<Integer> slot : activeBin){
				// iterate through each Integer in current slot
				for(Integer elem : slot){
					// calculate index for inserting into inactive bin
					// decimal shift left by dividing by 10 to power of the current digit, mod by 10
					int index = (elem / ((int)Math.pow(10, digit))) % 10;
					// insert element to end of correct slot in inactive bin
					inactiveBin.get(index).add(elem);
				}
			}
			// clear slots in active bin
			for(ArrayList<Integer> slot : activeBin){
				slot.clear();
			}
			// swap active and inactive bin pointers
			ArrayList<ArrayList<Integer>> tempBin = activeBin;
			activeBin = inactiveBin;
			inactiveBin = tempBin;
		}
		// at this point inactiveBin holds the elements in sorted order
		// create variable to hold current index in array
		int i = 0;
		// for each slot in active bin
		Integer[] retElements = new Integer[this.elements.length];
		for(ArrayList<Integer> slot : activeBin){
		// for each element in current slot
			for(Integer elem : slot){
				// add current element to final array
				retElements[i] = elem;
				// increment index counter
				i++;
			}
		}
		
//		write sorted array to output file
		this.outputFile.write("Sorted: ");
		for(Integer currentInt : retElements) {
			this.outputFile.write(currentInt + " ");
		}


		return (T[]) retElements;
	}

}
