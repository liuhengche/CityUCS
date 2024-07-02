#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000000;

class Player {
public:
    queue<int> cards;
    queue<int> afterTrounds;
    int finishRound = MAX;
    bool checkEmpty() {
        return cards.empty();
    }
    

};

int loc(queue<int> deck, int card) {
    int index = 0;
    while(!deck.empty()) {
        if (deck.front() == card) {
            return index;
        }
        deck.push(deck.front());
        deck.pop();
        index++;
    }
    return -1;
}

void ReDeck(queue<int>& deck, int idx, Player& p) {
    queue<int> temp;
    for (int i = 0; i < idx; i++) {
        temp.push(deck.front());
        deck.pop(); 
    }
    while (!deck.empty()) {
        p.cards.push(deck.front());
        deck.pop();
    }
}

void J(queue<int>& deck, Player& p) {
    while(!deck.empty()) {
        p.cards.push(deck.front());
        deck.pop();
    }   
}

int main() {
    int n,m,l,s,t;
    while(cin >> n >> m >> l >> s >> t) {
        if (n == -1 && m == -1 && l == -1 && s == -1 && t == -1) {
            break;
        }
        queue<int> deck;
        vector<Player*> initialPlayers(n);
        vector<Player*> players(n);
        for( int i = 0; i < n; i++) {
            Player p;
            for (int j = 0; j < m; j++) {
                int card;
                cin >> card;
                p.cards.push(card);
            }
            initialPlayers[i] = &p;
            players[i] = &p;
        }

        int round = 1;
        // s is the special card
        while(round <= t) {
            for (int i = 0; i < players.size(); i++) {
                if (deck.empty()) {
                    deck.push(players[i]->cards.front());
                    players[i]->cards.pop();
                }
                else {
                    deck.push(players[i]->cards.front());
                    int curCard = players[i]->cards.front();
                    players[i]->cards.pop();
                    if (curCard == s) {
                        J(deck, *players[i]);    
                    }
                    else {
                        int idx = loc(deck, curCard);
                        if (idx != -1) {
                            ReDeck(deck, idx, *players[i]);
                        }
                    } 
                }
                if (players[i]->checkEmpty()) {
                    players[i]->finishRound = round;
                    players.erase(players.begin() + i);
                }

            }
        }

        for(int i = 0; i < players.size(); i++) {
            players[i]->afterTrounds = players[i]->cards;
        }


        while(!players.empty()) {
             for (int i = 0; i < players.size(); i++) {
                if (deck.empty()) {
                    deck.push(players[i]->cards.front());
                    players[i]->cards.pop();
                }
                else {
                    deck.push(players[i]->cards.front());
                    int curCard = players[i]->cards.front();
                    players[i]->cards.pop();
                    if (curCard == s) {
                        J(deck, *players[i]);    
                    }
                    else {
                        int idx = loc(deck, curCard);
                        if (idx != -1) {
                            ReDeck(deck, idx, *players[i]);
                        }
                    } 
                }
                if (players[i]->checkEmpty()) {
                    players[i]->finishRound = round;
                    players.erase(players.begin() + i);
                }

            }
        }

        for(int i = 0; i < initialPlayers.size(); i++) {
            if (initialPlayers[i]->finishRound <= t) {
                cout << -initialPlayers[i]->finishRound << " ";
            }
            else {
                cout << initialPlayers[i]->finishRound << " ";
            }
        }

        cout << endl;

        for (int i = 0; i < initialPlayers.size(); i++) {
            if (initialPlayers[i]->finishRound <= t) {
                cout << endl;
            }
            else {
                while(!initialPlayers[i]->afterTrounds.empty()) {
                    cout << initialPlayers[i]->afterTrounds.front() << " ";
                    initialPlayers[i]->afterTrounds.pop();
                }
                cout << endl;
            }

        }

        


        
    }
    return 0;
}