/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 281820
 * Submitted at:  2024-03-02 19:47:01
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    750
 * Problem Name:  Closest Common Ancestor
 */

#include <iostream>

class Node {
public:
	int lev;
	int val;
	Node* parent;
	Node(int l = 0, int v = 0, Node* p = nullptr) { this->lev = l; this->val = v; this->parent = p; };
};

int comAnc(Node* firNode, Node* secNode, Node* fam) {
	int fLev = firNode->lev;
	int sLev = secNode->lev;
	int* visit = new int[fLev+1];
	for (int i = 0; i <= fLev; i++) {
		visit[i] = firNode->val;
		//std::cout << "for visit" << i << " is " << visit[i] << std::endl;
		firNode = firNode->parent;
	}
	while (secNode != nullptr) {
		for (int i = 0; i <= fLev; i++) {
			if (secNode->val == visit[i]) {
				return visit[i];
			}
		}
		secNode = secNode->parent;
	}
	
};

int main() {
	int tests;
	std::cin >> tests;
	for (int testsi = 0; testsi < tests; testsi++) {
		int r;
		std::cin >> r;
		int size;
		std::cin >> size;
		//int curLev = 1;
		Node* fam = new Node[size];  // you have to set the initial values for the list first!!!
		Node* root = new Node(0, r, nullptr);
		//std::cout << "root is " << root->val << " at lev " << root->lev << " parent is " << root->parent << std::endl;
		fam[r - 1] = *root;
		Node* par = root;
		for (int i = 1; i < size; i++) {
			int curV, curP;
			std::cin >> curV >> curP;
			fam[curV - 1] = Node(fam[curP-1].lev + 1,curV,&fam[curP-1]);
			//std::cout << "new node is " << fam[curV - 1].val << " at lev " << fam[curV - 1].lev << " parent is " << fam[curV - 1].parent->val << std::endl;
			
		}
		int firN, secN;
		std::cin >> firN >> secN;
		Node* firNode = &fam[firN - 1];
		Node* secNode = &fam[secN - 1];
		std::cout << comAnc(firNode, secNode, fam) << std::endl;
		delete[] fam;
	}
	return 0;
}