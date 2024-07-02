/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 282783
 * Submitted at:  2024-03-12 12:33:39
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    755
 * Problem Name:  Stock Market
 */

#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        stack<int> s;   
        long long int maxArea = 0;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        for (int i = 0; i < n; i++) {
            if (s.empty() || a[s.top()] <= a[i]) {
                s.push(i);
            } 
            else {
                while (!s.empty() && a[s.top()] > a[i]) {
                    long long int top = s.top();
                    s.pop();
                    long long int area = (long long)a[top] * (s.empty() ? i : i - s.top() - 1);
                    maxArea = (long long ) max(maxArea, area);
                }
                s.push(i);
            }
        }
        while (!s.empty()) {
            int top = s.top();
            s.pop();
            long long int area = (long long) a[top] * (s.empty() ? n : n - s.top() - 1);
            maxArea = (long long) max(maxArea, area);
        }
        cout << maxArea << endl;
    }
}