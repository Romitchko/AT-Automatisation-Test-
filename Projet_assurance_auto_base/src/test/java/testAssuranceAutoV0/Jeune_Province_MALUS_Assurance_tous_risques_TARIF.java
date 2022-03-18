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
public class Jeune_Province_MALUS_Assurance_tous_risques_TARIF {

    private final int Conducteur_bonusMalus;
    private final int Conducteur_codePostal;
    private final String Conducteur_datePermis;
    private final String Conducteur_nom;
    private final String Tarif;
    private final int Vehicule_anneeMiseEnCirculation;
    private final String Vehicule_carburant;
    private final String Vehicule_marque;
    private final String Vehicule_modele;

    public Jeune_Province_MALUS_Assurance_tous_risques_TARIF(final int Conducteur_bonusMalus, final int Conducteur_codePostal, final String Conducteur_datePermis, final String Conducteur_nom, final String Tarif, final int Vehicule_anneeMiseEnCirculation, final String Vehicule_carburant, final String Vehicule_marque, final String Vehicule_modele) {
        this.Conducteur_bonusMalus = Conducteur_bonusMalus;
        this.Conducteur_codePostal = Conducteur_codePostal;
        this.Conducteur_datePermis = Conducteur_datePermis;
        this.Conducteur_nom = Conducteur_nom;
        this.Tarif = Tarif;
        this.Vehicule_anneeMiseEnCirculation = Vehicule_anneeMiseEnCirculation;
        this.Vehicule_carburant = Vehicule_carburant;
        this.Vehicule_marque = Vehicule_marque;
        this.Vehicule_modele = Vehicule_modele;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}-{4}-{5}-{6}-{7}-{8}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {-45, 63126, "13/03/2021", "Malachi Sears", "3445.20", 2016, "Diesel", "Mercedes Benz", "Class B"}
        });
    }

    @Before
    public void setUp() {
        ouvrirNavigateur("https://demo-simulator.herokuapp.com/");
    }


    @Test
    public void execute() {
        saisirCaracteristiquesVehicule(Vehicule_marque, Vehicule_modele, Vehicule_carburant);
        saisirAnneeMiseEnCirculation(Vehicule_anneeMiseEnCirculation);
        saisirLesDonneesConducteur(Conducteur_datePermis, Conducteur_codePostal, Conducteur_nom);
        saisirBonusMalus(Conducteur_bonusMalus);
        choisirAssuranceTousRisques();
        simulerEtVerifierTarif(Tarif);
    }
}