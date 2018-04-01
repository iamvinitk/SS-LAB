
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
//        list2.add(list.get(0));
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
        System.out.println("TT Avg" + (tt/5));
        System.out.println("WT Avg" + (avg/5));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).at);
//        }

        s.close();

    }

//0 10 0 1 3 2 5 1 10 4

}
