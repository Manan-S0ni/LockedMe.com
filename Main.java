import java.util.Scanner;

public class Main {

    private static FileManager fileManager = new FileManager("/Users/manan/ProlimProjects/LockedMe.com");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Welcome to LockedMe.com");
            System.out.println("Developer: Manan Soni");
            System.out.println("1. List files in ascending order");
            System.out.println("2. Add a file");
            System.out.println("3. Delete a file");
            System.out.println("4. Search for a file");
            System.out.println("5. Exit");

            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choice) {
                case 1:
                    fileManager.listFiles();
                    break;
                case 2:
                    System.out.print("Enter the name of the file to add: ");
                    String addFileName = scanner.nextLine();
                    fileManager.addFile(addFileName);
                    break;
                case 3:
                    System.out.print("Enter the name of the file to delete: ");
                    String deleteFileName = scanner.nextLine();
                    fileManager.deleteFile(deleteFileName);
                    break;
                case 4:
                    System.out.print("Enter the name of the file to search: ");
                    String searchFileName = scanner.nextLine();
                    fileManager.searchFile(searchFileName);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}