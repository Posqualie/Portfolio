gals= float(input("Enter the gallons used (-1 to end): "))

miles = float(input("Enter the miles driven: "))

mileage = 0.0

count = 0

while not (gals == -1):

   count += 1

   mileage +=(miles/gals)

   print("The miles/gallon for this tank was "+str(round(miles/gals,6)))

   gals= float(input("Enter the gallons used (-1 to end): "))

   miles = float(input("Enter the miles driven: "))

print("The overall average miles/gallon was "+str(round(mileage/count,6)))