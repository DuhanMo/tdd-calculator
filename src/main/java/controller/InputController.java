package controller;

import domain.Calculator;
import domain.Classifier;

import java.util.Scanner;

public class InputController {

    public static void main(String[] args) {
        Classifier classifier = new Classifier();
        Calculator calculator = new Calculator(classifier);
        Scanner scanner = new Scanner(System.in);
        int result = calculator.calculate(scanner.nextLine());
        System.out.println(result);
    }
}
