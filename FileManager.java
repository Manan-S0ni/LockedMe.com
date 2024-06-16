import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileManager {

    private final String directoryPath;

    public FileManager(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void listFiles() {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }

        Arrays.sort(files, Comparator.comparing(File::getName));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public void addFile(String fileName) {
        File file = new File(directoryPath + File.separator + fileName);
        if (file.exists()) {
            System.out.println("File already exists.");
            return;
        }

        try {
            if (file.createNewFile()) {
                System.out.println("File added successfully.");
            } else {
                System.out.println("Failed to add the file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while adding the file.");
            e.printStackTrace();
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(directoryPath + File.separator + fileName);
        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public void searchFile(String fileName) {
        File file = new File(directoryPath + File.separator + fileName);
        if (file.exists()) {
            System.out.println("File found: " + fileName);
        } else {
            System.out.println("File not found.");
        }
    }
}
