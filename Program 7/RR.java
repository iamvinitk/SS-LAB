
import java.util.ArrayList;
import java.util.Scanner;


public class RR {

    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        n = s.nextInt();
        ArrayList<Process> list = new ArrayList<>();
        ArrayList<Process> list2 = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int at = s.nextInt();
            int bt = s.nextInt();
            sum += bt;
            list.add(new Process(at, bt, i + 1));
        }
        int time = 0;
        float end = 0, avg = 0, tt = 0;
        while (time < sum) {
            boolean flag = false;
            int at = 0, bt = 0, index = 0, currtime = 0;
            if (list2.size() > 0) {
                Process p = list2.get(0);
                if (p.bt > 1) {
                    System.out.print("Time taken:" + time + "-" + (time + 2));
                    bt = p.bt - 2;
                    at = p.at;
                    index = p.index;
                    currtime = 2;
                    flag = true;
                } else {
                    System.out.print("Time taken:" + time + "-" + (time + 1));
                    bt = p.bt - 1;
                    at = p.at;
                    index = p.index;
                    currtime = 1;
                    flag = true;
                }
                System.out.println("Process : " + p.index);
                list2.remove(0);
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).at == (time + currtime)) {
                    list2.add(list.get(i));
                    System.out.println("Process Added is " + list.get(i).index + " at " + (time + currtime));
                }
            }
            if (flag) {
                if (bt > 0)
                    list2.add(new Process(at, bt, index));
                else {
                    System.out.println("Processed Ended " + index);
                    end = time + currtime;
                    System.out.println("End time is" + end + "for" + index);
                    avg += end - list.get(index - 1).at - list.get(index - 1).bt;
                    tt += end - list.get(index - 1).at;
                }
            }
            time += currtime;
        }
        System.out.println("TT Avg" + (tt / 5));
        System.out.println("WT Avg" + (avg / 5));
        s.close();

    }
}
//0 10 0 1 3 2 5 1 10 4
/* Output
Enter the number of processes
5
0 10 0 1 3 2 5 1 10 4
Process Added is 1 at 0
Process Added is 2 at 0
Time taken:0-2Process : 1
Time taken:2-3Process : 2
Process Added is 3 at 3
Processed Ended 2
End time is3.0for2
Time taken:3-5Process : 1
Process Added is 4 at 5
Time taken:5-7Process : 3
Processed Ended 3
End time is7.0for3
Time taken:7-8Process : 4
Processed Ended 4
End time is8.0for4
Time taken:8-10Process : 1
Process Added is 5 at 10
Time taken:10-12Process : 5
Time taken:12-14Process : 1
Time taken:14-16Process : 5
Processed Ended 5
End time is16.0for5
Time taken:16-18Process : 1
Processed Ended 1
End time is18.0for1
TT Avg 6.8
WT Avg 3.2

*/
