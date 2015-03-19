package test.task.epam;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@link Runner}
 *
 * @author Daniil Selivanov
 * @version 1.0
 * @since 3/18/15
 */
public class Matrix {

    public static final int CAPACITY = 10;

    private List<Integer> rowHeaders = new ArrayList<>(CAPACITY);
    private List<Integer> columnHeaders = new ArrayList<>(CAPACITY);
    private List<List<Integer>> body = new ArrayList<>(CAPACITY);

    public Matrix() {
        initHeaders();
        initBody();
    }

    public int sumRowHeaders() {
        int result = 0;
        for (Integer i : rowHeaders) {
            result += i;
        }
        return result;
    }


    public int sumColumnHeaders() {
        int result = 0;
        for (Integer i : columnHeaders) {
            result += i;
        }
        return result;
    }

    public int sumRow(int row) {
        int result = 0;
        for (Integer i : body.get(row)) {
            result += i;
        }
        return result;
    }

    public int sumColumn(int column) {
        int result = 0;
        for (List<Integer> i : body) {
            result += i.get(column);
        }
        return result;
    }

    public int sumBody() {
        int result = 0;
        for (List<Integer> i : body) {
            for (Integer j : i) {
                result += j;
            }
        }
        return result;
    }

    public boolean valid() {
        return sumColumnHeaders() == sumRowHeaders() && sumColumnHeaders() == sumBody();
    }

    public String bodyToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CAPACITY; i++) {
            for (int j = 0; j < CAPACITY; j++) {
                stringBuilder.append("|").append(body.get(i).get(j)).append("\t");
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("|").append("\t");
        for (Integer columnSum : columnHeaders) {
            stringBuilder.append("|").append(columnSum).append("\t");
        }
        stringBuilder.append("|\n");
        for (int i = 0; i < CAPACITY; i++) {
            stringBuilder.append("|").append(rowHeaders.get(i)).append("\t");
            for (int j = 0; j < CAPACITY; j++) {
                stringBuilder.append("|").append(body.get(i).get(j)).append("\t");
            }
            stringBuilder.append("|\n");
        }

        return stringBuilder.toString();
    }

    public List<Integer> getRowHeaders() {
        return rowHeaders;
    }

    public void setRowHeaders(List<Integer> rowHeaders) {
        this.rowHeaders = rowHeaders;
    }

    public List<Integer> getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(List<Integer> columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public List<List<Integer>> getBody() {
        return body;
    }

    public void setBody(List<List<Integer>> body) {
        this.body = body;
    }

    private void initHeaders() {
        for (int i = 0; i < CAPACITY; i++) {
            rowHeaders.add(0);
            columnHeaders.add(0);
        }
    }

    private void initBody() {
        for (int i = 0; i < CAPACITY; i++) {
            body.add(new ArrayList<Integer>(CAPACITY));
            for (int j = 0; j < CAPACITY; j++) {
                body.get(i).add(0);
            }
        }
    }
}
