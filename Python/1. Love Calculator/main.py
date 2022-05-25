# 🚨 Don't change the code below 👇
print("Welcome to the Love Calculator!")
name1 = input("What is your name? \n")
name2 = input("What is their name? \n")
# 🚨 Don't change the code above 👆

#Write your code below this line 👇
lower_name1 = name1.lower()
lower_name2 = name2.lower()

name1name2 = lower_name1 + lower_name2

#Count tru
t = name1name2.count("t")
r = name1name2.count("r")
u = name1name2.count("u")
e = name1name2.count("e")

# Count lov
l = name1name2.count("l")
o = name1name2.count("o")
v = name1name2.count("v")

total_true = t + r + u + e
total_love = l + o + v + e

total_string = str(total_true) + str(total_love)
total_int = int(total_string)

if total_int < 10 or total_int > 90:
  print(f"Your score is {total_int}, you go together like coke and mentos.")
elif total_int > 40 and total_int < 50:
  print(f"Your score is {total_int}, you are alright together.")
else:
  print(f"Your score is {total_int}.")