#include<iostream>

using namespace std;
int main() {
	int i = 0;
	const char *arr = "Varun";
	char s1[10] = "AAA";
	char s2[10] = "BB";
	while(*arr++) {
		std::cout <<  *arr << "-";
	}
	while(*s2++ = *s1++) {
		cout << s2;
	}
	return 0;
}
