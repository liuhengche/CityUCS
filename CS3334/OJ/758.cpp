/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 288362
 * Submitted at:  2024-04-22 16:27:27
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    758
 * Problem Name:  Fibonacci Sequence
 */

#include <bits/stdc++.h>
using namespace std;

// int fib(int n)
// {
//     int a = 0, b = 1, c, i;
//     if (n == 0)
//         return a;
//     for (i = 2; i <= n; i++) {
//         c = a + b;
//         a = b;
//         b = c;
//     }
//     return b;
// }

#define radix 1024

int initialize(long long int& n, long long int& q, long long int* arr) {
    arr[0] = 1;
    arr[1] = 1;
    int max = 0;
    for (int i = 2; i < n; i++) {
        arr[i] = (arr[i-2] % q + arr[i-1] % q) % q;
        if (arr[i] > max) {
            max = arr[i];
        }
        //cout << "arr[" << i << "] = " << arr[i] << endl;
    }
    return max;
}

void countSort(long long int* arr, long long int n, long long int exp) {
    vector<long long int> output(n, 0); // output array
    long long int count[radix] = {0};
    long long int i;
    for (i = 0; i < n; i++) {
        count[(arr[i]/exp)%radix]++;
    }
    for (i = 1; i < radix; i++) {
        count[i] += count[i-1];
    }
    for (i = n-1; i >= 0; i--) {
        output[count[(arr[i]/exp)%radix]-1] = arr[i];
        count[(arr[i]/exp)%radix]--;
    }
    for (i = 0; i < n; i++) {
        arr[i] = output[i];
    }
}   

void radixSort(long long int* arr, long long int n, long long int max) {
    for (int exp = 1; max/exp > 0; exp *= radix) {
        countSort(arr, n, exp);
    }
}

int main() {
    int cases;
    cin >> cases;
    while(cases--) {
        long long int n, q;
        cin >> n >> q;
        long long int* arr = new long long int[n];
        int max = initialize(n, q, arr);


        // cout << "the max is " << max << endl;
        // cout << "this is before sort" << endl;
        // for (int i = 0; i < n; i++) {
        //     cout << arr[i] << " ";
        // }
        // cout << endl;
        // int size = sizeof(arr)/sizeof(arr[0]);
        // cout << "size is " << size << endl;



        radixSort(arr, n, max);
        long long int ans = 0;


        // cout << "this is after sort" << endl;
        // for (int i = 0; i < n; i++) {
        //     cout << arr[i] << " ";
        // }
        // cout << endl;

        // for (int i = 0; i < n; i++) {
        //     long long temp = arr[i]%q;
        //     ans = (ans%q + (temp*(i+1))%q)%q;
        // }


        for (int i = 0; i < n; i++) {
            //ans += arr[i] * (i+1);
            long long int temp = arr[i] % q;
            // if (i < 100 && temp < 0) {
            //     cout << "temp is " << temp << endl;
            // }
            ans = (ans%q + (temp*(i+1))%q)%q; 
        }
        cout << ans%q << endl;
        delete[] arr;
    }


    return 0;
}