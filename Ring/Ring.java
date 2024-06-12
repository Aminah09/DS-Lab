import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        Rr[] process = new Rr[n];

        for (int i = 0; i < n; i++) {
            process[i] = new Rr();
            process[i].index = i;
            System.out.print("Enter ID of process " + (i + 1 ) + ":");
            process[i].id = sc.nextInt();
            process[i].state = "active";
            process[i].f = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (process[j].id > process[j + 1].id){
                    Rr temp = process[j];
                    process[j] = process[j + 1];
                    process[j + 1] = temp;
                }
                
            }
           
        }

        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            System.out.print("[" + i +"]" + process[i].id + " ");
            

        }

        process[n - 1].state = "inactive";
        System.out.print("\n");
        System.out.println("\nProcess " + process[n - 1].id + " selected as coordinator");

        while (true) {
            System.out.println("\n1. Election\n2. Exit");
            int choice = sc.nextInt();

            for (int i = 0; i < n; i++) {
                process[i].f = 0;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the process number that initializes the election: ");
                    int p = sc.nextInt();
                    int temp2 = p;
                    int temp1 = p + 1;
                    int i = 0;

                    while (temp2 != temp1) {
                        if (temp1 == n) {
                            temp1 = 0;
                        
                        }
                        if ("active".equals(process[temp1].state) && process[temp1].f == 0) {
                            
                            System.out.println("Process " + process[p].id + " sends message to process " + process[temp1].id);

                            process[temp1].f = 1;
                            p = temp1;
                            i++;
                        }
                        temp1++;
                    }

                    System.out.println("Process " + process[p].id + " sends message to process " + process[temp1].id);
                    int max = -1;

                    for (int j = 0; j < i; j++) {
                        if (max < process[j].id) {
                            max = process[j].id;
                        }
                    }
                    
                    System.out.println("Process " + max + " selected as coordinator");
                    for (int k = 0; k < n; k++) {
                        if (process[k].id == max) {
                            process[k].state = "inactive";
                        }
                    }
                    break;
                case 2:
                System.out.println("Exiting...");
                sc.close();
                return;

                default:
                System.out.println("Invalid choice");
                    break;
            }
            
        }
    }
}

class Rr {
    public int index;
    public int id;
    public int f;
    public String state;
}
