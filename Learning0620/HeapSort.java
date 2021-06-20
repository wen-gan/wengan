package com.wengan.Learning0620;

/**
 * @author 文淦
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] a = {3,91,83,5,78,23,35};
        System.out.println("====堆排序前====");
        for(int i : a){
            System.out.print(i + " ");
        }

        Sort(a,a.length-1);
        System.out.println("\n" + "====堆排序后====");
        for(int i : a){
            System.out.print(i + " ");
        }
    }
    public static void MaxHeapify(int[] a,int index,int size){
        int l = 2 * index;
        int r = 2 * index + 1;
        int largest = index;
        if( l <= size && a[l] > a[index]){
            largest = l;
        }
        if(r <= size && a[r] > a[largest]){
            largest = r;
        }
        if(largest != index){
            int temp = a[largest];
            a[largest] = a[index];
            a[index] = temp;
            MaxHeapify(a, largest, size);
        }
    }
    public static void HeapBuild(int[] a,int size){
        for(int i = size/2; i >= 1; i--){
            MaxHeapify(a, i, size);
        }
    }
    public static void Sort(int[] a,int size){
        HeapBuild(a, size);
        for(int i = size; i >= 2; i--){
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            MaxHeapify(a,1,i-1);
        }
    }
}
