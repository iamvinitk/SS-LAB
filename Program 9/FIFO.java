import java.util.ArrayList;
import java.util.Scanner;


public class FIFO {

	public static void main(String[] args) {
		int f,p,hc=0,fc=0;
		Scanner s = new Scanner(System.in);
		display("Enter the frame size");
		f = s.nextInt();
		display("Enter the number of pages");
		p = s.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		display("Enter the page array");
		int[] pageArray = new int[p];
		for (int i=0; i<p; i++){
			pageArray[i] = s.nextInt();
		}
		for (int i=0; i<f; i++){
			list.add(-1);
		}
		
		for (int i=0; i<p; i++){
			boolean flag = false;
			int current = pageArray[i];
			for(int j=0; j<f;j++){
				if(current == list.get(j)){
					flag = true;
				}
			}
			display("Frame contains:");
			for(int j=0; j<f;j++){
				System.out.println("\t" + list.get(j));
			}
			display("---------------");
			if(flag){
				hc+=1;
			}
			else{
				fc += 1;
				list.remove(0);
				list.add(current);
			}
		}
		
		display("Frame contains:");
		for(int j=0; j<f;j++){
			System.out.println("\t" + list.get(j));
		}
		display("---------------");
		
		display("Hit Count: "+hc);
		display("Fault Count: "+fc);
		s.close();
	}
	
	public static void display(Object s){
		System.out.println(s);
	}
}
/**
 * 
 * 
Enter the frame size
3
Enter the number of pages
13
Enter the page array
5 4 3 2 1 4 3 5 4 3 2 1 5
Frame contains:
	-1
	-1
	-1
---------------
Frame contains:
	-1
	-1
	5
---------------
Frame contains:
	-1
	5
	4
---------------
Frame contains:
	5
	4
	3
---------------
Frame contains:
	4
	3
	2
---------------
Frame contains:
	3
	2
	1
---------------
Frame contains:
	2
	1
	4
---------------
Frame contains:
	1
	4
	3
---------------
Frame contains:
	4
	3
	5
---------------
Frame contains:
	4
	3
	5
---------------
Frame contains:
	4
	3
	5
---------------
Frame contains:
	3
	5
	2
---------------
Frame contains:
	5
	2
	1
---------------
Frame contains:
	5
	2
	1
---------------
Hit Count: 3
Fault Count: 10
*/
