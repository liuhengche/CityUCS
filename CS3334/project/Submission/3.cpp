#include <iostream>
#include <string>
using namespace std;

class Node {
public:
    int val;
    int cnt;
    Node* next;
    Node(int val, int cnt) {
        this->val = val;
        this->cnt = cnt;
        this->next = NULL;
    }

    Node() {
        this->val = 0;
        this->cnt = 0;
        this->next = NULL;
    }
};

class LinkedList {
public:
    Node* head;
    Node nodes[10000];
    int size;

    LinkedList() {
        this->head = NULL;
        this->size = 0;
    }

    Node* findNode(int val) {
        Node* cur = head;
        while (cur != NULL) {
            if (cur->val == val) {
                return cur;
            }
            cur = cur->next;
        }
        return NULL;
    }

    void addNode(int val) {
        Node* node = findNode(val);
        if (node == NULL) {
            if (this->head == NULL) {
                nodes[0] = Node(val, 1);
                size++;
                head = &nodes[0];
            }
            else {
                nodes[size] = Node(val, 1);
                size++;
                nodes[size - 2].next = &nodes[size - 1];
            }
        }
        else {
            node->cnt++;
            return;
        }
    }

    void res(int res[], int& count) {
        Node* cur = head;
        while (cur != NULL) {
            if (cur->cnt == 1) {
                res[count++] = cur->val;
            }
            cur = cur->next;
        }
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

    //uses linked list to store the numbers
    LinkedList* list = new LinkedList();
    for (int i = 0; i < n; i++) {
        list->addNode(arr[i]);
    }
    list->res(res, count);

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