package jfx;

import javafx.scene.paint.Color;

public class Auto {

    private final String kennzeichen;
    private String modellbezeichnung;
    private Color farbe;

    public Auto(String kennzeichen, String modellbezeichnung, int r, int g, int b) {
        this(kennzeichen, modellbezeichnung, Color.rgb(r,g,b));
    }

    public Auto(String kennzeichen, String modellbezeichnung, Color farbe) {
        this.kennzeichen = kennzeichen;
        this.modellbezeichnung = modellbezeichnung;
        this.farbe = farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getModellbezeichnung() {
        return modellbezeichnung;
    }

    public void setModellbezeichnung(String modellbezeichnung) {
        this.modellbezeichnung = modellbezeichnung;
    }

    public Color getFarbe() {
        return farbe;
    }

    public String getFarbCode() {
        return "#" + farbe.toString().substring(2,8);
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s",
                kennzeichen,
                modellbezeichnung,
                farbe);
    }
}
