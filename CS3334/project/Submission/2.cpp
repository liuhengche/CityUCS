#include <iostream>
#include <string>
using namespace std;

class Node {
public:
    int val;
    Node* left;
    Node* right;
    int count;
    Node(int val) : val(val), left(NULL), right(NULL), count(1) {}

};

class BinarySearchTree {
public:
    Node* root;
    BinarySearchTree() : root(NULL) {}

    void insert(int val) {
        if (root == NULL) {
            root = new Node(val);
        }
        else {
            insert(root, val);
        }
    }

    void insert(Node* node, int val) {
        if (val < node->val) {
            if (node->left == NULL) {
                node->left = new Node(val);
            }
            else {
                insert(node->left, val);
            }
        }
        else if (val > node->val) {
            if (node->right == NULL) {
                node->right = new Node(val);
            }
            else {
                insert(node->right, val);
            }
        }
        else {
            node->count++;
        }
    }

    Node* find(Node* node, int val) {
        if (node == NULL) {
            return NULL;
        }
        if (val < node->val) {
            return find(node->left, val);
        }
        else if (val > node->val) {
            return find(node->right, val);
        }
        else {
            return node;
        }
    }

    Node* find(int val) {
        return find(root, val);
    }
};



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

    // uses binary search tree to store the numbers
    BinarySearchTree bst;
    for (int i = 0; i < n; i++) {
        bst.insert(arr[i]);
    }
    for (int i = 0; i < n; i++) {
        Node* node = bst.find(arr[i]);
        if (node->count == 1) {
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