// Enums are compile time constants and do not take runtime memory. 
#include<iostream>

using namespace std;

enum Answers {NO, YES, MAYBE=NO, OFCOURSE};
enum {ZERO=5, FIRST};
enum Named {A=3, B=15};

int main() {
	Answers ans = OFCOURSE;
	Answers another = YES;
	cout << ans << endl << FIRST << endl;
	cout << (OFCOURSE == YES) << endl;
	cout << (NO == YES) << endl;
	Named named = B;
	cout << named << endl << A << endl;
	return 0;
}
