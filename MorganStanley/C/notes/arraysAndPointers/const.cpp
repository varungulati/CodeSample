#include<iostream>

using namespace std;

int main() {
	const char* str = "Something";
//	str[0] = "A";
	str = "Another";
	cout << str << endl;

	char *const ptr = "Const pointer";
	// ptr[0] = "A";
	// cout << ptr << endl;
	
	int i = 5, j = 10;
	j++;
	int *const x = &i;
	// x = &j;
	*x = j;
	cout << *x << endl;
	
	const int* p = &i;
	p = &j;
	cout << *p << endl;
	return 0;
}
