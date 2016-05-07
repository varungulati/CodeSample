#include<iostream>
#include<cstring>
#include"mystring.h"

void test_strcmp() {
	char str1[10] = "First";
	char str2[10] = "Second";
	char str3[10] = "ABC";
	char str1_equal[10] = "First";
	std::cout << "===========================================" << std::endl;
	std::cout << "Testing strcmp!" << 
		"Status of case 1: " <<
		(std::strcmp(str1, str2) < 0 && my::strcmp(str1, str2) < 0) << std::endl <<
		"Status of case 2: " <<
		(std::strcmp(str2, str1) > 0 && my::strcmp(str2, str1) > 0) << std::endl <<
		"Status of case 3: " <<
		(std::strcmp(str1, str1_equal) == 0 && my::strcmp(str1, str1_equal) == 0) << std::endl;
	std::cout << "===========================================" << std::endl;
}

void test_strlen() {
	char str1[10] = "First";
	char str2[10] = "Second";
	char str3[10] = "ABC";
	char str1_equal[10] = "First";
	std::cout << "===========================================" << std::endl;
	std::cout << "Testing strlen!" << std::endl <<
		"Status of case 1: " <<
		(std::strlen(str1) == my::strlen(str1)) << std::endl <<
		"Status of case 2: " <<
		(std::strlen(str2) == my::strlen(str2)) << std::endl <<
		"Status of case 3: " <<
		(std::strlen(str3) == my::strlen(str3)) << std::endl;
	std::cout << "===========================================" << std::endl;
}

void test_strcat() {
	char str1[10] = "First";
	char str2[10] = "Second";
	char str1_temp[10] = "First";
	char str2_temp[10] = "Second";
	std::strcat(str1_temp, str2_temp);
	my::strcat(str1, str2);
	std::cout << "===========================================" << std::endl;
	std::cout << "Testing strcat!" << std::endl << 
		"Status of case 1: " <<
		(std::strcmp(str1_temp, str1) == 0) << std::endl;
	std::cout << "===========================================" << std::endl;
}

// TODO: Fix it.
void test_strcpy() {
	char str1[10] = "First";
	char str2[10] = "Second";
	char str3[10] = "ABC";
	char str1_equal[10] = "First";
	std::cout << "===========================================" << std::endl;
	std::cout << "Testing strcpy!" << std::endl << 
		"Status of case 1: " <<
		(std::strcmp(std::strcpy(str1, str2), my::strcpy(str1, str2)) == 0) << std::endl;
	std::cout << "===========================================" << std::endl;
}

void test_toupper() {
	char str1[10] = "FirSt";
	char str2[10] = "FIRST";
	std::cout << "===========================================" << std::endl;
	std::cout << "Testing toupper!" << std::endl << 
		"Status of case 1: " <<
		(std::strcmp(my::toupper(str1), str2) == 0) << std::endl;
	std::cout << "===========================================" << std::endl;
}

int main() {
	test_strcmp();
	test_strlen();
	test_strcat();
	test_strcpy();
	test_toupper();
	return 0;
}
