import java.util.Scanner;

public class quicksort {
    public static void quicksrt(int[] arr,int l,int h){
        if(l<h){
            int pi = partition(arr, l, h);
            quicksrt(arr,l,pi-1);
            quicksrt(arr,pi+1,h);
        }
    }
    public static int partition(int[] arr,int l,int h){
        int piv = arr[h];
        int i = l-1;
        for(int j = l;j<arr.length;j++){
            if(arr[j]<piv){
                i++;
                swapar(arr,i,j);
            }
        }
        swapar(arr,i+1,h);
        return (i+1);
    }
    public static void swapar(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
    public static void printarr(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Given Array");
        printarr(arr);
        quicksrt(arr,0,arr.length-1);
        System.out.println("Sorted Array");
        printarr(arr);
    }
}
