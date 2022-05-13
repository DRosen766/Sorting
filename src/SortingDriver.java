
public class SortingDriver {
	public interface arrayInstantiator<T>{
		public T[] instantiateArray(T[] arr);
	}
	public static void main(String[] args) {
//		comparators
		AscendingComparator<Integer> ascendingComparator = new AscendingComparator<>();
//		size of list
		int listSize = 20;
//		max value of integer
		int maxValue = 50;
		
//		define arrMake lambda function
		arrayInstantiator<Integer> arrMake  = (Integer[] arr) -> {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random() * maxValue);
			}
			return arr;
		}; 
		
//		create a list of random integers using, lambda function
//		create new insertion sort object
//		sort list of integers
//		assign sorted list to ints
		Integer[] ints = new InsertionSort<Integer>(arrMake.instantiateArray(new Integer[listSize])).sort(ascendingComparator);
		
//		print sorted list
		System.out.println("Sorted: ");
		for(int i = 0; i < ints.length; i++) {
			System.out.print(ints[i] + " ");
		}

		

		
	}

}
