#Created by Kurt Wimer on 4/9/2018
#Problem Statement found here https://www.reddit.com/r/dailyprogrammer/comments/87rz8c/20180328_challenge_355_intermediate_possible/

#Purpose: Determine if enough ingredients exist to make the desired pies
def enoughIngredients(pump, app, IngredientArray):
	if (pump > IngredientArray[0]) | ((3*pump + 4*app) > IngredientArray[2]) | ((4*pump+3*app)> IngredientArray[3]) | ((3*pump+2*app)>IngredientArray[4]) | (app > IngredientArray[1]):
		return False
	else:
		return True

#Finds and prints the maximum number of pies given  a string of ingredients each number is a non-negative integer seperated by ",". 
#The numbers represent the number of synthetic pumpkin flavouring, apples, eggs, milk and sugar you have
def maxPies(dataString):
	#parse the string
	IngredientArray = dataString.split(",") #pumpkinFlavor, apple, eggs, milk, sugar
	#conver the strings into int's
	for x in range(5):
		IngredientArray[x] = int(IngredientArray[x])
	#create local variables to store pie numbers
	maxPump = 0
	maxApple = 0
	curPump = 0
	curApp = 0

	while enoughIngredients(curPump,0,IngredientArray):
		curApp = 0
		if (curPump+curApp) > (maxPump + maxApple):
			maxPump = curPump
			maxApple = 0
		curApp = IngredientArray[1] #start at number of apples an work down
		while (curApp>=0) & (False == enoughIngredients(curPump,curApp,IngredientArray)):
			curApp -=1
		if (curPump+curApp) > (maxPump + maxApple):
			maxPump = curPump
			maxApple = curApp
		curPump +=1
	print(str(maxPump) + " pumpkin pies and " + str(maxApple) +" apple pies")

#Test the code
print("Test Results note that the solution can be any combination of pies that reach the same number as long as thier are enough ingredients")
print("Input: 10,14,10,42,24")
print("Result: ")
maxPies("10,14,10,42,24")
print("Expected: 3 pumpkin pies and 0 apple pies")

print("Input: 12,4,40,30,40")
print("Result: ")
maxPies("12,4,40,30,40")
print("Expected: 5 pumpkin pies and 3 apple pies")

print("Input: 12,14,20,42,24")
print("Result: ")
maxPies("12,14,20,42,24")
print("Expected: 5 pumpkin pies and 1 apple pies")