package jfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    public TextField tfSuche;
    public Button btnSuche;
    public TextField tfKennzeichen;
    public TextField tfModell;
    public Label lblFarbe;
    public TextField tfName;
    public TextField tfVorname;
    public TextField tfPNummer;

    private ParkordnungMgmt pm = ParkordnungMgmt.liesAusDatei("parkordnung.csv");

    public void suchen(ActionEvent actionEvent) {
        String suchText = tfSuche.getText().toUpperCase();
        if (suchText.isBlank())
            return;
        for (Person person : pm.getZuordnung().keySet()) {
            for (Auto auto : pm.getZuordnung().get(person)) {
                if (auto.getKennzeichen().toUpperCase().contains(suchText)) {
                    tfKennzeichen.setText(auto.getKennzeichen());
                    tfModell.setText(auto.getModellbezeichnung());
                    tfName.setText(person.getName());
                    tfVorname.setText(person.getVorname());
                    tfPNummer.setText("" + person.getId());
                    lblFarbe.setStyle(
                            String.format("-fx-background-color: %s", auto.getFarbCode()));
                }

            }
        }
    }
}
