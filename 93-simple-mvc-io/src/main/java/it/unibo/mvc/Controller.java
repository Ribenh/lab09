package it.unibo.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    public Controller() {
        final String userHome = System.getProperty("user.home");
        final String fileSeparator = System.getProperty("file.separator");
        final String defaultFilePath = userHome + fileSeparator + "output.txt";
        this.currentFile = new File(defaultFilePath);
    }

    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    public File getFile() {
        return currentFile;
    }

    public String getCurrentPath() {
        return currentFile.getPath();
    }

    public void inputString(final String string) throws IOException {
        try {
            final FileWriter writer = new FileWriter(currentFile);
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); // NOPMD
            System.out.println("No file is currently set"); // NOPMD
        }
    }
}
