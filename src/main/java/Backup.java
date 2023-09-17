import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Backup {

    public static void main(String[] args) throws Exception {
        final String dirSource = ".";
        final String dirTarget = "./backup";

        backup(dirSource, dirTarget);

    }

    public static void copyFile(File fileSource, String fileTarget) throws IOException {
        int data;
        try (FileOutputStream fos = new FileOutputStream(fileTarget)) {
            try (FileInputStream fis = new FileInputStream(fileSource)) {
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                }
            }
        }
    }

    public static void backup(String dirSource, String dirTarget) throws Exception {

        File sourceFolder = new File(dirSource);
        File backupDir = new File(dirTarget);

        boolean created = backupDir.mkdir();
        if (created) {
            System.out.println("Directory's been created");
        } else {
            System.out.println("No directory's been created!");
        }
        File[] dirSourceContents = sourceFolder.listFiles();
        if (dirSourceContents != null) {
            for (File item : dirSourceContents) {
                if (item.isFile()) {
                    copyFile(item, dirTarget + "/" + item.getName());
                }
            }
        }
    }
}


