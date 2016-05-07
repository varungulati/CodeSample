#include<iostream>
#include"9_4.h"

using namespace std;

static int local = 10;
int global = 20;

int getLocal() {
	return ++local;
}
int getGlobal() {
	return ++global;
}
