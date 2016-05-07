#include<iostream>
#include<cstring>
using namespace std;

int main() {
	char *title1 = "Now is the time";
	const char *title2 = "For all good men";
	char * const title3 = "To come to the aid";
	const char * const title4 = "Of the party.";

	title1 = title2;
	title1 = title3;
	title1 = title4;

	return 0;
}
