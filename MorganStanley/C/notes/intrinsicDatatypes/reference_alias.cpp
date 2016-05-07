#include<iostream>

using namespace std;
int main() {
	int i = 10;
	int &ref = i;
	cout << "Original: " << i << endl;
	cout << "Referenced: " << ref << endl;
	return 0;
}
