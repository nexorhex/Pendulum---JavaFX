import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Wahadlo extends Application {

    TextField textField1;
    TextField textField2;
    TextField textField3;
    TextField textField4;
    TextField textField5;
    TextField textField6;
    TextField textField7;
    Button button1;
    Button button2;
    Button button3;
    ScatterChart<Number, Number> figure2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Wahadlo Michal");

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(20, 30, 30, 30));

        Label label1 = new Label("Parameters");
        label1.setFont(Font.font("Times", FontWeight.BOLD, 20));
        layout.getChildren().add(label1);

        Label label2 = new Label("tStop: ");
        Label label3 = new Label(" n: ");
        Label label4 = new Label(" f: ");
        Label label5 = new Label(" c: ");
        Label label6 = new Label(" A: ");
        Label label7 = new Label(" Theta0: ");
        Label label8 = new Label(" Omega0: ");

        textField1 = new TextField();
        textField1.setText("20");
        textField1.setPrefWidth(80);
        textField2 = new TextField();
        textField2.setText("100");
        textField2.setPrefWidth(80);
        textField3 = new TextField();
        textField3.setText("5");
        textField3.setPrefWidth(80);
        textField4 = new TextField();
        textField4.setText("0");
        textField4.setPrefWidth(80);
        textField5 = new TextField();
        textField5.setText("0");
        textField5.setPrefWidth(80);
        textField6 = new TextField();
        textField6.setText("0.5");
        textField6.setPrefWidth(80);
        textField7 = new TextField();
        textField7.setText("0");
        textField7.setPrefWidth(80);

        HBox hBox = new HBox(label2, textField1, label3, textField2, label4, textField3);
        HBox hBox2 = new HBox(label7, textField6, label8, textField7, label5, textField4, label6, textField5);
        hBox.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        layout.getChildren().add(hBox);
        layout.getChildren().add(hBox2);

        button1 = new Button("Draw theta/time");
        button1.setPrefWidth(150);
        button1.setOnAction(e -> {
            double t = Double.parseDouble(textField1.getText());
            double n = Double.parseDouble(textField2.getText());
            double f = Double.parseDouble(textField3.getText());
            double c = Double.parseDouble(textField4.getText());
            double A = Double.parseDouble(textField5.getText());
            double theta0 = Double.parseDouble(textField6.getText());
            double omega0 = Double.parseDouble(textField7.getText());
            TimeTheta tt = new TimeTheta(t, n, f, theta0, omega0, c, A);

            figure2.getData().clear();
            XYChart.Series data = tt.getValues().get(0);
            data.setName("Pendulum Theta");
            figure2.setLegendVisible(false);
            figure2.getData().add(data);
        });

        button2 = new Button("Draw omega/time");
        button2.setPrefWidth(150);
        button2.setOnAction(e -> {
            double t = Double.parseDouble(textField1.getText());
            double n = Double.parseDouble(textField2.getText());
            double f = Double.parseDouble(textField3.getText());
            double c = Double.parseDouble(textField4.getText());
            double A = Double.parseDouble(textField5.getText());
            double theta0 = Double.parseDouble(textField6.getText());
            double omega0 = Double.parseDouble(textField7.getText());
            TimeTheta tt = new TimeTheta(t, n, f, theta0, omega0, c, A);

            figure2.getData().clear();
            XYChart.Series data = tt.getValues().get(1);
            data.setName("Pendulum Omega");
            figure2.setLegendVisible(false);
            figure2.getData().add(data);
        });

        button3 = new Button("Draw phase plane");
        button3.setPrefWidth(150);
        button3.setOnAction(e -> {
            double t = Double.parseDouble(textField1.getText());
            double n = Double.parseDouble(textField2.getText());
            double f = Double.parseDouble(textField3.getText());
            double c = Double.parseDouble(textField4.getText());
            double A = Double.parseDouble(textField5.getText());
            double theta0 = Double.parseDouble(textField6.getText());
            double omega0 = Double.parseDouble(textField7.getText());
            TimeTheta tt = new TimeTheta(t, n, f, theta0, omega0, c, A);

            figure2.getData().clear();
            XYChart.Series data = tt.getValues().get(2);
            data.setName("Pendulum Phase Plane");
            figure2.setLegendVisible(false);
            figure2.getData().add(data);

        });

        HBox hBox3 = new HBox(button1, button2, button3);
        hBox3.setAlignment(Pos.CENTER);
        layout.getChildren().add(hBox3);

        NumberAxis x = new NumberAxis();
        x.setLabel("Time");
        NumberAxis y = new NumberAxis();
        y.setLabel("Values");

        figure2 = new ScatterChart<Number, Number>(x, y);

        layout.getChildren().add(figure2);

        Scene scene = new Scene(layout, 700, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
