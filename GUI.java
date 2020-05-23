package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

class GUI {
    private HBox hBox;
    private VBox vBox;
    private BorderPane layout;
    private BtnSettings btnSettings = new BtnSettings();
    private Label output;

    public BorderPane getLayout(int state) {
        layout = new BorderPane();
        output = new Label();
        vBox = new VBox();

        switch (state) {
            case 0:
                layout.setTop(output);

                for(int i = 0; i<5; i++){
                    vBox.getChildren().add(
                            getBtnsByHorizontalDirection(btnSettings.getBtnNames(i)));
                }

                layout.setCenter(vBox);
                break;
        }

        return layout;
    }

    public HBox getBtnsByHorizontalDirection(String... tab) {
        hBox = new HBox();
        MathExpressionValidator validateExpression = new MathExpressionValidator();
        for (String i : tab) {
            Button btn = new Button(i);
            btn.setOnAction(e -> {
                System.out.println(validateExpression.evaluate("1 + 1 + 2121.1"));
            });

            hBox.getChildren().add(btn);
        }

        return hBox;
    }

    public <T> VBox getElementsByVerticalDirection(T... tab) {
        vBox = new VBox();

        for (T i : tab) {
            vBox.getChildren().add((Node) i);
        }

        return vBox;
    }
}
