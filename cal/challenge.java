package cal;

import java.util.List;
import java.util.Scanner;

public class challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ArithmeticCalculator 객체 생성
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

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

/*                System.out.println("입력 값 보다 더 큰 숫자 확인하기(skip시 건너뛰기)");
                String filterInput = sc.nextLine();

                if (!filterInput.equalsIgnoreCase("skip")) {
                    try {
                        double filterNum = Double.parseDouble(filterInput);
                        List<Double> biggerResults = calculator.printbiggerResults(filterNum);
                        System.out.println("입력값보다 큰 결과들: " + biggerResults);
                    } catch (NumberFormatException e) {
                        System.out.println("올바른 숫자를 입력하세요.");
                    }
                }*/
                System.out.println("현재 결과 목록에서 입력값보다 큰 결과를 출력하려면 숫자를 입력하세요:");
                double filterNum = Double.parseDouble(sc.nextLine());

                // 특정 값보다 큰 결과를 바로 출력
                calculator.printBiggerResultsWithForEach(filterNum);



            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }

        sc.close();
    }
}