/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 285696
 * Submitted at:  2024-04-08 20:00:09
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    830
 * Problem Name:  Reunion
 */

#include <bits/stdc++.h>
using namespace std;

/*

class Graph {
public:
    int v;
    vector<int> adj;
    Graph(int v) {
        this->v = v;
        adj = vector<int>(v, -1);
    }

};
*/


int arr[1005][1005] = {0};

void dfs(int v, int arr[1005][1005], int count[1005], int n) {
    bool visited[1005] = {false};
    stack<int> s;
    s.push(v);
    visited[v] = true;
    while(!s.empty()) {
        int top = s.top();
        s.pop();
        for(int i = 1; i <= n; i++) {
            if(arr[top][i] == 1 && !visited[i]) {
                s.push(i);
                visited[i] = true;
                count[i]++;
            }
        }
    }
}

int main() {
    int k, n, m;
    cin >> k >> n >> m;
    int friends[k+1];
    for(int i = 1; i <= k; i++) {
        cin >> friends[i];
    }

    for (int i = 0; i < m; i++) {
        int a, b; 
        cin >> a >> b;
        arr[a][b] = 1;
    }

    int count[1005] = {0};

    for(int i = 1; i <= k; i++) {
        count[friends[i]]++;
        dfs(friends[i], arr, count, n);
    }

    int ans = 0;

    for(int i = 1; i <= n; i++) {
        if(count[i] == k) {
            ans++;
        }
    }

    cout << ans << endl;

}