#include <iostream>
#include <string>
using namespace std;

// Encryption Functions
char encodeDigit(char digit) {
    return (digit - '0' + 3) % 10 + '0';
}

char encodeLowerCase(char ch) {
    return (ch - 'a' + 3) % 26 + 'a';
}

char encodeUpperCase(char ch) {
    return (ch - 'A' + 3) % 26 + 'A';
}

char encodeSpecialChar(char ch) {
    return (ch - 32 + 3) % 15 + 32;
}

// Decryption Functions
char decodeDigit(char digit) {
    return (digit - '0' + 7) % 10 + '0';
}

char decodeLowerCase(char ch) {
    return (ch - 'a' + 23) % 26 + 'a';
}

char decodeUpperCase(char ch) {
    return (ch - 'A' + 23) % 26 + 'A';
}

char decodeSpecialChar(char ch) {
    return (ch - 32 + 12) % 15 + 32;
}

string encodeMessage(string message) {
    string encoded = "";
    for (char ch : message) {
        if (isdigit(ch))
            encoded += encodeDigit(ch);
        else if (islower(ch))
            encoded += encodeLowerCase(ch);
        else if (isupper(ch))
            encoded += encodeUpperCase(ch);
        else
            encoded += encodeSpecialChar(ch);
    }
    return encoded;
}

string decodeMessage(string message) {
    string decoded = "";
    for (char ch : message) {
        if (isdigit(ch))
            decoded += decodeDigit(ch);
        else if (islower(ch))
            decoded += decodeLowerCase(ch);
        else if (isupper(ch))
            decoded += decodeUpperCase(ch);
        else
            decoded += decodeSpecialChar(ch);
    }
    return decoded;
}

int main() {
    string message;
    cout << "Enter message to encode: ";
    cin >> message;

    string encodedMessage = encodeMessage(message);
    cout << "Encoded Message: " << encodedMessage << endl;

    string decodedMessage = decodeMessage(encodedMessage);
    cout << "Decoded Message: " << decodedMessage << endl;

    return 0;
}
