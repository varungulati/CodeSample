#include<iostream>

using namespace std;

void func(char *str) {
	// Invalid
//	str = "Another";
//	*str = "H";
	char temp[10] = "abc";
	*str = *temp;
	// Valid because it is on stack. Makes a copy on the stack.
	str[0] = 'g';
	*str = 'p';
}
void func1(char *str, const char *abc) {
	char *str1 = str;
	str = str + 2;
	*str = *abc;
}

int main() {
	char str[10] = "String";
	func(str);
	cout << str << endl;

	char *temp = "Another";
	// Invalid because it is in text segment. Which is read only.
	// *temp = 'c';
	cout << temp;

	const char *abc = "ABC";
	// func1(temp, abc);
	// *temp = *abc;
	return 0;
}
