import java.util.ArrayList;
import java.util.Scanner;


public class Srt {

	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		n = s.nextInt();
		int[] b = new int[n];
		ArrayList<Process> list = new ArrayList<>();
		for (int i=0; i<n;i++){
			int pid = s.nextInt();
			int bt = s.nextInt();
			b[i] = bt;
			list.add(new Process(pid, bt));
		}
		int i = 0, end;
		float avg = 0, tt = 0;
		boolean Flag = true;
		int smallbt = 999;
		int pid = 0;
		while(Flag){
			for (int j=0; j< n;j++){
				if(list.get(j).bt < smallbt && list.get(j).bt > 0 && list.get(j).at <= i ){
					smallbt = list.get(j).bt;
					pid = j;
				}
			}
			if(list.get(pid).bt != 0 && smallbt != 999){
			System.out.println("Process Executed is " + (pid+1));
			list.get(pid).bt -= 1;
				if(list.get(pid).bt == 0){
					end = i+1;
					avg += end - list.get(pid).at - b[pid];
					tt += end - list.get(pid).at;
				}
			i++;
			smallbt = 999;
			}
			else{
				Flag = false;
			}
		
		}
		System.out.println("Average time: " + (avg/n));
		System.out.println("TT is: " + (tt/n));

		s.close();
		
	}


}

//0 10 0 1 3 2 5 1 10 4