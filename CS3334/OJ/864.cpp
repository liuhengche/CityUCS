/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 282341
 * Submitted at:  2024-03-11 16:15:39
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    864
 * Problem Name:  Another A - B problem
 */

#include <bits/stdc++.h>
using namespace std;    

int main() {
    int cases;
    cin >> cases;
    while(cases--) {
        long long ans = 0;
        int n;
        cin >> n;
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            int key = x - i;    
            mp[key] += 1;
        }

        for (auto x : mp) {
            ans += (long long)x.second * (x.second - 1) / 2;
        }
        cout << ans << endl;
    }
}