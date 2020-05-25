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

    public BorderPane getLayout(int state) {
        layout = new BorderPane();
        vBox = new VBox();

        output = new Label("0");

        switch (state) {
            case 0:
                vBox.getChildren().add(output);
                for (int i = 0; i < 5; i++) {
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

            try {
                int parseElToInt = Integer.parseInt(i);
                btn.setStyle("-fx-background-color: #666666; -fx-text-fill:#ffffff;");
            } catch (NumberFormatException e) {
                btn.setStyle("-fx-background-color: #f2f2f2;");
            }

            btn.setOnAction(e -> {
                output.setText(validateExpression.validate(output.getText(), btn.getText()));
            });

            hBox.getChildren().add(btn);
        }

        return hBox;
    }
}
