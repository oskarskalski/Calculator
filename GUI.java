package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


class GUI {
    private HBox hBox;
    private VBox vBox;
    private BorderPane layout;
    private BtnSettings btnSettings = new BtnSettings();
    private Label output;
    private int navState = 1;

    private FunctionBtnEventListener fbel = new FunctionBtnEventListener();
    private MathExpressionValidator validateExpression = new MathExpressionValidator();

    public StackPane getLayout(int state) {
        StackPane root = new StackPane();
        layout = new BorderPane();
        vBox = new VBox();

        output = new Label("0");

        Button openNav = new Button("Nav");

        Label calcType;
        HBox header = new HBox();
        header.getChildren().add(openNav);
        openNav.setId("openNav");

        switch (state) {
            case 0:
                calcType = new Label("Standardowy");
                header.getChildren().add(calcType);
                vBox.getChildren().add(output);
                for (int i = 0; i < 5; i++) {
                    vBox.getChildren().add(
                            createButtons(btnSettings.getBtnNames(i)));
                }
                layout.setCenter(vBox);
                break;
        }

        layout.setTop(header);
        Button closeBtn = new Button("Close");
        closeBtn.setId("openNav");
        Label test = new Label("Test");
        Label test2 = new Label("Test");
        VBox navVBox = new VBox();
        navVBox.getChildren().addAll(closeBtn, test, test2);
        openNav.setOnAction(e -> {
            //    root.getChildren().add(navVBox);
            //   root.setAlignment(navVBox, Pos.TOP_LEFT);
            //    navState = 0;
            System.out.println("It doesn't work for now");
        });

        closeBtn.setOnAction(e -> {
            root.getChildren().remove(navVBox);
            navState = 1;
        });

        root.getChildren().add(layout);

        return root;
    }

    public HBox createButtons(String... tab) {
        hBox = new HBox();
        for (String i : tab) {
            Button btn = new Button(i);

            try {
                int parseElToInt = Integer.parseInt(i);
                btn.setStyle("-fx-background-color: #666666; -fx-text-fill:#ffffff;");
            } catch (NumberFormatException e) {
                btn.setStyle("-fx-background-color: #f2f2f2;");
            }

            btn.setOnAction(e -> {
                char firstLetterInbtnText = btn.getText().charAt(0);

                if (firstLetterInbtnText != 'M') {
                    output.setText(validateExpression.validate(output.getText(), btn.getText()));
                } else {
                    output.setText(output.getText() + fbel.functionBtnType(btn.getText(), output.getText()));
                }

            });

            hBox.getChildren().add(btn);
        }

        return hBox;
    }
}
