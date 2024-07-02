/*****************************************
 * (This comment block is added by the Judge System)
 * Submission ID: 288243
 * Submitted at:  2024-04-22 14:35:00
 *
 * User ID:       2511
 * Username:      57854329
 * Problem ID:    831
 * Problem Name:  Train Stations
 */

#include <bits/stdc++.h>
using namespace std;



class Train {
public:
    vector<int> higherRankStation;
    vector<int> lowerRankStation;
};

class Station {
public:
    vector<int> higherRankTrain;
    vector<int> lowerRankTrain;
};

int findAns(int stationRank[], int n) {
    int high = 0;
    int low = 0;
    for (int i = 0; i < n; i++) {
        if (stationRank[i] > high) {
            high = stationRank[i];
        }
        if (stationRank[i] < low) {
            low = stationRank[i];
        }
    }
    return high - low + 1;
}




int main() {
    int n, m;
    cin >> n >> m;
    vector<Train> trains;
    vector<Station> stations;
    int stationRank[1005] = {0};
    int trainRank[1005] = {0};
    for (int i = 0; i < n; i++) {
        Station station;
        stations.push_back(station);
    }
    for (int i = 0; i < m; i++) {
        Train train;
        trains.push_back(train);
    }
    for (int i = 0; i < m; i++) {
        int numberOfStations;
        int noStopStation;
        int stopStation;
        cin >> numberOfStations;
        for (int j = 0; j < numberOfStations; j++) {
            cin >> stopStation;
            stopStation--;
            if (j != 0) {
                for (int k = noStopStation; k < stopStation; k++) {
                    stations[k].higherRankTrain.push_back(i);
                    trains[i].lowerRankStation.push_back(k);
                }
            }
            trains[i].higherRankStation.push_back(stopStation);
            stations[stopStation].lowerRankTrain.push_back(i);
            noStopStation = stopStation + 1;
        }
    }

    bool isPossible = false;
    while(!isPossible) {
        isPossible = true;
        for (int i = 0; i < m; i++) {
            for (int station: trains[i].lowerRankStation) {
                if (stationRank[station] >= trainRank[i]) {
                    stationRank[station] = trainRank[i] - 1;
                    isPossible = false;
                }
            }
            for (int station: trains[i].higherRankStation) {
                if (stationRank[station] < trainRank[i]) {
                    trainRank[i] = stationRank[station];
                    isPossible = false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int train: stations[i].lowerRankTrain) {
                if (stationRank[i] < trainRank[train]) {
                    trainRank[train] = stationRank[i];
                    isPossible = false;
                }
            }
            for (int train: stations[i].higherRankTrain) {
                if (stationRank[i] >= trainRank[train]) {
                    stationRank[i] = trainRank[train] - 1;
                    isPossible = false;
                }
            }
        }
    }
    cout << findAns(stationRank, n) << endl;
    return 0;
}
