#include<iostream>

int main() {
	int arr[3] = {2,3,4};
	char *p;
	p = (char*)arr;
	std::cout << *p << std::endl;
	p = p + 1;
	std::cout << *p << std::endl;
	return 0;
}
