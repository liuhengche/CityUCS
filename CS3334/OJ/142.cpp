/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 284828
 * Submitted at:  2024-03-27 12:43:26
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    142
 * Problem Name:  FRIENDS (UVa 10608)
 */


#include <bits/stdc++.h>
using namespace std;

const int MAXN = 30005;

int fa[MAXN] = {0};
int num[MAXN] = {0};

int get(int x) {
    if (fa[x] == x) return x;
    return fa[x] = get(fa[x]);
}

void merge(int x, int y) {
    fa[get(x)] = get(y);
}

int main() {
    int tests;
    cin >> tests;
    while(tests--) {
        int n, m;
        cin >> n >> m;
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int f1, f2;
            cin >> f1 >> f2;
            //cout << get(f1) << " " << get(f2) << endl;
            if (get(f1) != get(f2)) {
                merge(f1, f2);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            //cout << num[get(i)] << " ";
            res = max(res, ++num[get(i)]);
        }
        cout << res << endl;
        memset(fa, 0, sizeof(fa));
        memset(num, 0, sizeof(num));

    }
}





// #include <bits/stdc++.h>
// using namespace std;


// class DisjointSet { 
//     public:
//     vector<int> parent, rank;
//     DisjointSet(int n) {
//         parent.resize(n);
//         rank.resize(n);
//         for (int i = 0; i < n; i++) {
//             parent[i] = i;
//             rank[i] = 0;
//         }
//     }
//     int find(int x) {
//         if (x == parent[x]) return x;
//         return parent[x] = find(parent[x]);
//     }
//     void unite(int x, int y) {
//         parent[find(x)] = find(y);
//     }
// };

// int main() {
//     int cases;
//     cin >> cases;
//     while(cases--) {
//         int n, m;
//         cin >> n >> m;
//         DisjointSet ds = DisjointSet(n);

//         for (int i = 0; i < m; i++) {
//             int a, b;
//             cin >> a >> b;
//             ds.unite(a, b);

//         }

//         int ans = 0;
//         for (int i = 0; i < n; i++) {
//             ans = max(ans, ds.rank[i]);
//         }
//         cout << ans << endl;
        


//     }
//     return 0;
// }