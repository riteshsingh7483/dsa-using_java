import java.util.Scanner;

public class mergesort {
    public static void merger(int[] arr,int l,int r){
        int mid = l+(r-l)/2;
        int[] an = new int[r-l+1];
        int i = l;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=r){
            if(arr[i]<arr[j]){
                an[k] = arr[i];
                i++;
                k++;
            }
            else{
                an[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            an[k] = arr[i];
            i++;
            k++;
        }
        while(j<=r){
            an[k] = arr[j];
            j++;
            k++;

        }
        for(int m = 0;m<an.length;m++){
            arr[l+m] = an[m];
        }
    }
    public static void mergesrt(int[] arr,int l,int r){
        if(r<=l){
            return;
        }
        int mid = l+(r-l)/2;
        mergesrt(arr,l,mid);
        mergesrt(arr,mid+1,r);
        merger(arr,l,r); 
        

    }
    public static void printarr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = sc.nextInt();
        }
        System.out.println("Given array");
        printarr(ar);
        mergesrt(ar,0,ar.length-1);
        System.out.println("Sorted Array");
        printarr(ar);
    }
    
}
