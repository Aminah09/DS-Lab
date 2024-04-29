import java.util.Scanner;
public class Bully {

    static boolean[] state = new boolean[5];
    public static int coordinator = 4;

    public static void getStatus() {
        System.out.println("\n+------Current System Status------+");
        for (int i =0; i<state.length; i++) {
            System.out.println("| P" + (i+1) + ":\t " + (state[i] ? "Active" : "Inactive") +
             (coordinator == i ? "\t<-- Coordinator" :""));
        }
        System.out.println("+---------------------------------+");
    }

    public static void active(int active) {
        if (state[active - 1]) {
            System.out.println("Process " + active + " is already active.");
        } else {
            state[active - 1] = true;
            System.out.println("--------Process " + active + " held election.--------");
            for (int i = active; i < state.length; ++i) {
                    System.out.println("Election message sent from Process " + active + " to process " + (i + 1));
                }
                for (int i = state.length - 1; i >= 0; --i) {
                    if (state[i]) {
        
                        coordinator = i;
                        break;
                    }
                }
            }
        }

    public static void inactive(int inactive) {
        if (!state[inactive - 1]) {
            System.out.println("Process " + inactive + " is already inactive.");
        } else {
            state[inactive - 1] = false;
            if (coordinator == inactive - 1) {
                setCoodinator();
                
            }
        }
    }

    public static void message(int message) {
        if (state[message - 1]) {
            if (state[coordinator]) {
                System.out.println("Message Sent: Coordinator is Alive.");
            
        } else {
            System.out.println("Coordinator is dead.");
            System.out.println("Process " + message + " initiated election");
            for (int i = message; i < state.length; ++i) {
                
                    System.out.println("Election message sent from Process " + message + " to process " + (i + 1));
    
            }
            setCoodinator();
        }
    } else {
        System.out.println("Process " + message + " is inactive.");
    }
    }

    public static void setCoodinator() {
        for (int i = state.length - 1; i >= 0; --i) {
            if (state[i]) {
                coordinator = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
    
        int choice;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < state.length; i++) {
            state[i] = true;
        }
        getStatus();
        do {
            System.out.println("+----------MENU----------+");
            System.out.println("| 1. Activate Process    |");
            System.out.println("| 2. Inactivate Process  |");
            System.out.println("| 3. Send Message        |");
            
            System.out.println("| 4. Exit                |");
            System.out.println("+------------------------+");

            choice = sc.nextInt();
        
            switch (choice) {
                case 1: {
                    System.out.print("Activate Process: ");
                    int active = sc.nextInt();
                    if (active == 5) {
                        System.out.println("Process 5 is the coordinator.");
                        state[4] = true;
                        coordinator = 4;
                        break;
                    }
                    active(active);
                    break;
                }
                case 2: {
                    System.out.print("Inactivate Process: ");
                    int inactive = sc.nextInt();
                    inactive(inactive);
                    break;
                }
                case 3: {
                    System.out.print("Send Message from process: ");
                    int message = sc.nextInt();
                    message(message);
                    break;
                }
                case 4: {
                    System.out.println("Exiting...");
                    break;
                }
            }
            getStatus();
        } while (choice != 4);
        sc.close();
    }

}
    

