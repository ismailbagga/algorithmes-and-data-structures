package com.ismail.coder.datastructures.array;
import java.util.Iterator;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class DynamicArray<T extends Comparable<T> > implements Iterable<T> {
    private  int capacity ;
    private int length ;
    private  T[] array ;
    public DynamicArray() {
        this(16) ;
    }
    public DynamicArray(int capacity ){
        if (capacity < 0 ) throw new IllegalArgumentException() ;
        array =(T[])  new Comparable[capacity]   ;
        this.capacity = capacity   ;
    }

    public int size() { return  length ; }

    public void add(T obj) {
        if (length == capacity ) {
            resize(capacity*2);
        }
        array[length++] = obj ;
    }
    public T get(int index) {
        if ( index <  0 || index >= length) throw new IndexOutOfBoundsException() ;
        return  array[index] ;
    }
    public  void set(int index , T obj) {
        if ( index < 0  || index >= length )
            throw  new IndexOutOfBoundsException() ;
        array[index] = obj ;

    }
    public T max() {
        if ( length == 0 ) return null ;
        T max = array[0] ;
        for ( int i = 1 ; i < length ; i++) {
            if ( max.compareTo(array[i]) < 0 ) max  = array[i] ;
        }
        return  max ;
    }
    public T min() {
        if ( length == 0 ) return null ;
        T min = array[0] ;
        for ( int i = 1 ; i < length ; i++) {
            if ( min.compareTo(array[i]) > 0 ) min  = array[i] ;
        }
        return  min ;
    }
    public  int sum(int[] temp  , int index) {
        if (index  ==  0  ) return  temp[0] ;
        return  temp[index] + sum(temp,index-1) ;

    }
    public void insertAt(int index , T obj ) {
        if ( index < 0 || index > length ) throw new IndexOutOfBoundsException() ;
        if ( length == capacity ) {
            resize(capacity*2);
        }
        for (int i = length ; index > i ; i-- ) {
            array[i] = array[i-1]; // Max = O(n)  ; Min = Q(1)
        }
        array[index] = obj ; length++ ;
    }
    public void insertAtSortedArray(T value) {
        if (length == capacity ) resize(capacity*2) ;
        for ( int i =  length -1 ; i >= -1 ; i-- ) {
             if ( i >= 0 &&  array[i].compareTo(value) > 0  ) {
                 array[i+1] = array[i] ;
                 if ( i == 0 ) array[i] = value ;
             }
             else   {
                 array[i+1] = value ;
                 break;
             }
        }
        length++ ;
    }
    public T removeAt(int index) {
        if ( index < 0 || index >= length ) throw new IndexOutOfBoundsException() ;
        T data = array[index] ;
        for ( int i = index  ; i < length-1 ; i++ ) {

            array[i] = array[i+1];
        }
        array[length-1] = null ;
        length-- ;
        return  data ;

//        T[] temp = (T[]) new Comparable[length-1] ;
//        for (int i  = 0 , j = 0  ; i<length-1 ; i++ , j++) {
//            if ( index == i )  j++ ;
//            temp[i] = array[j];
//
//        }
//        array = temp ;
//        temp = null ;
//        capacity = --length ;
//        return data;
    }
    public Comparable<T>[] reverse()  {
        Comparable<T>[] reversedArray  = new Comparable[length] ;
        for (int i = 0 ; i<= length/2 ; i++) {
            reversedArray[i] = array[length-1-i] ;
            reversedArray[length-1-i] = array[i] ;
        }
        return  reversedArray ;
    }

    public  static  <E extends  Comparable<E>> int  binarySearch( E[] sortedArray , int n   , E value) {
        int low = 0 ;
        int high = n - 1 ;
        int mid ;
        while ( low <= high) {
            mid = (low + high ) / 2;
            E temp = sortedArray[mid]  ;
            if ( temp.equals(value) ) return  mid ;
            else if (value.compareTo(temp) > 0  ) low = mid + 1 ;
            else high = mid -1 ;
        }
        return  -1 ;
    }
    public int  contains(T obj) {
        for (int i = 0 ; i<length ; i++) {
            if (array[i].equals(obj)) return  i ;
        }
        return -1 ;
    }
    private  void resize(int newSize) {
        T[] temp = (T[]) new Comparable[newSize] ;
        for (int i = 0 ; i<length ; i++) {
            temp[i] = array[i] ; // Time Complexity O(n)
        }
        // Space Complexity  max = f(n) =  n  + 1 + 1  = 2n  O(n)
        // min = f(n) =  n
        array = temp ;
    }
    @Override
    public void forEach(Consumer<? super T> action) {
        throw new UnsupportedOperationException()  ;
    }


    public String  display() {
        if ( length == 0 ) return  "[]" ;

        String builder = "[" ;
        for (int i = 0 ; i<length;i++)  {

            builder += array[i] + (i == length-1 ? "]":  ",") ; // O(n)
        }
        /*
        * Another way to generate string with string builder
         **/
//        StringBuilder builder = new StringBuilder() ;
//        for (int i = 0 ; i<length-1;i++) builder.append(array[i]).append(",") ;
//
//        return  builder.append(array[length-1]).append("]").toString()  ;
        return  builder ;
    }
    public static <E extends Comparable<E>> String print(DynamicArray<E> vector ) {
        return vector.display() ;
    }


    @Override
    public Iterator<T> iterator() {
        return  new Iterator<T>() {
            public int current  = 0 ;

            @Override
            public boolean hasNext() {
                return current <  length;
            }

            @Override
            public T next() {
                return array[current++];
            }
        };
    }


}