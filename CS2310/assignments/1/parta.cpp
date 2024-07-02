#include <iostream>
using namespace std;

bool checkLeap(int y) {
	if (y % 4 == 0 && y % 100 != 0) {
		return true;
	}
	else if (y % 400 == 0) {
		return true;
	}
	else {
		return false;
	}
}

bool checkLeapValid(int y, int m, int d) {
	if ((int)checkLeap == 0) {
		if (m == 2) {
			if (d >= 29) {
				return false;
			}
		}
	}
	else {
		return true;
	}

}

bool checkDateValid(int m, int d) {
	if (m == 4 || m == 6 || m == 9 || m == 11) {
		if (d >= 31)
			return false;
	}
	else if (m == 2) {
		if (d >= 30)
			return false;
	}
	else
		return true;
}

int cal(int num) {
	int sum = 0;
	while (num != 0) {
		sum += num % 10;
		num /= 10;
	}
	return sum;
}


int main() {
	int y, m, d;
	int temp;
	string mmes;
	cout << "Please enter your birth date (yyyy mm dd): " << endl;
	cin >> y;
	cin >> m;
	cin >> d;

	switch (m)
	{
	case 1: mmes = "January"; break;
	case 2: mmes = "February"; break;
	case 3: mmes = "March"; break;
	case 4: mmes = "April"; break;
	case 5: mmes = "May"; break;
	case 6: mmes = "Jue"; break;
	case 7: mmes = "July"; break;
	case 8: mmes = "August"; break;
	case 9: mmes = "September"; break;
	case 10: mmes = "October"; break;
	case 11: mmes = "November"; break;
	case 12: mmes = "December"; break;
	default:
		break;
	}

	if (y >= 1900 && m > 0 && m <= 12 && d > 0 && d <= 31 && checkLeapValid(y, m, d) && checkDateValid(m, d)) {
		if (d == 1) {
			cout << "The given day is 1st " << mmes << " " << y << "." << endl;
		}
		else if (d == 2) {
			cout << "The given day is 2nd " << mmes << " " << y << "." << endl;
		}
		else if (d == 3) {
			cout << "The given day is 3rd " << mmes << " " << y << "." << endl;
		}
		else if (d == 21) {
			cout << "The given day is 21st " << mmes << " " << y << "." << endl;
		}
		else if (d == 22) {
			cout << "The given day is 22nd " << mmes << " " << y << "." << endl;
		}
		else if (d == 23) {
			cout << "The given day is 23rd " << mmes << " " << y << "." << endl;
		}
		else if (d == 31) {
			cout << "The given day is 31st " << mmes << " " << y << "." << endl;
		}
		else {
			cout << "The given day is " << d << "th " << mmes << " " << y << "." << endl;
		}
		//do
		//{
		//	result = cal(d) + cal(m) + cal(y);
		//	result = cal(result);

		//} while (result>=10);
		//cout << "The lucky number is " << result << "." << endl;
		temp = cal(y) + cal(m) + cal(d);
		while (temp >= 10) {
			temp = cal(temp);
		}
		cout << "The lucky number is " << temp << "." << endl;

	}
	else {
		cout << "Error!" << endl;
	}
	return 0;
}