package calculator.controller;

import calculator.global.error.ErrorMessage;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class CalculatorController {

    private final StringCalculator stringCalculator;
    private final CalculatorView calculatorView;


    public CalculatorController() {
        this.stringCalculator = new StringCalculator();
        this.calculatorView = new CalculatorView();
    }

    public void run(){
        try {
            String input = calculatorView.getInput();
            int add = stringCalculator.add(input);
            calculatorView.printResult(add);

        }catch (IllegalArgumentException e){

            ErrorMessage errorMessage =  matchErrorMessage(e.getMessage());
            calculatorView.printError(errorMessage);
        }
    }

    private ErrorMessage matchErrorMessage(String message) {
        for(ErrorMessage errorMessage : ErrorMessage.values()){
            if(errorMessage.getMessage().equals(errorMessage)){
                return errorMessage;
            }
        }
        throw new IllegalArgumentException("알 수 없는 에러: " + message);
    }
}
