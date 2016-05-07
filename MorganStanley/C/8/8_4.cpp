#include<iostream>
#include<cstring>
using namespace std;

int main() {
	char *title1 = "Now is the time";
	const char *title2 = "For all good men";
	char * const title3 = "To come to the aid";
	const char * const title4 = "Of the party.";

//	title1 = title2;
	title1 = title3;
//	title1 = title4;

	title2 = title1;
	title2 = title3;
	title2 = title4;

//	title3 = title1;
//	title3 = title2;
//	title3 = title4;

//	title4 = title1;
//	title4 = title2;
//	title4 = title3;

	strcpy(title1, title2);
	strcpy(title1, title3);
	strcpy(title1, title4);

//	strcpy(title2, title1);
//	strcpy(title2, title3);
//	strcpy(title2, title4);

	strcpy(title3, title1);
	strcpy(title3, title2);
	strcpy(title3, title4);

//	strcpy(title4, title1);
//	strcpy(title4, title2);
//	strcpy(title4, title3);
	return 0;
}
