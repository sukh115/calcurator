package cal;

import java.util.Scanner;

public class challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArithmeticCalculator 객체 생성
        ArithmeticCalculator calculator = new ArithmeticCalculator();

        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요. 'exit' 입력 시 종료, 'remove' 입력 시 첫 번째 결과 삭제:");
            String input1 = sc.nextLine();

            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            if (input1.equalsIgnoreCase("remove")) {
                calculator.removeFirstResult();
                System.out.println("삭제 후 현재 결과 리스트: " + calculator.getResults());
                continue;
            }

            System.out.println("연산자를 입력하세요 (+, -, *, /) 또는 'exit' 입력 시 종료:");
            String operator = sc.nextLine();

            if (operator.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.println("두 번째 숫자를 입력하세요 또는 'exit' 입력 시 종료:");
            String input2 = sc.nextLine();
            if (input2.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            try {
                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);

                // 계산 수행
                double result = calculator.calculate(num1, operator, num2);

                // 결과 출력
                if (!Double.isNaN(result)) {
                    System.out.println("현재 결과 값: " + result);
                }
                System.out.println("전체 결과 내역: " + calculator.getResults());
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }

        sc.close();
    }
}