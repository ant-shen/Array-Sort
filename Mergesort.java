import java.time.Duration;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//algorithihm 1

public class Mergesort {
	public static int getK(int[] arr, int k) {
		
		mergeSort(arr, 0, arr.length - 1);
        if (k < 1 || k > arr.length) {
    		throw new IllegalArgumentException("Invalid value of k");
    	}
        
        return arr[k - 1];
        
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
    	long milliStartTime = System.currentTimeMillis();
    	Random r = new Random();
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter the size of the array: ");
    	int size = scanner.nextInt();
    	
    	int arr[] = new int[size];
    	for (int i =0; i< size; i++) {
    		arr[i] = r.nextInt(11);
    	}
    	//System.out.println(Arrays.toString(arr));
    	
    	System.out.println("Please enter a value of k: ");
    	
    	int k = scanner.nextInt();
    	
    	int result = getK(arr, k);
    	long milliEndTime = System.currentTimeMillis();
        long duration = (milliEndTime - milliStartTime); 
        System.out.println("Time: " + duration + " milliseconds" );
    	
        System.out.println("Result: " + result + " , sorted input array: " + Arrays.toString(arr));
    	
        //currentTimeMillis
       
 
    }

}
