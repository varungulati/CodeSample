#include<iostream>

using namespace std;

enum State {OFF, ON};

bool tog() {
	static bool state;
	state = !state;
	return state;
}

State toggle() {
	static State state;
	state = (state ? OFF : ON);
	return state;
}

int main() {
	cout << tog() << endl;
	cout << tog() << endl;
	cout << tog() << endl;
	cout << tog() << endl;
	cout << toggle() << endl;
	cout << toggle() << endl;
	cout << toggle() << endl;
	cout << toggle() << endl;
	return 0;
}
