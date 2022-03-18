package testAssuranceAutoV0;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

import static keyword.Keyword.*;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class Experimente_Paris_MALUS_Assurance_tous_risques_TARIF {

    private final String Vehicule_carburant;
    private final String Vehicule_marque;
    private final String Vehicule_modele;

    public Experimente_Paris_MALUS_Assurance_tous_risques_TARIF(final String Vehicule_carburant, final String Vehicule_marque, final String Vehicule_modele) {
        this.Vehicule_carburant = Vehicule_carburant;
        this.Vehicule_marque = Vehicule_marque;
        this.Vehicule_modele = Vehicule_modele;
    }

    @Parameters(name = "{0}-{1}-{2}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"Diesel", "BMW", "M2"}
        });
    }

    @Before
    public void setUp() {
        ouvrirNavigateur(https://demo-simulator.herokuapp.com/);
    }


    @Test
    public void execute() {
        saisirCaracteristiquesVehicule(Vehicule_marque, Vehicule_modele, Vehicule_carburant);
    }
}