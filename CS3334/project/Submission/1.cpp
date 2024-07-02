#include <iostream>
#include <string>
using namespace std;

void initialize(string& expression, int& i, int& n, int arr[10000]) {
    while (i < expression.length()) {
        int sign = 1;
        if (expression[i] == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < expression.length() && expression[i] >= '0' && expression[i] <= '9') {
            num = num * 10 + (expression[i] - '0');
            i++;
        }
        arr[n++] = sign * num;
        i++;
    }
}

void printRes(int res[], int count) {
    if (count > 0) {
        cout << res[0];
        for (int i = 1; i < count; i++) {
            cout << " " << res[i];
        }
        cout << endl;
    }

}

void solution(string expression) {
    int n = 0;
    int i = 0;
    int arr[10000];
    int res[10000];
    int count = 0;
    initialize(expression, i, n, arr);

    // uses array implementation and brute force;
    bool visited[10000] = { false };
    for (int i = 0; i < n; i++) {
        bool flag = false;
        if (visited[i]) {
            continue;
        }
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                visited[j] = true;
                flag = true;
            }
        }
        if (!flag) {
            res[count++] = arr[i];
        }
    }
    printRes(res, count);

}

int main() {
    string expression;
    getline(cin, expression);
    while (expression != "") {
        solution(expression);
        getline(cin, expression);
    }
}