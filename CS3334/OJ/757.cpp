/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 281398
 * Submitted at:  2024-02-28 13:35:55
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    757
 * Problem Name:  Huffman Code
 */

#include <iostream>
#include <queue>

int main() {
	int n;
	while (std::cin >> n) {
		int f;
		int res = 0;
		std::priority_queue<int> q;
		for (int i = 0; i < n; i++) {
			std::cin >> f;
			q.push(-f);
		}
		
		while (q.size() != 1) {
			int x = q.top();
			q.pop();
			int y = q.top();
			q.pop();
			res = res + x + y;
			q.push(x+y);
			//std::cout << res << std::endl;
		}
		std::cout << -res << std::endl;
	}
	return 0;
}