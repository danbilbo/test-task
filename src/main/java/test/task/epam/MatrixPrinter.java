package test.task.epam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class {@link Runner}
 *
 * @author Daniil Selivanov
 * @version 1.0
 * @since 3/19/15
 */
public class MatrixPrinter {

    public static final String FILE_NAME = "matrix.txt";

    public void printBody(Matrix matrix) throws IOException {
        printBody(matrix, FILE_NAME);
    }

    public void printBody(Matrix matrix, String fileName) throws IOException {
        new File(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        fileOutputStream.write(matrix.bodyToString().getBytes());
        fileOutputStream.close();
    }

}
