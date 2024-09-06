#include <iostream>
using namespace std;
int binarySearch(int arr[], int x, int low, int high){
    if(low>high) return -1;
    
    else {
       int mid = (low + high)/2;
        if(x==arr[mid]){
            return mid;
        }
        else if(x>arr[mid]){
            return binarySearch(arr,x,mid+1,high); //i have written -1 instead of mid +1 
        }
        else{
            return binarySearch(arr,x, low, mid-1);
        }
    }
}

int main()
{
    
    int arr[5]={8,11,13,16,20};
    int res = binarySearch(arr,11,0,4);
    cout<<res;

    return 0;
}