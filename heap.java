/*
 * 
 * 
 NAME:           SHARVARI SONKUSARE
 CNUM:           C22019221458
 ASSIGNMENT:     5
 ROLL NO.:       2459
 
 
 PROBLEM STATEMENT: Perform following operation on Min heap or Max Heap
1. Insert an element
2. Delete an element from heap
3. Build Heap
4. Delete Heap
Extra- Heap sort
 
 
 */

package heap;
import java.util.*;
import java.lang.Math;



class heap1{        //heap stored in array
	Scanner sc=new Scanner(System.in);
	int h[]=new int[30];    //h[0]=total number of elements present, storing of array starts from h[1].
	int total=0,max_size;
	int n;
	
	public
	
	void createmax(){  // to insert element
		System.out.println("Enter the element to be inserted: ");
		int e=sc.nextInt();
		h[total+1]=e;
		total++;
		h[0]=total;
		int i=total;
		while(i!=1) {
			if(h[i/2]<h[i]) {
				int swap = h[i];
		        h[i] = h[i/2];
		        h[i/2] = swap;
		        i=i/2;
			}
			else {
				i=i/2;
				return;
			}
		}
		
	}
		
	     //n= current size of heap, i= current index
	void heapify(int arr[], int n, int i) {
			      
			   // Find largest among root, left child and right child
			      int largest = i;
			      int l = 2 * i ;   // left = 2*i 
			      int r = 2 * i + 1;   // right = 2*i + 1
			  
			      if (l < n && arr[l] > arr[largest])  
			    	// If left child is larger than root
			        largest = l;
			  
			      if (r < n && arr[r] > arr[largest])
			    	// If right child is larger than root
			        largest = r;
			  
			      // Swap and continue heapifying if root is not largest
			      if (largest != i) {
			        int swap = arr[i];
			        arr[i] = arr[largest];
			        arr[largest] = swap;
			  
			        heapify(arr, n, largest);
			      }
			      }
		   
	void printArray(){        //display the heap
		int k= total;
		if(k!=0) {
		for (int i = 0; i <= total; ++i) {
			System.out.print(h[i] + " ");
		}
		System.out.println();
		k=k-1;
		}
		else {
			System.out.println("\nHEAP IS EMPTY!");
			}
		}
	
	void upadjmax(int i) {      //Up adjustment
		
		int parent=i/2;
		if(h[parent]< h[i]) {

		//Exchange h[i] and h[parent]
			int swap = h[parent];
	        h[parent] = h[i];
	        h[i] = swap;

		}
		i=i/2;
		upadjmax(i);		
	}
	
	
	void downadjmax(int i){    //down adjustment
		int parent = i;
		 int child = 2 * i ;   //left child 
		 if(child<=h.length) {
	        while (h[child] <h.length) {
	        	if (child + 1 < h.length && h[child + 1] > h[child]) {
	                child = child + 1;
	            }
	        	
	        	  if (h[child] > h[parent]) {
	                  int tmp = h[child];
	                  h[child] = h[parent];
	                  h[parent] = tmp;
	              }
	        	  else {
	                  break;
	              }
	        	  
	        	  parent = child;
	              child = 2 * parent;
	        }
		 }
		 
	}
	
	void buildHeap() {              //build heap using bottom up approach i.e. using down adjustment
		System.out.println("Enter total number of elements: ");
		int n= sc.nextInt();
		System.out.println("Enter the elements: ");
		for(int i=1;i<=n;i++) {
			h[i]=sc.nextInt();
			total++;
		}
		h[0]=n;
		
		for(int j=n/2;j>=1;j--) {
			downadjmax(j);
		}	
	}
	
    //for max heap
	void findMinMax_MaxHeap(){
    	        int minimumElement = h[1];    //just for starting comparison
    	        int n=h.length;
    	 
    	        for (int i = 1; i <= total; ++i)
    	            minimumElement= Math.min(minimumElement, h[i]);
    	 
    	        System.out.println("The minimum element in max heap is: "+ minimumElement);
    	        System.out.println("The maximum element in max heap is: "+ h[1]);   
    	        }
    	 
