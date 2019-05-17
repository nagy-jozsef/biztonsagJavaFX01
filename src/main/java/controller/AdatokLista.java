package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Adatok;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AdatokLista {


	@FXML
	public TableView tblAdatok;
	
	@FXML
	public Button btnVissza;
	public TextField txtSzam1;
	public TextField txtSzam2;
	public Button btnCalc;

	public AdatokLista() {
        Adatok adat = new Adatok();
        //tblAdatok.
        try {
            System.out.println(adat.getAllAdat());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	public void fomenu(ActionEvent actionEvent) {
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

	public void calculator(ActionEvent actionEvent) {
		Stage stage;
		Parent root;

		try {
			stage = (Stage) btnCalc.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/fxml/calculator.fxml"));
			//System.out.println(stage.getTitle());
			stage.setScene(new Scene(root));
		} catch (Exception ex) {
			Logger.getLogger(Lnko.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
