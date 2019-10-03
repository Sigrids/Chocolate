
public class chocolate {

	public static void main(String[] args) {
		
		int[][] choc = new int[][]{
			{6, 8, 9, 7, 4},
			{0, 0, 8, 0, 5},
			{5, 7, 4, 5, 10},
			{4, 2, 0, 6, 9},
		};
		
		int num=numChoc(choc);
		System.out.println(num);
	}
	
	public static int numChoc(int[][] arr){
		int row = 1;
		int col = 2;
		int start = arr[1][2];
		int total = start;
		boolean bool = true;
		
		while (bool == true) {
			int big = 0;
			int[] numbers = new int[4];
			int a=0, b=0, c=0, d=0;
			    
			if(row > 0){  // check up
				if(arr[row-1][col] > 0){ 
					a = arr[row-1][col]; 
				} 
			} 
			
			if(col <= (arr.length-1)){    	//check right 
				if(arr[row][col+1] > 0){ 
					b = arr[row][col+1]; 
				} 
			} 
			
			if(col > 0){   	//check left 
				if(arr[row][col-1] > 0){ 
					c = arr[row][col-1]; 
				} 
			} 

			if(row <= arr[0].length-1){ 		//check down 
				if(arr[row+1][col] > 0){ 
					d = arr[row+1][col]; 
				} 
			} 

			// sets numbers to array
			numbers[0] = a;
			numbers[1] = b;
			numbers[2] = c;
			numbers[3] = d;
			big = findLargest(numbers);
			total += big;
			
			if (big == 0){
				bool = false;
			}
	    
			if(a == big && big != 0) {  // changes spot to 0 then goes up
				arr[row][col] = 0;
				row = row -1;
			}
			
			if(b == big && big != 0) { // same above then right
				arr[row][col] = 0;
				col = col + 1;  
			}
			
			if(c == big && big != 0) { // same above then left
				arr[row][col] = 0;
				col = col - 1;
			}
			
			if(d == big && big != 0) {  // same above then down
				arr[row][col] = 0;
				row = row + 1;
			}	
		}
		
		return total;
	}
		
	public static int findLargest(int[] numbers){  
	    int largest = numbers[0];  
	     for(int i = 1; i < numbers.length; i++){  
	        if(numbers[i] > largest){  
	            largest = numbers[i];  
	            }    
	    }  
	    return largest;
	
	}
}
