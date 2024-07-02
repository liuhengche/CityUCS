/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 282352
 * Submitted at:  2024-03-11 17:01:13
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    824
 * Problem Name:  A - B problem
 */

#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, c;
    while(cin >> n >> c) {
        long long ans = 0;
        unordered_map<int, int> mp;
        for (int i = 0; i < n ; i++) {
            int x;
            cin >> x;
            mp[x]++;
        }
        if (c== 0 ){
            for (auto x: mp) {
                ans += (long long) x.second * x.second;
            }
        }
        else {
            for (auto x: mp) {
                if (mp.find(x.first + c) != mp.end()) {
                    ans += (long long) x.second * mp[x.first + c];
                }
            }
        }
        cout << ans << endl;
    }
}