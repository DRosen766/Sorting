import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T>{
	public InsertionSort(T[] elements) {
		super(elements);
	}
//	basic insertionSort function
//	returns sorted list
	public T[] sort(Comparator<T> comparator) {
//		first element considered initally sorted portion
//		for each unsorted element in array
		for(int currentIndex = 1; currentIndex < this.elements.length; currentIndex++) {
//			assign variable to hold current moving element
			T currentElement = this.elements[currentIndex];
			
//			probe sorted section to determine correct location or current element
			int probeIndex = currentIndex;
			while(probeIndex > 0 && comparator.compare(currentElement, this.elements[probeIndex - 1]) < 0) {
//				shift up element in sorted section
				this.elements[probeIndex] = this.elements[probeIndex - 1];
//				move down probe index
				probeIndex--;
			}
			this.elements[probeIndex] = currentElement;
		}
		
		return this.elements;
	}
	
}
