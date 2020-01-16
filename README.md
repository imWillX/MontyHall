# Monty Hall Synopsis

This code simulates the monty hall problem. Monty Hall is a game show where contestants have the ability to win the car.
Contestants can choose from three closed doors, two with goats and one with a cars. After one's choice, Monty Hall
will reveal a door that you did not choose and has a goat. Now that you know where one of the goats are, Monty Hall
allows you choose: Do you want to stick with your choice or do you want to change to the other door.

## The problem

On our first trial, we have a 33% chance of selecting the car. After, Monty Hall reveals one of the doors, intuitively, 
one can say that there is a 50% chance from choosing a goat from a car. This is not the case as picking the other choice
actually gives us double the chance: 66%. 

## Why? 

We have a 1/3 chance of selecting the car on our first pick and 2/3 chance of selecting a goat. 

```$xslt
Let's say that you have choices A, B and C and choice A has the car.
1) You choose A and Monty can choose either B or C to show you. If you switch, you lose.
2) You choose B and Monty can only show you C. If you switch, you win.
3) You choose C and Monty can only show you B. If you switch, you win.

Thus, you have a 2/3 chance of winning.
```

The chance increases because Monty provides you with more information. It would be 50-50 if they were equally likely 
to occur but now that you have more information, switching would give you 66% chance of winning.

## Simulation

```$xslt
n = 1000000
Game Won (No Choice Change) Win Rate: 0.333289
Game Won (Choice Change) Win Rate: 0.666972
```