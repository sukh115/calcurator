package cal;

import java.util.List;
import java.util.Scanner;

public class challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArithmeticCalculator 객체 생성
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            calculator.setFirstInput(sc);
            if (calculator.getFirstInput().equals("exit")) {
                break;
            }

            // 연산자 입력
            calculator.setOperator(sc);
            if (calculator.getOperator() == 'e') { // 종료 처리
                break;
            }

            // 두 번째 숫자 입력
            calculator.setSecondInput(sc);
            if (calculator.getSecondInput().equals("exit")) {
                break;
            }


            try {
                double num1 = Double.parseDouble(calculator.getFirstInput());
                double num2 = Double.parseDouble(calculator.getSecondInput());

                // 계산 수행
                double result = calculator.calculate(num1, calculator.getOperator(), num2);

                // 결과 출력
                if (!Double.isNaN(result)) {
                    System.out.println("현재 결과 값: " + result);
                }
                System.out.println("전체 결과 내역: " + calculator.getResults());


                System.out.println("현재 결과 목록에서 입력값보다 큰 결과를 출력하려면 숫자를 입력하세요:");
                double filterNum = Double.parseDouble(sc.nextLine());

                // 특정 값보다 큰 결과를 바로 출력
                calculator.printBiggerResultsWithForEach(filterNum);



            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }

        sc.close();
        System.out.println("계산기를 종료합니다.");

    }
}