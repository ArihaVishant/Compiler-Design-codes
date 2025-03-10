%{
#include <stdio.h>
#include <stdlib.h>
%}

%%
[0-9]+  { printf("Number: %s\n", yytext); }
[\+\-\*/] { printf("Operator: %s\n", yytext); }
[\n]    { return 0; }
.       { printf("Invalid character: %s\n", yytext); }
%%

int main() {
    printf("Enter an expression: ");
    yylex();
    return 0;
}

int yywrap() {
    return 1;
}
