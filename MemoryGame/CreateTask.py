import random as rand 
import tkinter as tk

root = tk.Tk()
root.geometry("550x300")
root.title("Game Screen")

startFrame = tk.Frame(root)
numbersFrame = tk.Frame(root)
gameFrame = tk.Frame(root)
resultsFrame = tk.Frame(root)

startFrame.grid(row=0, column=0, sticky = "news")
numbersFrame.grid(row=0, column=0, sticky = "news")
gameFrame.grid(row=0, column=0, sticky = "news")
resultsFrame.grid(row=0, column=0, sticky = "news")

numbersFrame.lower()
gameFrame.lower()
resultsFrame.lower()

list_of_numbers = []
five_numbers = []

# Variables for Frame 3 (gameFrame)
random_number = tk.StringVar()
user_answer = tk.StringVar()
round = 0
total_points = 0
points_per_question = []

# Creating Lists
for element in range(1, 21):
  list_of_numbers.append(element)

def numbers_picked():
  theRange = 19
  for item in range(5):
    index = rand.randint(1, theRange)
    five_numbers.append(list_of_numbers[index])
    list_of_numbers.pop(index)
    theRange -= 1
    
numbers_picked()

# Random Number
def pick_random_number(): 
  number = rand.randint(1,20)
  return number

# Frame 1 (startFrame)
def showNumbersFrame():
  numbersFrame.lower()
  
def start():
  startFrame.lower()
  root.after(3000, showNumbersFrame)

btn_start = tk.Button(startFrame, text = "Click here to start!", command = start)
btn_start.pack()
lbl_instructions1 = tk.Label(startFrame, text = "On the next screen you will see 5 numbers for 3 seconds. \n You will then see a series of numbers \n and you will either click yes or no based on \n if you remember that number being in the first 5 numbers that you saw. ")
lbl_instructions1.pack()
lbl_instructions2 = tk.Label(startFrame, text = "")
lbl_instructions2.pack()

# Frame 2 (numbersFrame)
lbl_list = tk.Label(numbersFrame, text = five_numbers)
lbl_list.pack()  

# Frame 3 (gameFrame)
def yes():
  user_answer.set("Yes")
  handleYesNo(user_answer)

def no():
  user_answer.set("No")
  handleYesNo(user_answer)

def handleYesNo(user_answer):
  global round
  global lbl_number
  global total_points
  global points_per_question
  if int(random_number.get()) in five_numbers:
    answer = "Yes"
  else:
    answer = "No"
  
  points = 0
  if (answer == "Yes" and answer == user_answer.get()):
    points = 2
    total_points += 2
  if (answer == "No" and answer == user_answer.get()):
    points = 1
    total_points += 1
  round += 1
  points_per_question.append(points)
  
  if round < 10:
      random_number.set(pick_random_number())
      lbl_number.config(text = random_number.get())
  if round == 10:
    gameFrame.lower()
    lbl_results.config(text = "You got " + str(total_points) + " points")
    details = "Points earned per question : "
    for item in points_per_question:
      details = details + "  " + str(item)
    lbl_results_details.config(text = details)    

random_number.set(pick_random_number())
lbl_number = tk.Label(gameFrame, text = random_number.get())
lbl_number.pack()
btn_yes = tk.Button(gameFrame, text = "Yes", command = yes)
btn_yes.pack()
btn_no = tk.Button(gameFrame, text = "No", command = no)
btn_no.pack()

#Frame 4 (resultsFrame)
lbl_results = tk.Label(resultsFrame, text = "You got " + str(total_points) + " points")
lbl_results.pack()
lbl_results_details = tk.Label(resultsFrame, text = "")
lbl_results_details.pack()

root.mainloop()
