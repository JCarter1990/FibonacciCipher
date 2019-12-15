# FibonacciCipher
A cipher using the fibonacci sequence to encrypt text.

This cipher takes a normal string and an integer as the key then replaces each letter with a number in the sequence.

# Sample

"a little mole lives in a hole" (without quotes) and with a key of 13

Would be changed to:

#233#46368#10946#2178309#2178309#46368#1597#75025#196418#46368#1597#46368#10946#5702887#1597#1346269#10946#121393#233#6765#196418#46368#1597

# Issues

Since the code only checks for lowercase strings you cant include uppercase letters or any grammar.

My original intention was to have the program check from a file but since this is a demo i changed my mind, therefore a string encrypted
by the program will decrypt fine if you close then reopen the program it will just have no spaces in the string since they are stored in
the program itself.
