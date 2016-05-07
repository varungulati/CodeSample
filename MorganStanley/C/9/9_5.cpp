#include<iostream>
#include<cstring>

using namespace std;

#define ARR_SIZE 2
#define BUFFER 256

int main() {
	char **arr = new char*[ARR_SIZE];

	for(int i=0; i < ARR_SIZE; i++) {
		char *temp = new char[BUFFER];
		cin >> temp;
		*(arr + i) = new char[strlen(temp)];
		*(arr + i) = temp;
	}

	int i = 0;
	while(i < ARR_SIZE) {
		cout << *(arr + i) << endl;
		i++;
	}
	while(*arr) {
		cout << *(arr++) << endl;
	}
	
	return 0;
}
