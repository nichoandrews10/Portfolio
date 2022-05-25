rock = '''
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
'''

paper = '''
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
'''

scissors = '''
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
'''

#Write your code below this line 👇

import random

user = input("What do you choose? Type 0 for Rock, 1 for Paper or 2 for Scissors.\n")

computer = random.randint(0, 2)

if user == "0":
  print(rock)
  print("\nComputer Choose")
  if computer == 0:
    print(rock)
    print("Draw")
  elif computer == 1:
    print(paper)
    print("You Lose")
  elif computer == 2:
    print(scissors)
    print("You Win")

elif user == "1":
  print(paper)
  print("\nComputer Choose")
  if computer == 0:
    print(rock)
    print("You Win")
  elif computer == 1:
    print(paper)
    print("Draw")
  elif computer == 2:
    print(scissors)
    print("You Lose")
  
elif user == "2":
  print(scissors)
  print("\nComputer Choose")
  if computer == 0:
    print(rock)
    print("You Lose")
  elif computer == 1:
    print(paper)
    print("You Win")
  elif computer == 2:
    print(scissors)
    print("Draw")