    	 //for min heap
	void findMinMax_MinHeap() {
    		 
    		 int maximumElement = h[1];
    		 int n=h.length;
    		 
    	        for (int i = 1; i <= total; ++i) {
    	            maximumElement = Math.max(maximumElement,h[i]);
    	        }
    	        System.out.println("The maximum element in max heap is: "+ maximumElement);
    	        System.out.println("The minimum element in max heap is: "+ h[1]);  
    	        }
    	  
	void deleteRoot(){
		int lastElement = h[total - 1];     // Get the last element
		System.out.println("The deleted element is: "+h[1]);
		h[1] = lastElement;             // Replace root with first element
        total=total-1;
        h[0]=total;
        heapify(h, total, 1);               // heapify the root node
      }
      
	
	
	void heapsort()
	    {
	        int n = total+1;
	 
	        // Build heap (rearrange array)
	        for (int i = (n/2) - 1; i > 0; i--)     
	            heapify(h, total, i);
	 
	        // One by one extract an element from heap
	        for (int i = n - 1; i >= 0; i--) {          
	            // Move current root to end
	            int temp = h[1];
	            h[1] = h[i];
	            h[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(h, i, 1);
	        }
	    }
		
		
		
	
     }

public class heap{

	public static void main(String []args) {
		heap1 hp=new heap1();
		Scanner s=new Scanner(System.in);
		int opt;
		
		do
		{
			System.out.println("\n----------------------------------------------------------------------------------------------\n");
		    System.out.println("MENU:\n1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit");
	        System.out.println("\n----------------------------------------------------------------------------------------------\n");
	        System.out.println("Enter your option :");

		    opt=s.nextInt();
				switch(opt)
				{
				case 1:
					hp.buildHeap();     //build heap using bottom up approach i.e. using down adjustment
					break;
				case 2:
					hp.printArray();
					//call hp.display();
					break;
				case 3:
					hp.createmax(); //createmax + heapify= insert but we need to call only createmax coz heapify is called inside createmax					
					break;
				case 4:
					hp.deleteRoot();
					break;
				case 5:
					hp.heapsort();
					break;
				case 6:
					int type;
					System.out.println("Enetr 1 for max heap and 0 for min heap");
					type=s.nextInt();
					if(type==1) {
						hp.findMinMax_MaxHeap();
					}
					else if(type==0) {
						hp.findMinMax_MinHeap();
					}
					else {
						System.out.println("INVALID CHOICE");
					}
				case 7:
					break;

					
				default: System.out.println("\nINVALID CHOICE");
				break;
					
				}                     
			
			}while(opt!=7);
	}

}


/*
 TIME COMPLEXITY:
 
1. Insert new element: O(log n)

2.Remove element : O(log n)

3.Find Min/max element: O(1)

4.Heap Sort: O(n log n)

5.Build Heap: O(n log n)

6. Display: O(n)


OUTPUT:



----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
1
Enter total number of elements: 
8
Enter the elements: 
30
25
20
10
15
6
8
4

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
8 30 25 20 10 15 6 8 4 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
3
Enter the element to be inserted: 
35

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
9 35 30 20 25 15 6 8 4 10 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
6
Enter 1 for max heap and 0 for min heap
1
The minimum element in max heap is: 4
The maximum element in max heap is: 35

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
5

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
4 9 6 8 10 15 20 25 30 35 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
3
Enter the element to be inserted: 
44

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
10 44 9 8 10 6 20 25 30 35 15 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
4
The deleted element is: 44

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
9 35 9 8 10 6 20 25 30 35 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
4
The deleted element is: 35

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
2
8 30 9 8 10 6 20 25 30 

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
6
Enter 1 for max heap and 0 for min heap
1
The minimum element in max heap is: 6
The maximum element in max heap is: 30

----------------------------------------------------------------------------------------------

MENU:
1)Create 2)Display  3)Insert  4)Delete  5)Sort 6)Min Max element  7)Exit

----------------------------------------------------------------------------------------------

Enter your option :
7


 	
 	
 	
 */




