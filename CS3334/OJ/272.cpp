/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 284066
 * Submitted at:  2024-03-18 19:34:59
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    272
 * Problem Name:  Convex Hull
 */

#include <bits/stdc++.h>
using namespace std;

struct Point {
    int x, y;
    Point(int x, int y) : x(x), y(y) {}
    Point() {}
};

bool cmp(Point a, Point b) {
    return a.x < b.x || (a.x == b.x && a.y < b.y);
}

long long cross(Point O, Point A, Point B) {
    return (long long)(A.x - O.x) * (B.y - O.y) - (long long)(A.y - O.y) * (B.x - O.x);
}

int main() {
    int cases;
    cin >> cases;
    while(cases--) {
        int n;
        cin >> n;
        vector<Point> points;
        vector<Point> hull;
        for (int i = 0; i < n; i++) {
            int x, y;
            cin >> x >> y;
            Point p(x, y);
            points.push_back(p);
        }
        if (points.size() <= 3) {
            cout << points.size() << endl;  
            for (int i = 0; i < points.size(); i++) {
                cout << points[i].x << " " << points[i].y << endl;
            }
            break;
        }
        else {
            sort(points.begin(), points.end(), cmp);
            for (int i = 0; i < points.size(); i++) {
                while (hull.size() >= 2 && cross(hull[hull.size() - 2], hull[hull.size() - 1], points[i]) <= 0) {
                    hull.pop_back();
                }
                hull.push_back(points[i]);
            }
            for (int i = points.size() - 2, t = hull.size() + 1; i >= 0; i--) {
                while (hull.size() >= t && cross(hull[hull.size() - 2], hull[hull.size() - 1], points[i]) <= 0) {
                    hull.pop_back();
                }
                hull.push_back(points[i]);
            }
            hull.pop_back();
            cout << hull.size() << endl;
            for (int i = 0; i < hull.size(); i++) {
                cout << hull[i].x << " " << hull[i].y << endl;
            }
        }
    }
    return 0;
}