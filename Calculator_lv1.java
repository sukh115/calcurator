import java.util.Scanner;

public class Calculator_lv1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            System.out.println("양의 정수를 입력해주세요 또는 'exit'입력시 종료 :");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                return;
            }
            int a = Integer.parseInt(input);
        while (true) {
            System.out.println("연산자를 입력하세요 (+,-,*,/) 또는 'exit'입력시 종료 :");
            String input2 = sc.nextLine();
            if (input2.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            char operator = input2.charAt(0);

            System.out.println("다음 양의 정수를 입력해주세요 또는 'exit'입력시 종료 :");
            String input3 = sc.nextLine();
            if (input3.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            int b = Integer.parseInt(input3);

            switch (operator) {
                case '+':
                    a += b;
                    break;
                case '-':
                    a -= b;
                    break;
                case '*':
                    a *= b;
                    break;
                case '/':
                    if (b != 0) {
                        a /= b;
                    } else {
                        System.out.println("0으로 나눌 수 없습니다.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }
            System.out.println("결과 값 : " + a);
        }
        sc.close();
    }
}
