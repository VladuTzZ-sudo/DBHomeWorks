package DeutscheBank.HomeWork02;

import java.util.Arrays;

public class MyList<T> {
    Object[] data;
    private int size;
    private static final Object[] EMPTY_DATA = {};

    public MyList(int dimension) {
        if (dimension > 0) {
            this.data = new Object[dimension];
        } else if (dimension == 0) {
            this.data = EMPTY_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Dimension: " +
                    dimension);
        }
    }

    public void add(T t) {
        if (size == data.length) {
            int oldCapacity = data.length;
            if (oldCapacity > 0 || data != EMPTY_DATA) {
                int newCapacity = oldCapacity * 2;
                data = Arrays.copyOf(data, newCapacity);
            }
        }
        data[size] = t;
        ++size;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0 ; i < size ; i++){
            System.out.print(data[i].toString());
            if (i + 1 < size){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    int indexOfRange(Object o, int end) {
        if (o == null) {
            for (int i = 0; i < end; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < end; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean lookup (T element){
        return indexOfRange(element, size) >= 0;
    }
}

