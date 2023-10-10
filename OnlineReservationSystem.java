import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservationSystem {
    private Map<String, String> users; // Store username-password pairs
    private Map<String, String> reservations; // Store reservation data
    
    public OnlineReservationSystem() {
        users = new HashMap<>();
        reservations = new HashMap<>();
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("----- WELCOME TO ONLINE RESERVATION SYSTEM -----");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select One Options..." + "\n");
            System.out.println("1.>>> Register >>>");
            System.out.println("2.>>> Login >>>");
            System.out.println("3.>>> Exit >>>");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    register(sc);
                    break;
                case 2:
                    login(sc);
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Exiting...");
                    System.out.println("\n" + "------------------------------------------------");
                    System.out.println("\n" + "Thank You.!!! Please Visit Again...");
                    System.out.println("\n" + "------------------------------------------------");
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Invalid choice... Please Try again...");
                    break;
            }
            
            System.out.println();
        }
    }
    
    private void register(Scanner sc) {
        System.out.println("------------------------------------------------");
        System.out.println("--------------- REGISTRATION PAGE --------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("\n" + "Username already exists... Try again...");
            return;
        }
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users.put(username, password);
        System.out.println("\n" + "Registration successful... You can now log in...");
    }
    
    private void login(Scanner sc) {
        System.out.println("------------------------------------------------");
        System.out.println("------------------ LOGIN PAGE ------------------");
        System.out.println("------------------------------------------------");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("\n" + "Login successful...");
            reservationMenu(sc, username);
        } else {
            System.out.println("\n" + "Invalid username or password...");
        }
    }
    
    private void reservationMenu(Scanner sc, String username) {
        while (true) {
            System.out.println("------------------------------------------------");
            System.out.println("------------------- HOME PAGE ------------------");
            System.out.println("------------------------------------------------");
            System.out.println("Please Select One Options..." + "\n");
            System.out.println("1.>>> Make a reservation >>>");
            System.out.println("2.>>> Cancel a reservation >>>");
            System.out.println("3.>>> Logout");
            System.out.println("------------------------------------------------");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    makeReservation(sc, username);
                    break;
                case 2:
                    cancelReservation(sc, username);
                    break;
                case 3:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Logging out...");
                    return;
                default:
                    System.out.println("------------------------------------------------");
                    System.out.println("\n" + "Invalid choice. Try again.");
                    break;
            }
            
            System.out.println();
        }
    }
    
    private void makeReservation(Scanner sc, String username) {
        System.out.println("------------------------------------------------");
        System.out.print("Enter reservation details: ");
        String reservationDetails = sc.nextLine();
        
        if (reservations.containsKey(username)) {
            System.out.println("\n" + "You already have a reservation. Cancel it first to make a new one...");
            return;
        }
        
        reservations.put(username, reservationDetails);
        System.out.println("\n" + "Reservation created successfully...");
    }
    
    private void cancelReservation(Scanner sc, String username) {
        if (reservations.containsKey(username)) {
            System.out.println("------------------------------------------------");
            System.out.println("Your current reservation: " + reservations.get(username));
            System.out.print("Do you want to cancel this reservation? (Y/N): ");
            String confirmation = sc.nextLine();
            
            if (confirmation.equalsIgnoreCase("Y")) {
                reservations.remove(username);
                System.out.println("\n" + "Reservation cancelled successfully...");
            } else {
                System.out.println("\n" + "Reservation not cancelled...");
            }
        } else {
            System.out.println("\n" + "You don't have any reservations...");
        }
    }
    
    public static void main(String[] args) {
        OnlineReservationSystem system = new OnlineReservationSystem();
        system.run();
    }
}