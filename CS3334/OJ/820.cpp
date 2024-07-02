/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 285433
 * Submitted at:  2024-04-04 23:55:58
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    820
 * Problem Name:  Maintaining the Ancient Tree
 */

#include <bits/stdc++.h>    
using namespace std;

int countRemove = 0;

class Node {
public:
    vector<Node*> nodes;
    int value;
    bool checkRemoveSelf = false;
    int numRemoveNodes = 0;
    Node(int value) {
        this->value = value;
    }
    bool renewRemoveSelf() {
        if (nodes.size() == 0) {
            return checkRemoveSelf;
        }
        else {
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes[i]->renewRemoveSelf() == false) {
                    checkRemoveSelf = false;
                    return false;
                }
            }
            checkRemoveSelf = true;
            return true;
        }
    }
    void renewChild() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes[i]->checkRemoveSelf = false;
            nodes[i]->renewChild();
        }
    }

    void removeInit() {
        checkRemoveSelf = true;
    }

    void keepInit() {
        checkRemoveSelf = false;
    }
};

void addNode(Node* root, vector<Node*>& v, vector<Node*>& all) {
    int val;
    cin >> val;
    if (val == -1) {
        v.push_back(root);
        all.push_back(root);
        return;
    }
    else {
        for (int i = 0; i < root->nodes.size(); i++) {
            if (root->nodes[i]->value == val) {
                addNode(root->nodes[i], v, all);
                return;
            }
        }
        Node* newNode = new Node(val);
        root->nodes.push_back(newNode);
        addNode(newNode, v, all);
    }
}

void renewFromRoot(Node* root) {
    root->renewRemoveSelf();
    if (root->nodes.size() == 0) {
        return;
    }
    if (root->checkRemoveSelf == true) {
        countRemove++;
        root->renewChild();
    }
    else {
        for (int i = 0; i < root->nodes.size(); i++) {
            renewFromRoot(root->nodes[i]);
        }

    }
}

int main() {
    int tcases;
    cin >> tcases;
    while(tcases--) {
        countRemove = 0;
        vector<Node*> remove;
        vector<Node*> keep;
        vector<Node*> all;
        int n, m;
        cin >> n >> m;
        Node* root = new Node(0);
        for (int i = 0; i < n; i++) {
            addNode(root, remove, all); 
        }
        for (int i = 0; i < remove.size(); i++) {
            remove[i]->removeInit();
        }
        for (int i = 0; i < m; i++) {
            addNode(root, keep, all);
        }
        if (m == 0) {
            for (int i = 0; i < root->nodes.size(); i++) {
                renewFromRoot(root->nodes[i]);
            }
            for (int i = 0; i < remove.size(); i++) {
                if (remove[i]->checkRemoveSelf == true) {
                    countRemove++;
                }
            }
        } 
        else {
            renewFromRoot(root);
            for (int i = 0; i < remove.size(); i++) {
                if (remove[i]->checkRemoveSelf == true) {
                    countRemove++;
                }
            }
        }
        cout << countRemove << endl;
        delete root;
    }
    return 0;
}