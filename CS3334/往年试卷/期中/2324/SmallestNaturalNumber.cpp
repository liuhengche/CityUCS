#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    while (cin >> n) {
        // int arr[n];
        // for (int i = 0; i < n; i++) {
        //     cin >> arr[i];
        //     int pointer = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == pointer + 1) {
        //             pointer = 1;
        //             break;
        //         }
        //         if (pointer == 0) {
        //             return 1;
        //         }
        //         for(int i = 0; i < n; i++) {
        //             if (arr[i] <= 0 || arr[i] > n) {
        //                 arr[i] = 1;
        //             }
        //         }
        //     }
        // }
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        sort(arr.begin(), arr.end());
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == res) {
                res++;
            }
        }
        cout << res << endl;
    }
    return 0;
}