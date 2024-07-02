#include <iostream>
using namespace std;

void print(int rem, int order) {
	int bin[10];
	int i = 0;
	int bit;
	while (rem) {
		bit = rem % 2;
		rem = rem / 2;
		bin[i++] = bit;
	}
	int zeros = order - i;
	for (int j = 0; j < zeros; j++) {
		cout << 0;
	}
	for (int k = i - 1; k >= 0; k--) {
		cout << bin[k];
	}
	cout << '\n';
}

int remainder(int num) {
	num++;
	for (int i = 1; i < 8; i++) {
		int rem = num - pow(2, i) + i;
		if (rem <= pow(2, i) - 2) {
			print(rem, i);
			return 0;
		}
	}
}



int main() {
	char header[248];
	int i = 0;
	char c;
	cout << "Enter Header: " << endl;
	do {
		cin.get(c);
		header[i++] = c;
	} while (c != '\n' && i < 248);
	header[i] = '\0';
	cout << "Character?" << endl;
	c = getchar();
	for (int j = 0; j < i; j++) {
		if (header[j] == c) {
			remainder(j);
		}
	}
	return 0;

}

//int unit(int rem, int order) {
//	char unit[8];
//	char bin[10];
//	int i = 0;
//	int j = 0;
//	int bit;
//	while (rem) {
//		bit = rem % 2;
//		rem = rem / 2;
//		bin[i++] = bit;
//	}
//	int zeros = order - i;
//	for (j; j < zeros; j++) {
//		unit[j] = '0';
//	}
//	for (int k = i - 1, j; k >= 0; k--, j++) {
//		unit[j] = bin[k];
//	}
//	cout << '\n';
//	return 0;
//}