#include <bits/stdc++.h>
using namespace std;

void evaluatePostfix(string expression) {
    stack<int> s;
    expression.erase(remove(expression.begin(), expression.end(), ' '), expression.end());
    for (int i = 0; i < expression.length(); i++) {
        if (isdigit(expression[i])) {
            s.push(expression[i] - '0');
        } else {
            int op2 = s.top();
            s.pop();
            int op1 = s.top();
            s.pop();
            switch (expression[i]) {
                case '+':
                    s.push(op1 + op2);
                    break;
                case '-':
                    s.push(op1 - op2);
                    break;
                case '*':
                    s.push(op1 * op2);
                    break;
                case '/':
                    s.push(op1 / op2);
                    break;
            }
        }
    }
    cout << s.top() << endl;
    
    
}

int main() {
    string expression;
    getline(cin, expression);
    while(expression != "") {
        evaluatePostfix(expression);
        getline(cin, expression);
    }
    
}

// void evaluatePostfix(string expression) {
//     stack<int> s;
    
//     for (int i = 0; i < expression.length(); i++) {
//         if (expression[i] != ' ') {

//         }
//     }
// }


// for (int i = 0; i < expression.length(); i++) {
//         if (expression[i] != ' ') {
//             if (isdigit(expression[i])) {
//                 s.push(expression[i] - '0');
//             } else {
//                 int op2 = s.top();
//                 s.pop();
//                 int op1 = s.top();
//                 s.pop();
//                 switch (expression[i]) {
//                     case '+':
//                         s.push(op1 + op2);
//                         break;
//                     case '-':
//                         s.push(op1 - op2);
//                         break;
//                     case '*':
//                         s.push(op1 * op2);
//                         break;
//                     case '/':
//                         s.push(op1 / op2);
//                         break;
//                     case '^':
//                         s.push(pow(op1, op2));
//                         break;
//                 }
//             }
//         }
//     }
//     cout << s.top() << endl;