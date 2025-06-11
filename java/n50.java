import java.io.*;
import java.util.*;
import java.util.regex.*;

public class n50 {
    private static final String HISTORY_FILE = "calculator_history.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Вычислить уравнение");
            System.out.println("2 - Показать историю вычислений");
            System.out.println("3 - Выход");
            System.out.print("> ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    calculateEquation(scanner);
                    break;
                case "2":
                    showHistory();
                    break;
                case "3":
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
    
    private static void calculateEquation(Scanner scanner) {
        System.out.print("Введите уравнение: ");
        String equation = scanner.nextLine().trim();
        
        try {
            double result = evaluateExpression(equation);
            // Проверяем, является ли результат целым числом
            if (result == (int)result) {
                System.out.println("Результат: " + (int)result);
                saveToHistory(equation + " = " + (int)result);
            } else {
                System.out.println("Результат: " + result);
                saveToHistory(equation + " = " + result);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при вычислении: " + e.getMessage());
        }
    }
    
    private static double evaluateExpression(String expr) {
        expr = processAbsoluteValues(expr);
        expr = processParentheses(expr);
        return evaluateSimpleExpression(expr);
    }
    
    private static String processAbsoluteValues(String expr) {
        Pattern pattern = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateExpression(inside);
            String replacement = String.valueOf(Math.abs(value));
            expr = expr.replace(matcher.group(), replacement);
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }
    
    private static String processParentheses(String expr) {
        Pattern pattern = Pattern.compile("\\(([^()]+)\\)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            String inside = matcher.group(1);
            double value = evaluateSimpleExpression(inside);
            String replacement = String.valueOf(value);
            expr = expr.replace(matcher.group(), replacement);
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }
    
    private static double evaluateSimpleExpression(String expr) {
        expr = expr.replaceAll("\\s+", "");
        
        // Обрабатываем возведение в степень
        expr = processOperation(expr, "\\^", (a, b) -> Math.pow(a, b));
        
        // Обрабатываем умножение и обычное деление
        expr = processOperation(expr, "[*/]", (a, b, op) -> {
            return op.equals("*") ? a * b : a / b;
        });
        
        // Обрабатываем целочисленное деление (//) и остаток от деления (%)
        expr = processOperation(expr, "//", (a, b) -> Math.floor(a / b));
        expr = processOperation(expr, "%", (a, b) -> a % b);
        
        // Обрабатываем сложение и вычитание
        expr = processOperation(expr, "[+-]", (a, b, op) -> {
            return op.equals("+") ? a + b : a - b;
        });
        
        return Double.parseDouble(expr);
    }
    
    private static String processOperation(String expr, String ops, BinaryOperation operation) {
        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)([" + ops + "])(-?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            double a = Double.parseDouble(matcher.group(1));
            String op = matcher.group(2);
            double b = Double.parseDouble(matcher.group(3));
            double result = operation.apply(a, b, op);
            String replacement = String.valueOf(result);
            expr = expr.replace(matcher.group(), replacement);
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }
    
    private static String processOperation(String expr, String op, DoubleBinaryOperation operation) {
        Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)\\" + op + "(-?\\d+\\.?\\d*)");
        Matcher matcher = pattern.matcher(expr);
        
        while (matcher.find()) {
            double a = Double.parseDouble(matcher.group(1));
            double b = Double.parseDouble(matcher.group(2));
            double result = operation.apply(a, b);
            String replacement = String.valueOf(result);
            expr = expr.replace(matcher.group(), replacement);
            matcher = pattern.matcher(expr);
        }
        
        return expr;
    }
    
    private static void saveToHistory(String entry) {
        try (FileWriter fw = new FileWriter(HISTORY_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(entry);
        } catch (IOException e) {
            System.out.println("Не удалось сохранить в историю: " + e.getMessage());
        }
    }
    
    private static void showHistory() {
        System.out.println("\nИстория вычислений:");
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать историю: " + e.getMessage());
        }
    }
    
    @FunctionalInterface
    private interface BinaryOperation {
        double apply(double a, double b, String op);
    }
    
    @FunctionalInterface
    private interface DoubleBinaryOperation {
        double apply(double a, double b);
    }
}