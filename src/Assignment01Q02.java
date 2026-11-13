public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;

        double approxPi = 0;
        double sign;
        int summands = Integer.parseInt(args[0]);
        for (int i = 0; i < summands; i++) {
            sign = (i % 2 == 0 ? 1.0 : -1.0);
            approxPi += sign / (2 * i + 1);
        }
        approxPi *= 4;
        
        System.out.println(approxPi + " " + actualPi);
    }
}
