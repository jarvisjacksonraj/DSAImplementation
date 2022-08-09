package datastructure.dynamicarray;

import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    T[] intArray;
    int arrayCapacity;
    int arrayLength = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Illegal Initial Capacity of Array: " + capacity);
        this.arrayCapacity = capacity;
        intArray = (T[]) new Object[capacity];
    }

    // Given an array make it a dynamic array!
    public DynamicArray(T[] array) {
        if (array == null) throw new IllegalArgumentException("Array cannot be null");
        intArray = java.util.Arrays.copyOf(array, array.length);
        arrayCapacity = arrayLength = array.length;
    }

    public T get(int index) {
        if (index > arrayLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return intArray[index];
    }

    public T set(int index, T element) {
        if (index > arrayLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return intArray[index] = element;
    }

    public void clear() {
        for (int index = 0; index < arrayCapacity; index++) {
            intArray[index] = null;
        }
        arrayLength = 0;
    }

    public int size() {
        return arrayLength;
    }

    public boolean isEmpty() {
        return arrayLength == 0;
    }

    public void add(T element) {
        if (arrayLength + 1 >= arrayCapacity) {
            if (arrayCapacity == 0) {
                arrayCapacity = 1;
            } else {
                arrayCapacity = arrayCapacity * 2;
            }
            T[] newArray = (T[]) new Object[arrayCapacity];
            for (int i = 0; i < arrayLength; i++) {
                newArray[i] = intArray[i];
            }
            intArray = newArray;
        }
        intArray[arrayLength++] = element;
    }

    public T removeAt(int index) {
        if (index >= arrayLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = intArray[index];
        T[] newArray = (T[]) new Object[arrayLength - 1];

        int j = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (i == index) continue;
            newArray[j++] = intArray[i];
        }
        intArray = newArray;
        arrayCapacity--;
        arrayLength--;
        return data;
    }

    public boolean remove(T element) {
        for (int i = 0; i < arrayLength; i++) {
            if (intArray[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < arrayLength; i++) {
            if (intArray[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public void reverse() {
        for (int i = 0; i < arrayLength / 2; i++) {
            T tmp = intArray[i];
            intArray[i] = intArray[arrayLength - i - 1];
            intArray[arrayLength - i - 1] = tmp;
        }
    }

    @Override
    public String toString() {
        if (arrayLength == 0) {
            return "DynamicArray: []";
        } else {
            StringBuilder sb = new StringBuilder(arrayLength).append("[");
            for (int i = 0; i < arrayLength - 1; i++) {
                sb.append(intArray[i] + ", ");
            }
            return sb.append(intArray[arrayLength - 1] + "]").toString();
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < arrayLength;
            }

            @Override
            public T next() {
                return intArray[index++];
            }
        };
    }
}
