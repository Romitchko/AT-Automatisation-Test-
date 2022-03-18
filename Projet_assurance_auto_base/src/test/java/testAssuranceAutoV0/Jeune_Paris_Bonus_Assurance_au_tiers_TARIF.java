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
public class Jeune_Paris_Bonus_Assurance_au_tiers_TARIF {

    private final int Conducteur_bonusMalus;
    private final int Conducteur_codePostal;
    private final String Conducteur_datePermis;
    private final String Conducteur_nom;
    private final String Tarif;
    private final int Vehicule_anneeMiseEnCirculation;
    private final String Vehicule_carburant;
    private final String Vehicule_marque;
    private final int Vehicule_modele;

    public Jeune_Paris_Bonus_Assurance_au_tiers_TARIF(final int Conducteur_bonusMalus, final int Conducteur_codePostal, final String Conducteur_datePermis, final String Conducteur_nom, final String Tarif, final int Vehicule_anneeMiseEnCirculation, final String Vehicule_carburant, final String Vehicule_marque, final int Vehicule_modele) {
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
            {20, 75577, "21/01/2019", "Emi Puckett", "1003.20", 2016, "Diesel", "Peugeot", 308}
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
        choisirAssuranceAuTiers();
        simulerEtVerifierTarif(Tarif);
    }
}