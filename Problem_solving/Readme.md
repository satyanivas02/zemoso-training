# Character Encryption and Decryption System

## Overview

This project implements a custom character encryption and decryption system that allows secure communication between two parties. The system can encode and decode messages containing digits, special characters, lowercase, and uppercase alphabets.

## Problem Statement

The challenge is to build an Encryption and Decryption algorithm that encodes all the digits, special characters, lower and upper case alphabets.

## Features

- **Encrypts** digits, lowercase letters, uppercase letters, and special characters.
- **Decrypts** messages back to their original form.
- Wrap-around logic to handle the end of character ranges.

## How It Works

### Encryption

- **Digits (0-9)**: Shift each digit by 3 positions.
- **Lowercase Letters (a-z)**: Shift each letter by 3 positions.
- **Uppercase Letters (A-Z)**: Shift each letter by 3 positions.
- **Special Characters**: Shift each special character by 3 positions.

### Decryption

- **Digits (0-9)**: Shift each digit back by 3 positions.
- **Lowercase Letters (a-z)**: Shift each letter back by 3 positions.
- **Uppercase Letters (A-Z)**: Shift each letter back by 3 positions.
- **Special Characters**: Shift each special character back by 3 positions.

## Example

Enter message to encode: Hello123!
Encoded Message: Khoor456$
Decoded Message: Hello123!
