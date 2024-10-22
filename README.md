# Flames
FLAMES is a popular game played by teenagers as a way to deal with the unpredictability of their romantic relationships. This repository holds the Kotlin/Android implementation of the algorithm written to play this game.


# How To Play
The rules of the FLAMES game can be described as follows. Take the names of two people, usually of opposite genders, and cross out all the common letters in the two names. Count the total number of letters that remain in both names after this procedure. Let this number of mismatches be m.

Now write FLAMES on a piece of paper. Count through the letters of this string starting from F to S and cycling back through F till m letters have been counted. At this point, cross out the letter in FLAMES at which the count ends (say A). Restart counting from the next letter (here M) through the string FLMES. Repeat this till ﬁve of the letters of FLAMES have been crossed out and only one letter remains.

The final letter that remains is the predicted nature of the relationship between the two people whose names were initially chosen, where F = “Friend”, L = “Love”, A = “Affection”, M = “Marriage”, E = “Enemy”, S = “Sibling”. The rationale (or the lack of it) for these interpretations is beyond the scope of this repository.

# Algorithm
### Step 1: ReadName Procedure

Read two strings from the user and store it in <b>yourName</b> & <b>partnerName</b>, respectively
Remove spaces from both strings, if any
Convert both strings to lowercase (or uppercase)
Calculate the length of both strings and store in <b>yourNameLength</b> & <b>partnerNameLength</b> respectively

### Step 2: EliminateCommonCharacters Procedure

FOR i in every character in yourName till yourNameLength
1. FOR j in every character in partnerName till partnerNameLength
IF a character yourName[i] is equal to a character in partnerName[j] THEN
Remove the character from the strings yourName and partnerName
Break the inner loop as soon as a match is found, otherwise all instances of that character will be deleted
END IF 2. END FOR
END FOR
Concatenate both strings and store it in completeName and calculate the length of it to be stored in completeNameLength

### Step 3: FlamesCalculation Procedure

Declare a string "FLAMES" with the variable FLAMES and store it's length of 6 in a variable flamesLength
Declare a variable index to store the index of the character to be striked out
WHILE length of FLAMES is not equal to 1, do the following:
1. index <- completeNameLength % flamesLength
2. IF (index == 0) THEN
3. Remove the last character of FLAMES
4. ELSE
5. Remove the character that index is currently pointing toward in FLAMES
6. Extract a substring of FLAMES from (index) to end, and another substring from start to (index). Concatenate the two substrings and overwrite FLAMES
5. END IF
6. Decrement flamesLength by 1
END WHILE
At the end of the WHILE loop, the prediction will be the last remaining character of the FLAMES, which we will store in flamesResult
Step 4: DisplayResult Procedure

IF flamesResult is
1. F, THEN
display "yourName & partnerName are friends!"
2. L, THEN
display "yourName & partnerName are lovers!"
3. A, THEN
display "yourName & partnerName are affectionate to each other!"
4. M, THEN
display "yourName & partnerName are or will be married!"
5. E, THEN
display "yourName & partnerName are enemies!"
6. S, THEN
display "yourName & partnerName are or are like siblings!"
7. END IF


# Screenshots

<img src="screenshots/flame1.png" >
<img src="screenshots/flam2.png" >
<img src="screenshots/flame3.png" >
