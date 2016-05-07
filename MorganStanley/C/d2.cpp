#include<iostream>

int main() {
	void *vp;
	char *cp="JACK";
	vp = cp;
	std::cout << *(char*)vp;
	return 0;
}
