package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Szamologep;

import java.util.logging.Level;
import java.util.logging.Logger;


public class SzamologepCont {

    private model.Szamologep szamologep;

    @FXML
    private Button btnVissza;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtEredmeny;

    @FXML
    private Label lblResult;

    @FXML
    public void initialize() {
        szamologep = new model.Szamologep();
    }

    @FXML
    private void fomenu(ActionEvent e) {
        Stage stage;
        Parent root;

        try {
            stage = (Stage) btnVissza.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(Lnko.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void add(ActionEvent e) {
        //System.out.println("Számítás");
        txtEredmeny.setText(Long.toString(szamologep.add(Long.decode(txtA.getText()), Long.parseLong(txtB.getText()))));

    }

    @FXML
    private void sub(ActionEvent e) {
        txtEredmeny.setText(Long.toString(szamologep.sub(Long.decode(txtA.getText()), Long.parseLong(txtB.getText()))));
    }

    @FXML
    private void mul(ActionEvent e) {
        txtEredmeny.setText(Long.toString(szamologep.mul(Long.decode(txtA.getText()), Long.parseLong(txtB.getText()))));
    }

    @FXML
    private void div(ActionEvent e) {
        txtEredmeny.setText(Long.toString(szamologep.div(Long.decode(txtA.getText()), Long.parseLong(txtB.getText()))));
    }

}
