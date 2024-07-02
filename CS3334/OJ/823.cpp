/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 281356
 * Submitted at:  2024-02-27 14:04:11
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    823
 * Problem Name:  Word Review
 */

#include <iostream>
#include <queue>
#include <unordered_map>
#include <string>
#include <algorithm>

using namespace std;

struct Word{
	string w;
	int p;
};

void add(unordered_map<string, int>& check, string& w) {

	if (check.count(w) > 0) {
		// Key exists in the map
		check[w]++;
	}
	else {
		// Key does not exist in the map
		check[w] = 1;
	}
}

void del(unordered_map<string, int>& check, string& w) {
	check[w]--;
	if (check[w] == 0) {
		check.erase(w);
	}
}

int main() {
	int n, m;
	int posLen = 0;
	string word;
	unordered_map<string, int> dict;
	unordered_map <string, int> check;
	//Word pos[100005];
	vector<Word> pos;
	while (cin >> n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			cin >> word;
			dict.insert({ word,0 });
		}
		cin >> m;
		for (int i = 0; i < m; i++) {
			cin >> word;
			if (dict.count(word) > 0) {
				pos.push_back({word,i});
				
				dict[word]++;
				if (dict[word] == 1) {
					count++;
				}
			}
		}
		posLen = pos.size();
		if (count == 0) {
			std::cout << 0 << endl;
			std:: cout << 0 << endl;
		}
		else {
			std::cout << count << endl;
			int lp = 0;
			int rp = 0;
			int qual = 0;
			int res = pos[posLen - 1].p - pos[0].p + 1;
			
			add(check,pos[0].w);
			do {
				while (qual < count && rp < posLen - 1) {
					rp++;
					add(check, pos[rp].w);
					qual = check.size();
				}
				while (qual == count && lp < rp) {
					del(check, pos[lp].w);
					lp++;
					qual = check.size();
					if (qual == count) {
						res = (res < pos[rp].p - pos[lp].p + 1) ? res : pos[rp].p - pos[lp].p + 1;
					}
				}
			} while (rp < posLen - 1);

			check.clear();
			dict.clear();
			pos.clear();

			std::cout << res << endl;
		}
	}
	return 0;
}