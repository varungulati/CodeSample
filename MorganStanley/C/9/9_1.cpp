#include<iostream>

using namespace std;

int * func() {
	int *num = new int;
	*num = 10;
	return num;
}
int main() {
	int *num = func();
	cout << *num;
	delete num;
	return 0;
}
