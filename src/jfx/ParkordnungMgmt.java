package jfx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkordnungMgmt {

    private final Map<Person, Set<Auto>> zuordnung =
            new HashMap<>();

    private ParkordnungMgmt() {
    }

    public static ParkordnungMgmt liesAusDatei(String dateiname) {
        ParkordnungMgmt pm = new ParkordnungMgmt();

        try (BufferedReader br = new BufferedReader(new FileReader(dateiname))) {
            String line;
            Person p = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        p = new Person(
                                parts[1].strip(),
                                parts[2].strip(),
                                Integer.parseInt(parts[0].strip()));
                        pm.zuordnung.put(p, new HashSet<>());
                    } catch (NumberFormatException ignored) {
                    }
                }
                if (parts.length == 5 && p != null) {
                    try {
                        Auto auto = new Auto(
                                parts[0].strip(),
                                parts[1].strip(),
                                Integer.parseInt(parts[2].strip()),
                                Integer.parseInt(parts[3].strip()),
                                Integer.parseInt(parts[4].strip())
                        );
                        pm.zuordnung.get(p).add(auto);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pm;
    }

    public Map<Person, Set<Auto>> getZuordnung() {
        return zuordnung;
    }
}
