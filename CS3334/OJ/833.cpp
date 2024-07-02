/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 287152
 * Submitted at:  2024-04-18 22:12:36
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    833
 * Problem Name:  Lake Biwa
 */

#include <bits/stdc++.h>
using namespace std;


#define MAXN 1000005

class DisjointSets {
    public:
   
    vector<int> parent;
    int groups;

    DisjointSets(int n) {
        parent = vector<int>(n+1, -1);
        groups = 0;
    }

    int find(int i) {
        if (i == parent[i]) {
            return i;

        }

        return parent[i] = find(parent[i]);
    }

    void Union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if (rooti != rootj) {
            parent[rootj] = rooti;
            groups--;
        }

    }

};


int main() {
    int n, m;
    cin >> n >> m;
    vector<int> grids(MAXN, 0);
    DisjointSets ds(MAXN);
    for (int i = 0; i < n; i++) {
        for (int j = 1; j <= m; j++) {
            cin >> grids[i*m+j];

        }
    }
    int t;
    cin >> t;
    vector<int> years(t,0);
    vector<int> result(t,0);
    for (int i = 0; i < t; i++) {
        cin >> years[i];
    }
    vector<vector<int>> group(t);
    for (int i = 1; i <= n*m; i++) {
        if (grids[i] > years[0]) {
            int idx = upper_bound(years.begin(), years.end(), grids[i]-1) - years.begin();
            group[idx-1].push_back(i);
        }
    }

    for (int i = t-1; i >= 0; i--) {
        
        for (int j = 0; j < group[i].size(); j++) {
            int idx = group[i][j];
            ds.parent[idx] = idx;
            ds.groups++;
            if ((idx-1)%m > 0 && ds.parent[idx-1] != -1) {
                ds.Union(idx, idx-1);
            }
            if ((idx-1)%m < m-1 && ds.parent[idx+1] != -1) {
                ds.Union(idx, idx+1);
            }   
            if (idx > m && ds.parent[idx-m] != -1) {
                ds.Union(idx, idx-m);
            }
            if (idx < n*m-m && ds.parent[idx+m] != -1) {
                ds.Union(idx, idx+m);
            }      
        }
        result[i] = ds.groups;
    }
    for (int i = 0; i < t; i++) {
        cout << result[i] ;
        if (i < t-1) {
            cout << " ";
        }
    }
    cout << endl;
    return 0;
}