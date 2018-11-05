package struct.heap;

import java.util.Arrays;

/**
 * @author create by Xiao Han 10/8/18
 * @version 1.0
 * @since jdk 1.8
 */
public class MaxHeap {

  private int data[];
  private int size;
  private int capacity;

  public MaxHeap(int capacity) {
    this.capacity = capacity;
    data = new int[capacity];
  }

  public void insert(int d) {
    //堆首不放元素
    data[++size] = d;
    maxHeapify(size);
  }

  public void delete() {
    data[1] = data[size --];
    reHeapify(1);
  }

  private void maxHeapify(int i) {
    int p = i / 2;
    int n = 0;
    if (p > 0 && data[i] > data[p]) {
      swap(i, p);
      maxHeapify(p);
    }
  }

  private void reHeapify(int i) {
    int l = 2 * i;
    int r = 2 * i + 1;
    int largest = 0;
    if (l < size && data[l] > data[i]) {
      largest = l;
    } else {
      largest = i;
    }
    if (r < size && data[r] > data[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(largest, i);
      reHeapify(largest);
    }
  }


  private void swap(int i , int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public void show() {
    System.out.println(Arrays.toString(data));
  }


  public static void main(String[] args) {
    MaxHeap maxHeap = new MaxHeap(10);
    maxHeap.insert(5);
    maxHeap.insert(6);
    maxHeap.insert(10);
    maxHeap.insert(7);
    maxHeap.insert(8);
    maxHeap.show();
    maxHeap.delete();
    maxHeap.show();

  }
}
