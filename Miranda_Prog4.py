inp = input('Are you a student(S), Veteran and Student(SV), or none(N)')


price = float(input('Enter the purchase price: '))

if inp.lower() == "s":
    price -= (price * 0.07)
elif inp.lower() == "sv":
    price -= (price * 0.12)

print(price)
month_number = 1
int_rate = 0.15
down_payment = price * .10
monthly_payment = (price-down_payment) * .05

current_balance = price-down_payment

print('{:<15s} {:<20s} {:<20s} {:<20s} {:<20s} {:<20s}'.format('Month','Starting Balance','Interest to Pay',
      'Principal to Pay','Payment','Ending Balance'))

while current_balance > 0:

    if current_balance < monthly_payment:

        int_amt = 0

        principal = current_balance

        payment = current_balance
        ending_balance = 0
    else:

        int_amt = current_balance*(int_rate/15)

        principal = monthly_payment-int_amt

        payment = int_amt+principal

        ending_balance = current_balance-principal

    print('{:<15d} {:<20.2f} {:<20.2f} {:<20.2f} {:<20.2f} {:<20.2f}'.format(month_number, current_balance, int_amt,
                                                                             principal, payment, ending_balance))

    current_balance = ending_balance
    month_number += 1

