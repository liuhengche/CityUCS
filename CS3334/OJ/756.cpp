/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 281566
 * Submitted at:  2024-02-29 14:19:36
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    756
 * Problem Name:  Max-Heap
 */

#include <iostream>

using namespace std;

void printAll(int* arr, int& size) {
	for (int i = 1; i <= size; i++) {
		cout << i << " is " << arr[i] << endl;
	}
}


void maintainHeap(int* arr, int pos, int& size) {
	//! int lar = pos;
	while (pos <= size) {
		int lar = pos;
		if (pos * 2 <= size && arr[pos * 2] > arr[pos]) {
			lar = pos * 2;
		}
		if (pos * 2 + 1 <= size && arr[pos * 2 + 1] > arr[lar]) {
			lar = pos * 2 + 1;
		}
		if (lar != pos) {
			int temp = arr[pos];
			arr[pos] = arr[lar];
			arr[lar] = temp;
			//printAll(arr, size);
			pos = lar;
		}
		else {
			break;
		}
		
	}
	return;
}



int main() {
	int n;
	while (cin >> n) {
		int arr[100005];
		int size = 0;
		int pos = 0;
		char c;
		for (int i = 0; i < n; i++) {
			cin >> c;
			if (c == 'a') {
				int key;
				cin >> key;
				arr[++size] = key;
				pos = size;
				while (pos > 1 && arr[pos] > arr[pos/2]) {
					int temp = arr[pos];
					arr[pos] = arr[pos / 2];
					arr[pos / 2] = temp;
					pos = pos / 2;
				}
				//printAll(arr, size);
			}
			else if (c == 'p') {
				arr[1] = arr[size--];
				maintainHeap(arr, 1, size);
				//printAll(arr, size);

			}
			else if (c == 'r') {
				int sum = 0;
				for (int j = 1; j <= size; j++) {
					sum += arr[j];
				}
				cout << sum << endl;
			}
		}
	}
	return 0;
}