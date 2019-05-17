package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Adatok;
import model.Szamitasok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lnko {

	private static EntityManager em;

	public Lnko() {
		System.out.println("LNKO constructor...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
		em = emf.createEntityManager();
	}

	@FXML
	public Button btnLnkoMent;

	@FXML
	public Button btnPelda;

	@FXML
	private Button btnVissza;

	@FXML
	private Button btnLnko;

	@FXML
	public Button btnCalc;

	@FXML
	private TextField txtLnko;

	@FXML
	private TextField txtSzam1, txtSzam2;

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
	private void calculator(ActionEvent e) {
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

	@FXML
	private void lnko(ActionEvent e) {
		//System.out.println("Számítás");
  		txtLnko.setText(Long.toString(Szamitasok.lnko( Long.decode(txtSzam1.getText()), Long.parseLong(txtSzam2.getText()))));
	}


	public void createAdatLnko(String tipus, long szam1, long szam2, long eredmeny) {
		em.getTransaction().begin();
		Adatok adat = new Adatok(tipus, szam1, szam2, eredmeny);
		em.persist(adat);
		em.getTransaction().commit();
	}

	public void lnko_save(ActionEvent actionEvent) {
		createAdatLnko("LNKO", Long.decode(txtSzam1.getText()), Long.parseLong(txtSzam2.getText()), Long.parseLong(txtLnko.getText()));
		txtSzam1.setText("");
		txtSzam2.setText("");
		txtLnko.setText("");
	}

	public void pelda(ActionEvent actionEvent) {
		txtSzam1.setText(new Integer(1785).toString());
		txtSzam2.setText(new Integer(546).toString());
	}


}
