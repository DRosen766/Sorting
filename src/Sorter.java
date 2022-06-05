import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

// superclass for all sorting algorithms
public class Sorter<T extends Comparable<T>> {
//	array of elements
	public T[] elements;
//	output file
	public FileWriter outputFile;
//	constructor
	public Sorter(T[] elements, FileWriter outputFile) throws IOException {
		this.elements = elements;
		this.outputFile = outputFile;
//		write unsorted elements to output file
		outputFile.write("Unsorted Set: ");
		for(T i : elements) {
			outputFile.write(i + " ");
		}
		outputFile.write("\n");
	}
	
//	basic sort function
//	will be overridden by subclasses
	public T[] sort(Comparator<T> comparator) throws IOException {
//		returns unsorted array
		return this.elements;
	}
	
}
