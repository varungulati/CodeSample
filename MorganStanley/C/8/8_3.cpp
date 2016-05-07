#include<iostream>
#include"mystring.h"
#include<cstring>

using namespace std;

const char *PASSWORD = "HASTALAVISTA";

int main() {
	char *pass1 = new char[10];
	char *pass2 = new char[10];
	char *pass3 = new char[10];
	cout << "Enter password 1: ";
	cin >> pass1;
	pass1 = my::toupper(pass1);
	cout << "Enter password 2: ";
	cin >> pass2;
	pass2 = my::toupper(pass2);
	cout << "Enter password 3: ";
	cin >> pass3;
	pass3 = my::toupper(pass3);

	char full_pass[40] = "";
	my::strcat(full_pass, pass1);
	my::strcat(full_pass, pass2);
	my::strcat(full_pass, pass3);

	if(my::strcmp(full_pass, PASSWORD) == 0) {
		cout << "You get coffee!!" << endl;
	} else {
		cout << "Wrong password" << endl;
	}
	return 0;
}
