package test.task.epam;

/**
 * Class {@link MatrixFiller}
 *
 * @author Daniil Selivanov
 * @version 1.0
 * @since 3/18/15
 */
public class MatrixFiller {


    public static final int MIN = 0;
    public static final int MAX = 99;

    public void randomHeaders(Matrix matrix) {
        for (int i = 0; i < Matrix.CAPACITY; i++) {
            matrix.getRowHeaders().set(i, random());
            matrix.getColumnHeaders().set(i, random());
        }
    }

    public void clearBody(Matrix matrix) {
        for (int i = 0; i < Matrix.CAPACITY; i++) {
            for (int j = 0; j < Matrix.CAPACITY; j++) {
                matrix.getBody().get(i).set(j, 0);
            }
        }
    }

    public void computeBody(Matrix matrix) {
        for (int i = 0; i < Matrix.CAPACITY; i++) {
            for (int j = 0; j < Matrix.CAPACITY; j++) {
                int value = 0;
                if (j == Matrix.CAPACITY - 1) {
                    value = matrix.getRowHeaders().get(i) - matrix.sumRow(i);
                } else {
                    value = (int) Math.round(((double) matrix.getColumnHeaders().get(j) / (double) matrix.sumColumnHeaders())
                            * (double) matrix.getRowHeaders().get(i));
                }
                matrix.getBody().get(i).set(j, value);
            }
        }
    }

    public void correctHeaders(Matrix matrix) {
        for (int i = 0; i < Matrix.CAPACITY; i++) {
            int delta = matrix.sumColumnHeaders() - matrix.sumRowHeaders();
            int newValue = matrix.getRowHeaders().get(i) + delta;
            if (newValue < MIN) {
                matrix.getRowHeaders().set(i, 0);
                delta = newValue;
            } else if (newValue > MAX) {
                matrix.getRowHeaders().set(i,99);
                delta = newValue - 99;
            } else {
                matrix.getRowHeaders().set(i, newValue);
            }
        }
    }

    private Integer random() {
        return (int) Math.abs(Math.random() * 100);
    }
}
