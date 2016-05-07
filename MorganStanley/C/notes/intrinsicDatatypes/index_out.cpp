#include<iostream>
#include<cstring>

using namespace std;

int main() {
	char str[5];
	strcpy(str, "Some random string.");
	cout << str << endl;
	cout << sizeof(str) << endl;

	char str1[2];
	str1[0] = 'a';
	str1[1] = 'b';
	str1[2] = 'c';
	str1[3] = 'c';

	cout << str1 << endl;
	cout << sizeof(str1) << endl;

	const char *str2 = "Another.";
	// strcpy(str, "Another string.");
	cout << str2;
	return 0;
}
