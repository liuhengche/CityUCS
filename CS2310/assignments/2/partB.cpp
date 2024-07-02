#include <iostream>
#include <string>
using namespace std;

int adder(int len) {
	int result = 0;
	for (int i = 1; i < len; i++) {
		result = result + pow(2, i) - 1;
	}
	return result;
}

int binToDec(string seg, int len) {
	int dec = 0;
	for (int i = 0; i < len; i++) {
		if (seg[i] == '1') {
			dec = dec + 1 * pow(2, len - i - 1);
		}
		else if (seg[i] == '0') {
			dec = dec + 0 * pow(2, len - i - 1);
		}
	}
	return dec;
}

int main() {
	int pos = 0;
	int len = 3;
	int idx = 0;
	char header[248];
	char c;
	int i = 0;
	string start;
	string code;
	string seg;
	cout << "Enter Header:" << endl;
	do {
		cin.get(c);
		header[i++] = c;
	} while (c != '\n' && i < 248);
	header[i] = '\0';
	cout << "Enter code: " << endl;
	cin >> code;
	start = code.substr(0, 3);
	while (start != "000") {
		start = code.substr(pos, 3);
		pos += 3;
		len = binToDec(start, 3);
		seg = code.substr(pos, len);
		while (binToDec(seg, len) != (pow(2, len) - 1)) {
			idx = binToDec(seg, len) + adder(len);
			cout << header[idx];
			pos += len;
			seg = code.substr(pos, len);
		}
		pos = pos + len;
	}
	return 0;
}