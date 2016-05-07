#include<iostream>
#include"9_4.h"

using namespace std;

extern int local;
extern int global;

int main() {
	global = 50;
	// Is not visible.
	// local = 60;
	
	cout << getGlobal() << endl;
	// Fetch static variables using a function.
	// Scope limited to files.
	cout << getLocal() << endl;
	return 0;
}
