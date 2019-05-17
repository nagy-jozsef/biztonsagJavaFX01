import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Adatok;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Biztonsag extends Application {

    private static Stage stage;

    @FXML
    public Button btnLNKO;

    @FXML
    public Button btnBezar;

    @FXML
    public Button btnCalc;

    @FXML
    public Button btnMiller;

    @FXML
	public Button btnLista;

	private Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            //setUserAgentStylesheet(STYLESHEET_CASPIAN);
            setUserAgentStylesheet(STYLESHEET_MODENA);

            stage = primaryStage;
            stage.show();
            root = FXMLLoader.load(getClass().getResource("/fxml/start.fxml"));

            stage.setTitle("Informatikai Biztonság - számítások");
            stage.setScene(new Scene(root, 800, 600));

            stage.show();

        } catch (Exception ex) {
            Logger.getLogger(Biztonsag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //private static EntityManager em;

    public static void main(String[] args) {

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
        //em = emf.createEntityManager();

        launch(args);

        //em.close();
        //emf.close();
    }

    @FXML
    private void bezar(ActionEvent e) {
        Platform.exit();
    }

    @FXML
    private void calculator(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/calculator.fxml"));
            //System.out.println(stage.getTitle());
            this.stage.setScene(new Scene(root));
        } catch (Exception ex) {
            Logger.getLogger(Biztonsag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void lnko(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/lnko.fxml"));
            //System.out.println(stage.getTitle());
            this.stage.setScene(new Scene(root));
        } catch (Exception ex) {
            Logger.getLogger(Biztonsag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void miller(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/miller.fxml"));
            //System.out.println(stage.getTitle());
            this.stage.setScene(new Scene(root));
        } catch (Exception ex) {
            Logger.getLogger(Biztonsag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void lista(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/lista.fxml"));
            //System.out.println(stage.getTitle());
            this.stage.setScene(new Scene(root));
        } catch (Exception ex) {
            Logger.getLogger(Biztonsag.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    //create
    public void createAdatLnko(String tipus, long szam1, long szam2, long eredmeny) {
        em.getTransaction().begin();
        Adatok adat = new Adatok(tipus, szam1, szam2, eredmeny);
        em.persist(adat);
        em.getTransaction().commit();
    }
*/

}
