public class Assignment01Q03 {
    public static void main(String[] args) {
        final int x = Integer.parseInt(args[0]);
        if (x <= 0 || x > 46) {
            System.out.println("Please enter a positive integer less than or equal to 46.");
            return;
        }

        System.out.println("The first " + x + " Fibonacci numbers are:");
        
        int numOdd = 0;
        int prev = 1;
        int curr = 1;
        for (int i = 0; i < x; i++) {
            System.out.print(prev);

            if (prev % 2 != 0)
                numOdd++;
            if (i < x - 1) 
                System.out.print(" "); // Make sure we don't print a trailing space

            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
