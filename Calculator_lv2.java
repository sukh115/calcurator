import java.util.Scanner;

public class Calculator_lv2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // 계산기 객체 생성

        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요. 'exit' 입력 시 종료, 'remove' 입력시 첫번 째 결과 값 삭제 : ");
            String input1 = sc.nextLine();
            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            } // remove 메서드 호출
            if (input1.equalsIgnoreCase("remove")) {
                calculator.removeList();
                System.out.println("삭제 후 현재 값들 : "+ calculator.getResults());
                continue;
            }

            System.out.println("연산자를 입력하세요 (+,-,*,/) 또는 'exit' 입력 시 종료:");
            String operatorInput = sc.nextLine();
            if (operatorInput.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            char operator = operatorInput.charAt(0);

            System.out.println("두 번째 숫자를 입력하세요 또는 'exit' 입력 시 종료:");
            String input2 = sc.nextLine();
            if (input2.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            try {
                double num1 = Double.parseDouble(input1);
                double num2 = Double.parseDouble(input2);

                // 연산 수행
                calculator.calculate(num1, operator, num2);

                // 결과 출력
                System.out.println("현재 결과 값: " + calculator.getLastResult());
                System.out.println("전체 결과 내역: " + calculator.getResults());
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }

        sc.close();
    }
}
