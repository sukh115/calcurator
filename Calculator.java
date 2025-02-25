import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private final List<Double> results; // 연산 결과를 저장하는 리스트

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 연산 수행
    public void calculate(double num1, char operator, double num2) {
        double newResult;

        // 각 연산자를 해당 메서드 호출로 분리
        switch (operator) {
            case '+':
                newResult = add(num1, num2);
                break;
            case '-':
                newResult = subtract(num1, num2);
                break;
            case '*':
                newResult = multiply(num1, num2);
                break;
            case '/':
                try {
                    newResult = divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return; // 연산 수행하지 않고 리턴
                }
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
                return; // 연산 수행하지 않고 리턴
        }

        results.add(newResult); // 결과 저장
    }

    private double add(double num1, double num2) {
        return  num1 + num2;
    }
    private  double subtract(double num1, double num2) {
        return  num1 - num2;
    }
    private  double multiply(double num1, double num2) {
        return  num1 * num2;
    }
    private double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }


    // 최신 연산 결과 반환
    public double getLastResult() {
        if (results.isEmpty()) {
            return 0; // 결과가 없으면 0 반환
        }
        return results.get(results.size() - 1);
    }

    // 모든 결과 리스트 반환
    public List<Double> getResults() {
        return new ArrayList<>(results); // 원본 보호를 위해 새 리스트 반환
    }

    // 가장 먼저 생성된 데이터 삭제
    public void removeList() {
        if(!results.isEmpty()) {
            results.remove(0);
            System.out.println("첫번 째 데이터가 삭제되었습니다.");
        } else {
            System.out.println("삭제 할 데이터가 없습니다.");
        }

    }
}
