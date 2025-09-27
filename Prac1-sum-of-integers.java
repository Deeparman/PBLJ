import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers (write done to end) : ");
        while(true){
            String ip = sc.nextLine();
            if(ip.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(ip); 
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input detected, skipping: " + ip);
            }
        }
        int sum = 0;
        for(Integer v : numbers){
            sum += v;
        }
        System.out.println("numbers entered : " + numbers);
        System.out.println("Sum of entered integers: " + sum);
        sc.close();
    }
}
