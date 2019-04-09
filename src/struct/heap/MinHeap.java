package struct.heap;

public class MinHeap {
    private int size;
    private int[] arr;

    public MinHeap(int capacity) {
        this.size = 0;
        this.arr = new int[capacity];
    }

    public void add (int num) {
        arr[size++] = num;
        int i = size - 1;
        while (i > 0 && arr[i/2] > arr[i]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    public int remove() {
        size--;
        int ret = arr[0];
        swap(size, 0);
        heapify(0);
        return ret;
    }

    public void heapify(int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int small = i;
        if (l < size && arr[i] > arr[l]) {
            small = l;
        }
        if (r < size && arr[r] < arr[small]) {
            small = r;
        }
        if (i != small) {
            swap(i, small);
            heapify(small);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
