import java.util.Scanner;
public class Main {
    static final float adultmealsmakeprice = 4.75f;
    static final float childmealsmakeprice = 3.75f;
    static final float cookiemakerprice = .50f;
    static final float browniemakeprice = .75f;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter how much adult meals are charged for:");
        float adultcharge = in.nextFloat();
        System.out.println("Enter how much child meals are charged for");
        float childcharge = in.nextFloat();
        System.out.println("Enter how much cookies are charged for");
        float cookiecharge = in.nextFloat();
        System.out.println("Enter how much brownies are charged for:");
        float browniecharge = in.nextFloat();

        System.out.println("How many adult meals was bought:");
        int adultmealsold = in.nextInt();
        System.out.println("How many child meals was bought:");
        int childmealsold = in.nextInt();
        System.out.println("How many cookies was bought");
        int cookiesold = in.nextInt();
        System.out.println("How many brownies was bought");
        int browniesold = in.nextInt();

        float adultmealprofit = (adultcharge - adultmealsmakeprice) * adultmealsold;
        float childmealprofit = (childcharge - childmealsmakeprice) * childmealsold;
        float cookieprofit = (cookiecharge - cookiemakerprice) * cookiesold;
        float browniteprofit = (browniecharge - browniemakeprice) * browniesold;

        float TotalProfit = adultmealprofit + childmealprofit + cookieprofit + browniteprofit;

        System.out.println("The total profit made on all products is " + TotalProfit);
    }
}