package HeapSort;

import java.util.Arrays;

public class HeapMin {
    int size = -1;
    int[] arr;

    public HeapMin(int[] arr) {
        this.arr = new int[arr.length];
        Arrays.stream(arr).forEach(this::add);
    }

    private void siftUp(int c) {
        int p = (c - 1) / 2;
        while(p >= 0) {
            if(this.arr[c] < this.arr[p]) {
                swap(c, p);
                c = p;
                p = (c - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void add(int number) {
        size++;
        arr[size] = number;
        siftUp(size);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int peek() {
        if (size == -1) {
            throw new RuntimeException("Heap is empty");
        }
        return this.arr[0];
    }

    private void siftDown() {
       int p = 0;
       while (p < size) {
           int low = p;
           int lc = 2 * p + 1;
           int rc = 2 * p + 2;
           if (lc <= size && rc <= size) {
               low = this.arr[lc] < this.arr[rc] ? lc : rc;

           } else if(lc <= size) {
              low = lc;
           }
           if (this.arr[p] > this.arr[low]) {
                   swap(p, low);
                   p = low;
           } else {
               break;
           }
       }
    }

    private int poll() {
        if (size == -1) {
            throw new RuntimeException("Heap is empty");
        }
        swap(0, size);
        size--;
        siftDown();
        return 0;
    }


    public static void main(String[] args) {
        int[] arr = {6, 3, 4, 6, 8, -1, 0};
        HeapMin heap = new HeapMin(arr);
        System.out.println(heap.peek());
        heap.print();
        heap.poll();
        System.out.println(heap.peek());
        heap.print();
        heap.poll();
        System.out.println(heap.peek());
                heap.print();
        heap.poll();
        System.out.println(heap.peek());
        heap.poll();
        heap.print();
        System.out.println(heap.peek());
        heap.poll();
        heap.print();
        System.out.println(heap.peek());
        heap.poll();
        heap.print();
        System.out.println(heap.peek());
    }

    private void print() {
        System.out.println(Arrays.toString(this.arr));
    }
}
