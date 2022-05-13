import java.util.Comparator;

// superclass for all sorting algorithms
public class Sorter<T extends Comparable<T>> {
//	array of elements
	public T[] elements;

//	constructor
	public Sorter(T[] elements) {
		this.elements = elements;
	}
	
//	basic sort function
//	will be overridden by subclasses
	public T[] sort(Comparator<T> comparator) {
//		returns unsorted array
		return this.elements;
	}
	
}
