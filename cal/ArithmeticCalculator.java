package cal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {

    // 연산 열거형 정의 (기호로 변경)
    public enum Operation {
        ADD("+", (a, b) -> a.doubleValue() + b.doubleValue()),
        SUBTRACT("-", (a, b) -> a.doubleValue() - b.doubleValue()),
        MULTIPLY("*", (a, b) -> a.doubleValue() * b.doubleValue()),
        DIVIDE("/", (a, b) -> {
            if (b.doubleValue() == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            return a.doubleValue() / b.doubleValue();
        });

        private final String symbol; // 연산 기호
        private final Calculator calculator;

        Operation(String symbol, Calculator calculator) {
            this.symbol = symbol;
            this.calculator = calculator;
        }

        // 연산 실행 메서드
        public double apply(Number a, Number b) {
            return calculator.calculate(a, b);
        }

        // 해당 기호와 매핑된 Operation 반환
        public static Operation fromSymbol(String symbol) {
            for (Operation op : values()) {
                if (op.symbol.equals(symbol)) {
                    return op;
                }
            }
            throw new IllegalArgumentException("유효하지 않은 연산자입니다. (+, -, *, / 만 허용)");
        }

        // 람다식을 위한 함수형 인터페이스
        @FunctionalInterface
        interface Calculator {
            double calculate(Number a, Number b);
        }
    }

    // 연산 결과를 저장하는 리스트
    private final List<Double> results;

    // 생성자
    public ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    // 연산 수행 메서드
    public double calculate(T num1, String operator,T num2) {
        try {
            // 연산자를 Operation으로 변환하여 처리
            Operation operation = Operation.fromSymbol(operator);
            double result = operation.apply(num1, num2);
            results.add(result); // 결과 저장
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("연산 중 오류 발생: " + e.getMessage());
            return Double.NaN; // NaN 반환
        }
    }

    // 최신 연산 결과 반환
    public double getLastResult() {
        if (results.isEmpty()) {
            System.out.println("저장된 결과가 없습니다.");
            return Double.NaN; // 결과가 없으면 NaN 반환
        }
        return results.get(results.size() - 1);
    }

    // 모든 결과 리스트 반환
    public List<Double> getResults() {
        return new ArrayList<>(results); // 원본 보호를 위해 복사된 리스트 반환
    }

    // 가장 먼저 저장된 결과 삭제
    public void removeFirstResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            System.out.println("첫 번째 결과가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 데이터가 없습니다.");
        }
    }

    // 모든 결과 출력
    public void printResults() {
        System.out.println("저장된 결과 목록:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ": " + results.get(i));
        }
    }

    // 입력받은 값보다 큰 결과값들 출력
//    public List<Double> printbiggerResults(double num){
//            return results.stream()
//                .filter(result -> result > num)
//                .collect(Collectors.toList());
//    }
    public void printBiggerResultsWithForEach(double num) {
        results.stream()
                .filter(result -> result > num) // 필터링: num보다 큰 값
                .forEach(result -> System.out.println("필터링된 값: " + result)); // 출력
    }

}