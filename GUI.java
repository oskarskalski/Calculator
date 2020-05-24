package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.script.ScriptException;

class GUI {
    private HBox hBox;
    private VBox vBox;
    private BorderPane layout;
    private BtnSettings btnSettings = new BtnSettings();
    private Label output;
    private Label digits;

    public BorderPane getLayout(int state) {
        layout = new BorderPane();
        vBox = new VBox();

        output = new Label("0");
        digits = new Label();

        VBox getLabels = new VBox();
        getLabels.getChildren().addAll(output, digits);

        switch (state) {
            case 0:
                layout.setTop(getLabels);

                for(int i = 0; i<5; i++){
                    vBox.getChildren().add(
                            createButtons(btnSettings.getBtnNames(i)));
                }

                layout.setCenter(vBox);
                break;
        }

        return layout;
    }

    public HBox createButtons(String... tab) {
        hBox = new HBox();
        MathExpressionValidator validateExpression = new MathExpressionValidator();
        MathEvaluate mathEvaluate = new MathEvaluate();
        for (String i : tab) {
            Button btn = new Button(i);
            btn.setOnAction(e -> {
                if(btn.getText().equals("=")){
                    try {
                        output.setText(mathEvaluate.evaluate(output.getText()));
                    } catch (ScriptException scriptException) {
                        scriptException.printStackTrace();
                    }
                }else{
                    output.setText(validateExpression.validate(output.getText(), btn.getText()));
                }
            });

            hBox.getChildren().add(btn);
        }

        return hBox;
    }

    public <T> VBox getElementsByVerticalDirection(T... tab) {
        VBox vBox2 = new VBox();

        for (T i : tab) {
            vBox.getChildren().add((Node) i);
        }

        return vBox;
    }
    public <T> HBox getElementsByHorizontalDirection(T... tab) {
        hBox = new HBox();

        for (T i : tab) {
            vBox.getChildren().add((Node) i);
        }

        return hBox;
    }
}
