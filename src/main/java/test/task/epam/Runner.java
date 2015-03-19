package test.task.epam;

import java.io.IOException;

/**
 * Class {@link Runner}
 *
 * @author Daniil Selivanov
 * @version 1.0
 * @since 3/18/15
 */
public class Runner {

    private MatrixPrinter matrixPrinter = new MatrixPrinter();
    private MatrixFiller matrixFiller = new MatrixFiller();

    public static void main(String[] args) throws IOException {
        Runner runner = new Runner();
        Matrix matrix = new Matrix();
        runner.matrixFiller.randomHeaders(matrix);
        runner.matrixFiller.computeBody(matrix);
        int i = 0;
        while (!matrix.valid()) {
            if (i > 10) {
                return;
            }
            runner.matrixFiller.correctHeaders(matrix);
            runner.matrixFiller.clearBody(matrix);
            runner.matrixFiller.computeBody(matrix);
            i++;
        }
        System.out.println(matrix.toString());
        if (args.length > 0) {
            runner.matrixPrinter.printBody(matrix, args[0]);
        } else {
            runner.matrixPrinter.printBody(matrix);
        }
    }
}
