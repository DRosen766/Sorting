import java.util.Comparator;

public class LSDRadixSort<T extends Comparable<T>> extends Sorter<T> {

	public LSDRadixSort(T[] elements) {
		super(elements);
	}
	
//	Performs LSDRadixSort
	public T[] sort(Comparator<T> comparator) {
		return this.elements;
	}

}
