#include <bits/stdc++.h>
using namespace std;    

int main() {
    int t;
    cin >> t;
    while(t--) {
        int n, m;
        cin >> n >> m;
        int a[n];
        int presum[n];
        for(int i = 0; i < n; i++) {
            cin >> a[i];
            if (i == 0) {
                presum[i] = a[i];
            } else {
                presum[i] = presum[i-1] + a[i];
            }
        }
        int left[n], right[n];
        stack<int> s;

        for (int i = 0; i < n; i++) {
            while (!s.empty() && a[s.top()] > a[i]) {
                s.pop();
            }
            if (s.empty()) {
                left[i] = 0;
            } else {
                left[i] = s.top() + 1;
            }
            s.push(i);
        }

        while (!s.empty()) {
            s.pop();
        }

        for (int i = n-1; i >= 0; i--) {
            while (!s.empty() && a[s.top()] > a[i]) {
                s.pop();
            }
            if (s.empty()) {
                right[i] = n-1;
            } else {
                right[i] = s.top() - 1;
            }
            s.push(i);
        }

        int l = 0;
        int r = 0;
        int curS = 0;
        int sum = 0;
        vector<int> idx;
        for (int i = 0 ; i < n; i++) {
            if (a[i] == m)  {
                idx.push_back(i);
            }
        }

        for (int i = 0; i < idx.size(); i++) {
            l = left[idx[i]];
            r = right[idx[i]];
            curS = 0;
            for (int j = l; j <= r; j++) {
                curS += a[j];
            }
            if (curS > sum) {
                sum = curS;
            }
        }
        cout << sum << endl;

    }
    return 0;
}