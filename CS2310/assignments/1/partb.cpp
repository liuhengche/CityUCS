#include <iostream>
#include <cmath>
using namespace std;

int calDigit(int num) {
	int i = 0;
	while (num!=0) {
		num /= 10;
		i++;
	}
	return i;
}

string numTrans(int digit) {
	string result;
	switch (digit)
	{
	case 0: result = "Zero"; break;
	case 1: result = "One"; break;
	case 2: result = "Two"; break;
	case 3: result = "Three"; break;
	case 4: result = "Four"; break;
	case 5: result = "Five"; break;
	case 6: result = "Six"; break;
	case 7: result = "Seven"; break;
	case 8: result = "Eight"; break;
	case 9: result = "Nine"; break;
	}
	return result;
}

int main() {
	int num;
	cout << "Please enter an integer number: ";
	cin >> num;
	cout << endl;
	int bit[10];
	int n = calDigit(num);
	if (num == 0) {
		cout << "No found!" << endl;
	}
	else {
		for (int i = 0; i < n; i++) {
			bit[i] = num % 10;
			num /= 10;
		}
		if (n % 3 == 1) {
			cout << 0 << 0 << bit[n - 1] << " " << numTrans(bit[n - 1]) << endl;
			for (int i = 0; i < n / 3; i++) {
				if (bit[n - 2 - 3 * i] == 0 && bit[n - 3 - 3 * i] == 0 && bit[n - 4 - 3 * i] == 0) {
					continue;
				}
				else {
					cout << bit[n - 2 - 3 * i] << bit[n - 3 - 3 * i] << bit[n - 4 - 3 * i] << " " << numTrans(bit[n - 4 - 3 * i]) << endl;
				}
			}
		}
		else if (n % 3 == 2) {
			cout << 0 << bit[n - 1] << bit[n - 2] << " " << numTrans(bit[n - 2]) << endl;
			for (int i = 0; i < n / 3; i++) {
				if (bit[n - 3 - 3 * i] == 0 && bit[n - 4 - 3 * i] == 0 && bit[n - 5 - 3 * i] == 0) {
					continue;
				}
				else {
					cout << bit[n - 3 - 3 * i] << bit[n - 4 - 3 * i] << bit[n - 5 - 3 * i] << " " << numTrans(bit[n - 5 - 3 * i]) << endl;
				}
			}
		}
		else if (n % 3 == 0) {
			for (int i = 0; i < n / 3; i++) {
				if (bit[n - 1 - 3 * i] == 0 && bit[n - 2 - 3 * i] == 0 && bit[n - 3 - 3 * i] == 0) {
					continue;
				}
				else {
					cout << bit[n - 1 - 3 * i] << bit[n - 2 - 3 * i] << bit[n - 3 - 3 * i] << " " << numTrans(bit[n - 3 - 3 * i]) << endl;
				}
			}
		}
	}
	return 0;
}




//int highestDigit(int num) {
//	int i = 0;
//	while (num >= 10) {
//		num = num - (num % 10) * pow(10, i);
//		i++;
//	}
//	return num;
//}

//int main() {
//	int num;
//	int bit1, bit2, bit3;
//	cout << "Please enter an integer number: ";
//	cin >> num;
//	if (calDigit(num)%3==1) {
//		bit3 = highestDigit(num);
//		cout << 0 << 0 << highestDigit(num) << " " << numTrans(bit3);
//	}
//	else if (calDigit(num) % 3 == 2) {
//		bit3 = highestDigit(num);
//		bit2 = highestDigit(num - (int)(bit3 * pow(10, calDigit(num))));
//	}
//	else if (calDigit(num) % 3 == 0) {
//
//	}
//	return 0;
//}

//int main() {
//	int num;
//	int bit1, bit2, bit3;
//	cout << "Please enter an integer number: ";
//	cin >> num;
//	if (calDigit(num) % 3 == 1) {
//		for (int i = 0; i < calDigit(num) / 3; i++) {
//			bit1 = num % 10;
//			num = num / 10;
//			bit2 = num % 10;
//			num = num / 10;
//			bit3 = num % 10;
//			num = num / 10;
//			if (bit1 == 0 && bit2 == 0 && bit3 == 0) {
//				continue;
//			}
//			else {
//				cout << bit3 << bit2 << bit1 << " " << numTrans(bit1) << endl;
//			}
//		}
//		bit1 = num % 10;
//		cout << 0 << 0 << bit1 << " " << numTrans(bit1) << endl;
//	}
//	else if (calDigit(num) % 3 == 2) {
//		for (int i = 0; i < calDigit(num) / 3; i++) {
//			bit1 = num % 10;
//			num = num / 10;
//			bit2 = num % 10;
//			num = num / 10;
//			bit3 = num % 10;
//			num = num / 10;
//			if (bit1 == 0 && bit2 == 0 && bit3 == 0) {
//				continue;
//			}
//			else {
//				cout << bit3 << bit2 << bit1 << " " << numTrans(bit1) << endl;
//			}
//		}
//		bit1 = num % 10;
//		num = num / 10;
//		bit2 = num % 10;
//		cout << 0 << bit2 << bit1 << numTrans(bit1) << endl;		
//	}
//	else if (calDigit(num) % 3 == 0) {
//		for (int i = 0; i < calDigit(num) / 3; i++) {
//			bit1 = num % 10;
//			num = num / 10;
//			bit2 = num % 10;
//			num = num / 10;
//			bit3 = num % 10;
//			num = num / 10;
//			if (bit1 == 0 && bit2 == 0 && bit3 == 0) {
//				continue;
//			}
//			else {
//				cout << bit3 << bit2 << bit1 << " " << numTrans(bit1) << endl;
//			}
//		}
//
//	}
//	return 0;
//}