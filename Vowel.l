%{
#include <stdio.h>
%}

%%
[aeiouAEIOU] { printf("Vowel: %s\n", yytext); }
[^aeiouAEIOU\n] { printf("Not a vowel: %s\n", yytext); }

%%

int main() {
    printf("Enter a string: ");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
