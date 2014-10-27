import java.util.Random;


public class MainClass {
 
	static int [] sayilar;
	
	//30,100,1000,10000,50000,100000
	public static void main(String[] args) {
		
	 	 
		System.out.println("sayý : 1000");
		sayilar = creativeNumber(1000);  // random sayý üretme
		
		// bubble sort
		long startTime = System.nanoTime();
		bubbleSort(sayilar);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime); 
		System.out.println("Booble sort time: "+duration);
		
		// Selection sort
		long startTime1 = System.nanoTime();
		selectionSort(sayilar,1000);
		long endTime1 = System.nanoTime();
		long duration1 = (endTime1 - startTime1);
		System.out.println("selection sort time: "+duration1);
		// insertion sort
		long startTime2 = System.nanoTime();
		insertionSort(sayilar,1000);
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		System.out.println("insertion sort time: "+duration2);
		
		
		
		long startTime3 = System.nanoTime();
		mergeSort(sayilar,0,999);
		long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3);
		System.out.println("merge sort time: "+duration3);
		
		
		System.out.println("--");
		long startTime5 = System.nanoTime();
		quickSort(sayilar,0,999);
		long endTime5 = System.nanoTime();
		long duration5 = (endTime5 - startTime5);
		System.out.println("quick sort time: "+duration5);
		System.out.println("finish");
	}

	
	static int[] creativeNumber(int a){
		 Random rnd = new Random();
		 int []sayi=new int[a];
		 
		 for(int i=0; i<a; i++){
			 sayi[i] = rnd.nextInt(100);
			// System.out.println("sayi: "+sayi[i]);
		 }
			return sayi ; 
	}
	
	static void bubbleSort(int []array){
		int [] sortArray;
		int temp;
		sortArray=array;
		
		for (int i = 1; i < sortArray.length; i++) {
		     for (int j = 0; j < sortArray.length - i; j++)
		    {
		         if(sortArray[j] > sortArray[j+1])
		        {
		             temp = sortArray[j+1];
		             sortArray[j+1] = sortArray[j];
		             sortArray[j] = temp;
		         }
		     }
		}
		
	 
	}
	
	public static void selectionSort(int array[], int n){
		  
		for(int x=0; x<n; x++){
			  int index_of_min = x;
			  
			  for(int y=x; y<n; y++){
				  if(array[index_of_min]<array[y]){
					  index_of_min = y;
				  }
			  }
		    int temp = array[x];
		    array[x] = array[index_of_min];
		    array[index_of_min] = temp;
		  }  
//		for(int x=0; x<array.length; x++){
//			System.out.println("sa "+array[x]);
//		}
	}
	 
	public static void insertionSort(int array[], int n){
		  
		for (int i = 1; i < n; i++){
			  int j = i;
			  int B = array[i];
			 
			  while ((j > 0) && (array[j-1] > B)){
				  
				  array[j] = array[j-1];
				  j--;
			  }
			  array[j] = B;
		  	}
	 }
	
	public static void mergeSort(int array[],int lo, int n){
		  int low = lo;
		  int high = n;
		  if (low >= high) {
		  return;
		  }

		  int middle = (low + high) / 2;
		  mergeSort(array, low, middle);
		  mergeSort(array, middle + 1, high);
		  int end_low = middle;
		  int start_high = middle + 1;
		 
		  while ((lo <= end_low) && (start_high <= high)) {
			  if (array[low] < array[start_high]) {
				  low++;
			  } 
			  else {
				  int Temp = array[start_high];
				  for (int k = start_high- 1; k >= low; k--) {
					  array[k+1] = array[k];
				  }
				  array[low] = Temp;
				  low++;
				  end_low++;
				  start_high++;
			  }
		  	}
		  }  
	
 
		 
	 public static void quickSort(int array[],int low, int n){
		  int lo = low;
		  int hi = n;
		  if (lo >= n) {
		  return;
		  }
		  int mid = array[(lo + hi) / 2];
		  while (lo < hi) {
		  while (lo<hi && array[lo] < mid) {
		  lo++;
		  }
		  while (lo<hi && array[hi] > mid) {
		  hi--;
		  }
		  if (lo < hi) {
		  int T = array[lo];
		  array[lo] = array[hi];
		  array[hi] = T;
		  }
		  }
		  if (hi < lo) {
		  int T = hi;
		  hi = lo;
		  lo = T;
		  }
		  quickSort(array, low, lo);
		  quickSort(array, lo == low ? lo+1 : lo, n);
		  }
}
