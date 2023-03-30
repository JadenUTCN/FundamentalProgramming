


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private View view;
    private Polynomial polyOne;
    private Polynomial polyTwo;
    private Polynomial result;

//    private Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    public void actionPerformed(ActionEvent e) {
        Main mymain = new Main();
        polyOne = new Polynomial();
        polyTwo = new Polynomial();
        polyOne = new Polynomial();

//        char[] chars = mymain.getInput();
//        mymain.parseChars(chars,polyOne);
//        chars = mymain.getInput();
//        mymain.parseChars(chars,polyTwo);
//        result = polyOne.mul(polyTwo);
//        result.printarray();
//        result.printPoly();

        String command = e.getActionCommand();
        if(command == "COMPUTE"){
            char[] firstNumber = view.getFirstNumberTextField().getText().toCharArray();
            char[] secondNumber = view.getSecondNumberTextField().getText().toCharArray();
            mymain.parseChars(firstNumber,polyOne);
            mymain.parseChars(secondNumber,polyTwo);
            String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());

            switch(operation){
                case "Add":      result = polyOne.add(polyTwo);
                            break;
                case "Subtract": result = polyOne.sub(polyTwo);
                                break;
                case "Multiply": result = polyOne.mul(polyTwo);
                                break;
                case "Divide": result = polyOne.div(polyTwo);
                    break;
            }

            view.getResultValueLabel().setText(result.toString());
        }
    }

}
