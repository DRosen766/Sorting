import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SortingDriver {
	public interface arrayInstantiator<T>{
		public T[] instantiateArray(T[] arr);
	}
	public static void main(String[] args) throws IOException {
//		instantiate output file
		FileWriter outputFile = new FileWriter("output.txt");
//		comparators
		AscendingComparator<Integer> ascendingComparator = new AscendingComparator<>();
//		size of list
		int listSize = 20;
//		max value of integer
		int maxValue = 200;
		
//		define arrMake lambda function
		arrayInstantiator<Integer> arrMake  = (Integer[] arr) -> {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * maxValue);
			}
			return arr;
		}; 
		
		
		
//		create a list of random integers using, lambda function
//		create new sorter object
//		sort list of integers
//		assign sorted list to insertionSortedInts
		outputFile.write("Insertion sort\n");
		Integer[] insertionSortedInts = new InsertionSort<Integer>(arrMake.instantiateArray(new Integer[listSize]), outputFile).sort(ascendingComparator);
		outputFile.write("\n\n");
		
		
//		create a list of random integers using, lambda function
//		create new sorter object
//		sort list of integers
//		assign sorted list to lsdRadixSortedInts
		outputFile.write("LSD Radix sort\n");
		Integer[] lsdRadixSortedInts = new LSDRadixSort<Integer>(arrMake.instantiateArray(new Integer[listSize]), 3, outputFile).sort(ascendingComparator);
		outputFile.write("\n\n");

		

//		close output file
		 outputFile.close();
	}

}
