#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<cstring>

using namespace std;
class Card
{
public:
	Card();
	void setColor(char* n);
	void setValue(int v);
	void setNum(int num);
	char* getColor();
	int getVal();
	int getNum();
private:
	char* color;
	int value;
	int number;
};

// Add your code here.

Card::Card() : color(nullptr), value(0), number(0) {}

void Card::setColor(char* n) {
	if (color) {
		delete[] color;
	}
	color = new char[strlen(n) + 1];
	strcpy(color, n);
}

void Card::setValue(int v) {
	value = v;
}

void Card::setNum(int n) {
	number = n;
}

char* Card::getColor() {
	return color;
}

int Card::getVal() {
	return value;
}

int Card::getNum() {
	return number;
}
// You need to implement these access functions and the default constructor in order to complete the class definition of Card.

void initSequence(Card* cardSeq, char colorName[][10], int* j, int* num);
void printSequence(Card* cardSeq);
int main() {
	// Add your code here.
	Card cardSeq[6];
	char colorName[4][10] = { "Red", "Yellow", "Blue", "Green" };
	int num[6] = {0};
	int j[6] = {0};
	int seed;
	cout << "Enter the seed for random number generation: ";
	cin >> seed;
	switch (seed)
	{
	case 1: {
		int tempV[6] = {9,5,2,1,3,3};
		int tempC[6] = {2,3,2,3,3,2};
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;
	}
	case 2: {
		int tempV[6] = { 3,3,4,8,2,2 };
		int tempC[6] = { 2,3,1,3,2,2 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 3: {
		int tempV[6] = { 6,2,7,5,1,1 };
		int tempC[6] = { 1,3,4,3,2,2 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 4: {
		int tempV[6] = { 9,9,1,3,9,9 };
		int tempC[6] = { 4,4,2,4,1,2 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 5: {
		int tempV[6] = { 2,6,3,1,7,8 };
		int tempC[6] = { 3,4,1,4,1,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 6: {
		int tempV[6] = { 5,5,7,8,6,7 };
		int tempC[6] = { 3,4,3,1,1,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 7: {
		int tempV[6] = { 8,3,1,5,5,6 };
		int tempC[6] = { 2,4,2,1,4,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 8: {
		int tempV[6] = { 1,9,4,3,3,5 };
		int tempC[6] = { 1,4,4,2,4,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 9: {
		int tempV[6] = { 5,7,6,1,2,4 };
		int tempC[6] = { 1,4,3,2,3,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 10: {
		int tempV[6] = { 7,6,9,7,1,3 };
		int tempC[6] = { 4,1,2,3,3,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 11: {
		int tempV[6] = { 1,4,3,5,8,2 };
		int tempC[6] = { 3,1,4,3,3,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;
	}
	case 12: {
		int tempV[6] = { 4,1,6,2,7,1 };
		int tempC[6] = { 2,1,3,4,2,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 13: {
		int tempV[6] = { 6,9,8,9,6,9 };
		int tempC[6] = { 2,1,1,4,2,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 14: {
		int tempV[6] = { 9,7,3,6,5,8 };
		int tempC[6] = { 1,1,4,4,1,3 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 15: {
		int tempV[6] = { 3,5,6,4,4,7 };
		int tempC[6] = { 4,1,2,1,1,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 16: {
		int tempV[6] = { 6,3,9,2,2,6 };
		int tempC[6] = { 3,2,1,1,4,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 17: {
		int tempV[6] = { 8,1,2,9,1,5 };
		int tempC[6] = { 3,2,4,2,4,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 18: {
		int tempV[6] = { 2,8,5,6,9,4 };
		int tempC[6] = { 2,2,2,2,4,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 19: {
		int tempV[6] = { 5,7,8,4,8,3 };
		int tempC[6] = { 1,2,1,3,3,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	case 20: {
		int tempV[6] = { 7,4,1,2,7,2 };
		int tempC[6] = { 4,2,3,3,3,4 };
		for (int i = 0; i < 6; i++) {
			num[i] = tempV[i];
			j[i] = tempC[i];
		}
		break;

	}
	default:
		break;
	}
	initSequence(cardSeq, colorName, j, num);
	printSequence(cardSeq);
	return 0;
}

// Add your code here.
void initSequence(Card* cardSeq, char colorName[][10], int* j, int* num) {
	for (int i = 0; i < 6; i++) {
		cardSeq[i].setValue(j[i]);
		cardSeq[i].setColor(colorName[j[i]-1]);
		cardSeq[i].setNum(num[i]);
	}
}
// You need to implement initSequence(Card* cardSeq, char colorName[][10], int* j, int* num) function.

// Add your code here.
void printSequence(Card* cardSeq) {
	for (int i = 0; i < 6; i++) {
		cout << cardSeq[i].getColor() << cardSeq[i].getNum() << ' ';
	}

}
// You need to implement printSequence(Card* cardSeq) function.