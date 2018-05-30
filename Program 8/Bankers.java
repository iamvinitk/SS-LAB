import java.util.Scanner;


public class Bankers {

    private int n, m;
    private int[][] allocation, max, need;
    private int[] available, request;

    private void need() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
    }


    private void input() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of Processes");
        m = s.nextInt();
        System.out.println("Enter no. of Resources");
        n = s.nextInt();
        System.out.println("Enter Allocation Matrix");

        allocation = new int[m][n];
        max = new int[m][n];
        need = new int[m][n];
        available = new int[n];
        request = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                allocation[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter Max Matrix");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter Available Matrix");
        for (int j = 0; j < n; j++) {
            available[j] = s.nextInt();
        }
    }

    private boolean check(int p) {
        for (int i = 0; i < n; i++) {
            if (available[i] < need[p][i]) {
                return false;
            }
        }
        return true;
    }


    private void algorithm() {
        int c = 0;
        boolean status[] = new boolean[m];

        while (c < m) {
            boolean allocated = false;
            for (int i = 0; i < m; i++) {
                if (!status[i] && check(i)) {
                    status[i] = true;
                    allocated = true;
                    c++;
                    System.out.println("Allocated Process : " + i);
                    for (int j = 0; j < n; j++) {
                        available[j] = available[j] + allocation[i][j];
                    }
                }
            }
            if (!allocated) {
                break;
            }
        }
        if (c == m) {
            System.out.println("Safe");
        } else
            System.out.println("Not Safe");

    }


    private void resource(int pid) {
        int c = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" \t" + need[i][j]);
            }
            System.out.println(" \n");
        }


        for (int j = 0; j < n; j++) {
            if (request[j] > need[pid][j]) {
                System.out.print(request[j]);
                System.out.println(need[pid][j]);
                System.out.println("Error");
            } else if (request[j] > available[j]) {
                System.out.println("Must wait");
            } else {
                c++;
            }
        }


        if (c == n) {
            for (int l = 0; l < n; l++) {
                available[l] = available[l] - request[l];
                allocation[pid][l] = allocation[pid][l] + request[l];
                need[pid][l] = need[pid][l] - request[l];
            }
            System.out.println("Allocated");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(need[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Bankers b = new Bankers();
        b.input();
        b.need();
        b.algorithm();
        System.out.println("Enter pid\n");
        int pid = sc.nextInt();
        System.out.println("Enter request\n");

        for (int i = 0; i < 3; i++)
            b.request[i] = sc.nextInt();
        b.need();
        b.resource(pid);
//        b.algorithm();
    }
}
/*
Enter no. of Processes
5
Enter no. of Resources
3
Enter Allocation Matrix
0 0 2 1 0 0 1 3 5 6 3 2 1 4 3
Enter Max Matrix
0 0 4 2 0 1 1 3 7 8 4 2 1 5 7
Enter Available Matrix
1 0 2
Allocated Process : 0
Allocated Process : 1
Allocated Process : 2
Allocated Process : 3
Allocated Process : 4
Safe
Enter pid

2
Enter request

0 0 2
 	0 	0 	2

 	1 	0 	1

 	0 	0 	2

 	2 	1 	0

 	0 	1 	4

Allocated
0	0	2

1	0	1

0	0	0

2	1	0

0	1	4

Allocated Process : 0
Allocated Process : 1
Allocated Process : 2
Allocated Process : 3
Allocated Process : 4
Safe

 */
