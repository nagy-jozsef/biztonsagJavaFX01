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


public class PrimTeszt {

	private static EntityManager em;

	public PrimTeszt() {
		System.out.println("LNKO constructor...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
		em = emf.createEntityManager();
	}

	@FXML
	public TextField txtA1;
	@FXML
	public TextField txtE1;
	@FXML
	public TextField txtA2;
	@FXML
	public TextField txtE2;
	@FXML
	public TextField txtEredmeny;
	@FXML
	public Button btnMent;
	@FXML
	public Button btnPelda;
	@FXML
	private Button btnVissza;
	@FXML
	private Button btnTeszt;

	@FXML
	public Button btnCalc;

	@FXML
	private TextField txtSzam;

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
	private void miller(ActionEvent e) {
		//System.out.println("Számítás");
		String a1;
		a1 = (Szamitasok.primTeszt(Long.parseLong(txtSzam.getText()), Long.parseLong(txtA1.getText()))) ? "nem" : "igen";
		txtE1.setText(a1);

		String a2;
		a1 = (Szamitasok.primTeszt(Long.parseLong(txtSzam.getText()), Long.parseLong(txtA2.getText()))) ? "nem" : "igen";
		txtE2.setText(a1);

		String er = (Szamitasok.primTeszt2(Long.parseLong(txtSzam.getText()), Long.parseLong(txtA1.getText()), Long.parseLong(txtA2.getText()))) ? "lehetséges prím" : "összetett szám";
		txtEredmeny.setText(er);
	}

	public void createPrim(String tipus, long szam1, long szam2, long szam3, String eredmenyS) {
		em.getTransaction().begin();
		Adatok adat = new Adatok(tipus, szam1, szam2, szam3, eredmenyS);
		em.persist(adat);
		em.getTransaction().commit();
	}


	public void mentes(ActionEvent actionEvent) {
		btnTeszt.setDisable(true);
		createPrim("MILLER", Long.decode(txtSzam.getText()), Long.parseLong(txtA1.getText()), Long.parseLong(txtA2.getText()), txtEredmeny.getText());
		txtSzam.setText("");
		txtA1.setText("");
		txtA2.setText("");
		txtEredmeny.setText("");
		btnTeszt.setDisable(false);
	}
	public void pelda(ActionEvent actionEvent) {
		txtSzam.setText(new Integer(241).toString());
		txtA1.setText(new Integer(11).toString());
		txtA2.setText(new Integer(15).toString());
	}
}
