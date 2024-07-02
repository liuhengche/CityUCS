/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 281019
 * Submitted at:  2024-02-20 21:16:21
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    819
 * Problem Name:  Josephus Problem
 */

#include <iostream>
using namespace std;

class Node {
public:
	int data;
	Node* next;

	Node(int d) {
		this->data = d;
		this->next = nullptr;
	}
};

class List {
public:
	Node* head;

	List(Node* n = nullptr) :head(n) {};

	void push(int d) {
		Node* newNode = new Node(d);
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

	void linkAll() {
		Node* p = head;
		while (p->next != nullptr) {
			p = p->next;
		}
		p->next = head;
	}

	int count() {
		Node* p = head;
		int count = 1;

		if (p == nullptr) {
			return 0;
		}
		else {
			int firD = p->data;
			while (p->next != nullptr) {
				p = p->next;
				if (firD == p->data) {
					break;
				}
				count++;
			}
		}
		return count;
	}

	void prtAdel(int m) {
		Node* p1 = head;
		Node* p2 = head;
		for (int i = 0; i < m - 1; i++) {
			p2 = p1;
			p1 = p1->next;
		}
		int d = p1->data;
		cout << d;
		if (this->count() != 1) {
			cout << " ";
		}
		else {
			cout << '\n';
		}
		p2->next = p1->next;
		this->head = p1->next;
	}
};

int main() {
	int n, m;

	cin >> n;
	cin >> m;
	List l;
	for (int i = 0; i < n; i++) {
		l.push(i + 1);
	}

	//cout << l.count() << endl;
	l.linkAll();

	for (int i = 0; i < n; i++) {

		l.prtAdel(m);  // why not m % l.count() ???

	}

	return 0;
}