#include<iostream>

using namespace std;

int main() {
	int *arr = new int[2];
	//arr = {10, 20, 30, 40, 50};
	*arr = 10;
	*(arr + 1) = 20;
	cout << arr[0] << endl;
	cout << arr[1] << endl;
	delete arr;
	return 0;
}
