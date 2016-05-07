namespace my {
	int strcmp(const char* str1, const char* str2) {
		if(*str1 == *str2) 
			while(*++str1 == *++str2 && *str1);
		return *str1-*str2;
	}

	int strlen(const char* str) {
		int length = 0;
		while(*str++) {
			++length;
		}
		return length;
	}

	char * strcat(char *str1, const char *str2) {
		char *str1_p = str1;
		str1_p = str1_p + strlen(str1);
		while(*str1_p++ = *str2++); 
		return str1;
	}

	char * strcpy(char *destination, const char *source) {
		char *temp = destination;
		while(*destination++ = *source++);
		return temp;
	}

	char * toupper(char *str) {
		char *temp = str;
		while(*str) {
			if(int(*str) >= 97 && int(*str) <= 122) {
				*str = char(*str -32);
			}
			str++;
		}
		return temp;
	}
}
