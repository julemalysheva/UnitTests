package seminar3;

import seminar3.controller.CalculatorController;
import seminar3.model.CalculatorModel;
import seminar3.view.CalculatorView;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
