// TO BE IMPLEMENTED.
#include<iostream>
#include<cstring>

using namespace std;

#define ARR_SIZE 2
#define BUFFER 256

int main() {
	char *arr[ARR_SIZE];

	for(int i=0; i < ARR_SIZE; i++) {
		char temp[BUFFER];
		cin >> temp;
		*(arr + i) = new char[strlen(temp)];
		strcpy(*(arr + i), temp);
	}

	int i = 0;
	while(i < ARR_SIZE) {
		cout << *(arr + i) << endl;
		i++;
	}
	
	return 0;
}
