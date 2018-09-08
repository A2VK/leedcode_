package solutions.tree;


/**
 * Created by hoducust on 2018/9/1 19H 52m .
 */
public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int length;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.data = (Item[]) new Comparable[capacity + 1];
        this.length = 0;
    }

    // Heapify 使构造堆的时间复杂度为 O(n)
    public MaxHeap(Item arr[]) {
        int len = arr.length;
        this.capacity = len;
        this.length = len;
        this.data = (Item[]) new Comparable[len + 1];
        while (len-- > 0) {
            data[len] = arr[len];
        }
        for (int i = length / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public void insert(Item value) {
        if (length + 1 <= capacity) {
            data[length + 1] = value;
            length++;
            shiftUp(length);
        } else {
            throw new IndexOutOfBoundsException("插入值超过堆容量！");
        }

    }

    private void shiftUp(int index) {
        while (index > 1 && data[index / 2].compareTo(data[index]) < 0) {
            swap(data, index, index / 2);
            index = index / 2;
        }
    }

    public Item extractMax() {
        Item result = null;
        if (length > 0) {
            result = data[1];
            swap(data, 1, length--);
            shiftDown(1);
        } else {
            return result;
        }
        return result;
    }

    private void shiftDown(int index) {
        while (index * 2 < length) {
            int j = index * 2;
            if (j + 1 <= length && data[j].compareTo(data[j + 1]) < 0) { // 为了更好利用J值，判断左右大小 让J++ 即可。
                j++;
            }
            if (data[index].compareTo(data[j]) > 0) {
                break;
            }
            swap(data, index, j);
            index = j; // 跳转到下一个子跟继续判断 直至完全符合最大堆性质；
        }
    }

    private void swap(Item[] data, int a, int b) {
        Item temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

}
