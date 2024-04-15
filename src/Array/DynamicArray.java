package Array;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T>, DynamicArrayADT<T> {
    private T[] data;
    private int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity cannot be negative or equal to 0: " + capacity);
        this.data = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    private DynamicArray(T[] data, int capacity, int size) {
        this.data = data;
        this.capacity = capacity;
        this.size = size;
    }

    @SuppressWarnings("unchecked")
    private T[] newArr() {
        return (T[]) new Object[this.capacity * 2];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public T next() {
                return data[i++];
            }

        };
    }

    @Override
    public void push(T data) {
        if (size >= capacity - 1) {
            T[] newArr = newArr();
            this.capacity *= 2;
            for (int i = 0; i < size; i++) {
                newArr[i] = this.data[i];
            }
            this.data = newArr;
        }
        this.data[this.size] = data;
        size++;
    }

    @Override
    public T pop() {
        T value = this.data[size - 1];
        this.data[size - 1] = null;
        size--;
        return value;
    }

    @Override
    public void insert(T data, int index) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (this.size == this.capacity - 1) {
            T[] newArr = newArr();
            this.capacity *= 2;
            for (int i = 0; i < index; i++) {
                newArr[i] = this.data[i];
            }
            newArr[index] = data;
            for (int i = index; i < size; i++) {
                newArr[i + 1] = this.data[i];
            }
            this.data = newArr;
        } else {
            T[] newArr = this.data.clone();
            for (int i = 0; i < index; i++) {
                newArr[i] = this.data[i];
            }
            newArr[index] = data;
            for (int i = index; i < size; i++) {
                newArr[i + 1] = this.data[i];
            }
            this.data = newArr;
        }
        size++;
    }

    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @Override
    public T removeAt(int index) {
        T data = this.data[index];
        for (int i = index; i < size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = null;
        size--;
        return data;
    }

    @Override
    public T remove(T data) {
        int i = indexOf(data);
        if (i == -1) {
            throw new IllegalArgumentException("Value not in array");
        }
        return removeAt(i);
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(this.capacity).append("] = [");
        for (int i = 0; i < size - 1; i++) {
            sb.append(this.data[i]).append(", ");
        }
        sb.append(this.data[size - 1]).append("]");
        return sb.toString();
    }

    public DynamicArray<T> clone() {
        return new DynamicArray<T>(this.data, this.capacity, this.size);
    }
}
