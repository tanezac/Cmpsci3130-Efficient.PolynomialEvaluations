package edu.umsl.algorithms;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

import java.util.Scanner;


public class project_1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        //Button button = new Button("OK");
        //pane.getChildren().add(new Button("OK"));
        //pane.setAlignment(Pos.CENTER);


        Button btOK = new Button("OK");
        Button method1 = new Button("Method 1");
        Button method2 = new Button("Method 2");
        Button method3 = new Button("Method 3");
        Button btExit = new Button("Exit");
        HBox hBox = new HBox(btOK,method1,method2,method3,btExit);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        BorderPane borderPane = new BorderPane(pane);
        borderPane.setBottom(hBox);






        OKHandlerClass handler1 = new OKHandlerClass();
        btOK.setOnAction(handler1);
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btExit.setOnAction(handler2);
        pane.getChildren().addAll(btOK, btExit);


        Scene scene = new Scene(pane, 600, 350);
        primaryStage.setTitle("Project 1: Efficient Polynomial Evaluations!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        final int ARRAY_SIZE = 100000;
        int[] myArray = new int[ARRAY_SIZE];
        myArray = creatArray(ARRAY_SIZE);
        display_polynomial(myArray);
        Application.launch(args);


        Scanner input = new Scanner(System.in);


    }

    public static int[] creatArray(int size) {
        int[] Array = new int[size];
        for (int i = 0; i < size; i++) {
            Array[i] = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
        }
        return Array;
    }

    public static void display_polynomial(int[] array) {
        System.out.println("The polynomials:");
        System.out.println(array[0] + " + " + array[1] + "x +" + array[2] + "x^2 +" + array[3] + "x^3 +....+ " + array[array.length - 2] + "x^" + (array.length - 2) + " + " + array[array.length - 1] + "x^" + (array.length - 1));
    }

    static class OKHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            System.out.println("OK button clicked");
        }
    }

    static class CancelHandlerClass implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            //System.out.println("Cancel button clicked");
            System.exit(0);
        }
    }
}



