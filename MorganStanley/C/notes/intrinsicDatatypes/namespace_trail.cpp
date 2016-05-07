// See how namespace works in C++.

#include<iostream>

using namespace std;

namespace first {
	int length = 10;
}
namespace second {
	int length = 20;
}
int main() {
	cout << first::length << endl;	
	cout << second::length << endl;	
	return 0;
}
