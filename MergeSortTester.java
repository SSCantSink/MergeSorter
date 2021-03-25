
/**
 * This class tests Merge Sort on an array of integers.
 * @author Karanveer Sandhu
 */
public class MergeSortTester {
    
    /**
     * Merges two arrays that are already sorted so that we compare each value 
     * of each value in the array and put the smaller value into the returning
     * array. Then that returning array becomes sorted too.
     * @param leftSide the left "half" of the array.
     * @param rightSide the right "half" of the array.
     * @return the sorted, merged array.
     */
    public static int[] merge(int[] leftSide, int[] rightSide)
    {
        
        // Size of both arrays.
        int leftLength = leftSide.length;
        int rightLength = rightSide.length;
        
        // Indexes for this while loop
        int i = 0;  // index for left Array
        int j = 0;  // index for right Array.
        
        // array to be returned with both sides to be merged into it.
        int[] toReturn = new int[leftLength + rightLength];
        
        // Keep going until either the leftSide or rightSide runs out of values.
        while (i < leftLength && j < rightLength)
        {
            if (leftSide[i] < rightSide[j]) // left's value is smaller.
            {
                toReturn[i + j] = leftSide[i]; // put left's value in
                i++; // only increment leftside's index.
            }
            else // right's value is equal or bigger.
            {
                toReturn[i + j] = rightSide[j]; // put right's value in
                j++; // only uncrement rightside's index.
            }
        }
        
        // Either leftSide or rightSide has been completely iterated. Figure out
        // which one is it and deplete the rest of it into the merged array.
        if (j >= rightLength)
        {
            while (i < leftLength)
            {
                toReturn[i + j] = leftSide[i];
                i++;
            }
        }
        else
        {
            while (j < rightLength)
            {
                toReturn[i + j] = rightSide[j];
                j++;
            }
        }
        
        // Finally return the merged array.
        return toReturn;
    }
    
    /**
     * Sorts the inputted array using the merge sort algorithm:
     * Divide the array into half, merge sort both parts, then merge those two
     * sorted array into the bigger array using the merge() function described
     * above.
     * @param arr the array to be sorted using merge sort.
     * @param leftIndex the 
     * @param rightIndex
     * @return 
     */
    public static int[] mergeSort(int arr[], int leftIndex, int rightIndex)
    {
        // Array to be retured. Should be sorted in the end.
        int[] toReturn;
        
        // BASE CASE: if the array is empty or there is only one element.
        if ((arr.length <= 0) || (leftIndex >= rightIndex))
        {
            if (arr.length <= 0) // if array is empty
            {
                return arr; // return the "sorted" empty array
            }
            else // array has 1 value.
            {
                // return an array with that one value.
                int[] returning = new int[1];
                returning[0] = arr[leftIndex];
                return returning;
            }
        }
        else // array has 2 elements or more.
        {
            // middle of the array
            int midIndex = (leftIndex + rightIndex) / 2;
            
            // Mergesort the left half of the array.
            int[] leftSide = mergeSort(arr, leftIndex, midIndex);
            
            // Mergesort the right half of the array.
            int[] rightSide = mergeSort(arr, midIndex + 1, rightIndex);
            
            // Merge the two arrays together.
            toReturn = merge(leftSide, rightSide);
            
        }
        
        // Finally return the sorted array.
        return toReturn;
        
    }
    
    public static String printArray(int[] toPrint)
    {
        // Start with opening brackets.
        String toReturn = "[ ";
        
        // Go through every element but the last (since that will not be
        // followed by a comma).
        for (int i = 0; i < toPrint.length - 1; i++)
        {
            toReturn += toPrint[i] + ", ";
        }
        
        // If the array is not empty.
        if (toPrint.length > 0)
        {
            // Put that last element NOT followed by a comma
            toReturn += toPrint[toPrint.length - 1] + " ";
        }
        
        // end with closing brackets.
        toReturn += "]";
        
        // Return string.
        return toReturn;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] Alex = {1, 5, 4, 2, 11}; // array with odd # of elements.
        int[] Brittany = {}; // empty array.
        // array with even # of elements and duplicates.
        int[] Charlie = {-3, -12, -12, 5, 9, -8};
        int[] Debbie = {4}; // array with one element.
        
        // Original arrays
        System.out.println("Original Arrays:");
        System.out.println(printArray(Alex));
        System.out.println(printArray(Brittany));
        System.out.println(printArray(Charlie));
        System.out.println(printArray(Debbie));
        System.out.println();
        
        // Sorted arrays
        System.out.println("Sorted Arrays:");
        System.out.println(printArray(mergeSort(Alex, 0, Alex.length - 1)));
        System.out.println(printArray(mergeSort(Brittany, 0, 
                Brittany.length - 1)));
        System.out.println(printArray(mergeSort(Charlie, 0, 
                Charlie.length - 1)));
        System.out.println(printArray(mergeSort(Debbie, 0, Debbie.length - 1)));
        
    }
    
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~Thank you for grading my program.~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
