/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 280395
 * Submitted at:  2024-01-31 13:21:44
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    740
 * Problem Name:  Manipulate List
 */

#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node(int data = 0) : data(data), next(nullptr) {};

};

class List {
public:
    Node* head = nullptr;
    void insertNode(int ith, int data) {
        Node* newNode = new Node(data);
        Node* p = head;
        for (int i = 0; i < ith - 1; i++) {
            p = p->next;
        }
        newNode->next = p->next;
        p->next = newNode;
    }

    void push(int data) {
        Node* newNode = new Node(data);
        Node* p = head;
        if (p == nullptr) {
            head = newNode;
        }
        else {
            while (p->next != nullptr) {
                p = p->next;
            }
            p->next = newNode;
        }
    }

    int count() {
        int count = 0;
        Node* p = head;
        while (p->next != nullptr) {
            count++;
            p = p->next;
        }
        count++;
        return count;
    }

    void del(int ith) {
        Node* p = head;
        if (ith == 1) {
            head = head->next;
        }
        else if (ith == this->count()) {
            while (p->next->next != nullptr) {
                p = p->next;
            }
            p->next = nullptr;
        }
        else {
            for (int i = 0; i < ith - 2; i++) {
                p = p->next;
            }
            p->next = p->next->next;
        }
    }

    void query(int ith) {
        Node* p = head;
        for (int i = 0; i < ith - 1; i++) {
            p = p->next;
        }
        cout << p->data << endl;
    }

    void inverse(int beg, int end) {
        /*
        if (i < 0) {
            return;
        }

        Node* newNode = new Node(data);

        if (i == 0) {
            newNode->next = head;
            head = newNode;
            return;
        }
        Node* pre = nullptr;
        Node* cur = head;
        int pos = 0;

        //traverse to the i-1th element
        while (curr != nullptr && pos<1) {
            prev = curr;
            curr = curr->next;
            pos++;
        }
        if (cur != nullptr) {
            prev->next = newNode;
        }
        newNode->next = curr;






        Node* pre = nullptr;
        Node* cur = first;
        int pos = 0;
        while(cur != nullptr && pos<i) {
            pre = cur;
            cur = cur->next;
            pos++;
        }
        Node* previ = pre
    
        */
        Node* fir = head;
        Node* prev;
        Node* curr = head;
        Node* las = head;
        Node* nex;
        int count = 0;
        for (int i = 0; i < beg - 2; i++) {
            fir = fir->next;
        }
        prev = fir;
        for (int i = 0; i < beg - 1; i++) {
            curr = curr->next;
        }
        for (int i = 0; i < end; i++) {
            las = las->next;
        }

        if (beg == 1 && end == this->count()) {
            prev = nullptr;
            nex = nullptr;
            while (curr != nullptr) {
                nex = curr->next;
                curr->next = prev;
                prev = curr;
                curr = nex;
            }
            head = prev;
            return;
        }

        if (beg == 1) {
            prev = nullptr;
            while (count <= end-beg) {
                nex = curr->next;
                curr->next = prev;
                prev = curr;
                curr = nex;
                count++;
            }
            fir->next = curr;
            this->head = prev;
            return;
        }
        while (count <= end - beg) {
            nex = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nex;
            count++;
        }
        fir->next->next = las;
        fir->next = prev;
    }

};

void operations(int num, List& lst) {
    switch (num)
    {
    case 1: {
        int ith;
        int val;
        cin >> ith;
        cin >> val;
        lst.insertNode(ith, val);
        break;
    }

    case 2: {
        int ith2;
        cin >> ith2;
        lst.del(ith2);
        break;
    }

    case 3: {
        int ith3;
        int jth;
        cin >> ith3;
        cin >> jth;
        lst.inverse(ith3, jth);
        break;
    }
    case 4: {
        int ith4;
        cin >> ith4;
        lst.query(ith4);
        break;
    }
    default:
        break;
    }
}

int main() {
    int len;
    int num;
    List lst;
    cin >> len;
    for (int i = 0; i < len; i++) {
        cin >> num;
        lst.push(num);
    }
    cin >> len;
    for (int i = 0; i < len; i++) {
        cin >> num;
        operations(num, lst);
    }
    return 0;
}