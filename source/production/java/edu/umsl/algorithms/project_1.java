package edu.umsl.algorithms;
import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class project_1  {
    private final static DecimalFormat df4 = new DecimalFormat("#.####");
    public static void main(String[] args) {
        final int ARRAY_SIZE = 200000;
        int[] myArray = new int[ARRAY_SIZE];
        myArray = creatArray(ARRAY_SIZE);
        display_polynomial(myArray);
        Scanner input = new Scanner(System.in);
        char again;
        double x_value;
        System.out.print("\nEnter the value of the variable x ( between 0.0 and 1.0 ): ");
        x_value = input.nextDouble();
        while (x_value < 0 || x_value > 1){
            System.out.println("Invalid number!! "+" You choice must be a double number from 0.0 to 1.0.");
            System.out.print("Enter Your choice: ");
            x_value = input.nextDouble();
        }

        int[] myArray1={1,2,3,4,5,6,7,8,9,10};


        do {
            int user_choice;
            double result;
            user_choice = display_Menu();
            switch (user_choice){
                case 1:
                    long statTime1 = System.currentTimeMillis();
                    result = Method1_Cal(x_value,myArray);
                    long stopTime1 =System.currentTimeMillis();
                    display_result(result,stopTime1 - statTime1);
                    break;
                case 2:
                    long statTime2 = System.currentTimeMillis();
                    result = Method2_Cal(x_value,myArray);
                    long stopTime2 =System.currentTimeMillis();
                    display_result(result,stopTime2 - statTime2);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;

            }




            System.out.println("\nDo you want to run the program again(Y/N): ");
            again = input.next().charAt(0);
        }while (again == 'y' | again == 'Y');



    }

    public static int[] creatArray(int size) {
        int[] Array = new int[size];
        for (int i = 0; i < size; i++) {
            Array[i] = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
        }
        return Array;
    }

    public static void display_polynomial(int[] array) {
        System.out.println("The polynomials:");
        System.out.println(array[0] + " + " + array[1] + "x +" + array[2] + "x^2 +" + array[3] + "x^3 +....+ "
                + array[array.length - 3] + "x^" + (array.length - 3) + " + "
                + array[array.length - 2] + "x^" + (array.length - 2) + " + "
                + array[array.length - 1] + "x^" + (array.length - 1));
        System.out.println("The degree number of the Polynomial: "+ array.length);
    }

    public static int display_Menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nPlease choose one of the three methods to evaluate the polynomial: ");
        System.out.println("1. Method 1: The Straightforward method uses a for-loop.");
        System.out.println("2. Method 2: The Straightforward method uses Power function.");
        System.out.println("3. Method 3: The Horner’s Rule");
        System.out.println("4. Run all Method.");
        System.out.println("0. Terminate  the  program.");
        System.out.print("\nEnter Your choice: ");
        int choice = input.nextInt();
        while (choice < 0 || choice > 4){
            System.out.println("Invalid number!! "+" You choice must be a number from 0 to 4.");
            System.out.print("Enter Your choice: ");
            choice = input.nextInt();
        }
        return choice;
    }

    public static void display_result(double x, long y){
        df4.setRoundingMode(RoundingMode.UP);
        System.out.println("The evaluation result of Method 1: "+ df4.format(x) );
        System.out.println("The execution time in milliseconds: "+ y);

    }

    public static double Method1_Cal(double x, int[] array_polynomial){
        double array_result = 0;
        double coefficients;
        double x_value = 1.0;
        for( int i = 0 ; i < array_polynomial.length; i++ ){
            coefficients = array_polynomial[i];
            for(int j = 0; j < i ; j++){
                coefficients = coefficients * x;
            }
            array_result += coefficients;
        }
        return array_result;
    }

    public static double Method2_Cal(double x, int[] array_polynomial){
        double array_result = 0;
        for( int i = 0 ; i < array_polynomial.length; i++ ){
            array_result += array_polynomial[i]*Math.pow(x,i);
        }
        return array_result;
    }

    public static double Method3_Cal(double x, int [] array_polynomial){

    }


}



