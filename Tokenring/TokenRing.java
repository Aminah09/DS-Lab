import java.util.*;

public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes you want in ring: ");
        int n = sc.nextInt();

        System.out.println("Ring formed is as below: ");
        for(int i=0; i<n; i++){
            System.out.print(i + " ");
        }
        System.out.println("0");
        // if n=5
        // ring will be 0 1 2 3 4 0

        int choice = 0;
        do{
            System.out.print("Enter Sender: ");
            int sender = sc.nextInt();

            System.out.print("Enter Receiver: ");
            int receiver = sc.nextInt();

            System.out.print("Enter data to send: ");
            int data = sc.nextInt();

            int token = 0;

            System.out.println("Token passing: ");

            for(int i=token; i<sender; i++){
                System.out.print(" " + i + "->");
            }
            System.out.println(" " + sender);
            System.out.println("Sender: " + sender + " sending data: " + data);

            for(int i=sender; i!=receiver; i=(i+1)){
                System.out.println("Data: " + data + " forwarded by: " + i);
            }

            System.out.println("Receiver: " + receiver + " received data: " + data);
            System.out.print("Do you want to send data again ? If yes enter 1 if no enter 0 ");

            choice = sc.nextInt();

        } while(choice == 1);

    }
}

/*
* Enter number of nodes you want in ring: 10
Ring formed is as below:
0 1 2 3 4 5 6 7 8 9 0
Enter Sender: 3
Enter Receiver: 9
Enter data to send: 20
Token passing:
 0-> 1-> 2-> 3
Sender: 3 sending data: 20
Data: 20 forwarded by: 3
Data: 20 forwarded by: 4
Data: 20 forwarded by: 5
Data: 20 forwarded by: 6
Data: 20 forwarded by: 7
Data: 20 forwarded by: 8
Receiver: 9 received data: 20
Do you want to send data again ? If yes enter 1 if no enter 0 0

Process finished with exit code 0
*/