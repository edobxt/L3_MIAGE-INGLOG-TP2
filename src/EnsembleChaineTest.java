import org.junit.Test;
import static org.junit.Assert.*;

public class EnsembleChaineTest {

    @Test
    public void ajouterTest() {
        EnsembleChaine ensemble = new EnsembleChaine();
        ensemble.ajouter("jojo");
        assertTrue(ensemble.liste.contains("jojo"));
        assertFalse(ensemble.ajouter("jojo"));
        assertTrue(ensemble.ajouter("random"));
    }

    @Test
    public void equalsTest() {
        EnsembleChaine ensemble1 = new EnsembleChaine(), ensemble2 = new EnsembleChaine(),
                ensemble3 = new EnsembleChaine();
        // Ajout d'éléments dans l'ensemble 1
        ensemble1.ajouter("jojo");
        ensemble1.ajouter("wesh");
        ensemble1.ajouter("test");
        // Ajout d'éléments dans l'ensemble 2
        ensemble2.ajouter("jojo");
        ensemble2.ajouter("test");
        ensemble2.ajouter("wesh");

        // Ajout d'éléments dans l'ensemble 3
        ensemble3.ajouter("random");

        assertTrue(ensemble1.equals(ensemble2));
        assertFalse(ensemble1.equals(ensemble3));
    }

    @Test
    public void unionTest() {
        EnsembleChaine ensemble1 = new EnsembleChaine(), ensemble2 = new EnsembleChaine(),
                ensemble3, unionEnsemble1n2 = new EnsembleChaine();
        ensemble1.ajouter("jonathan");
        ensemble2.ajouter("kancel");

        ensemble3 = ensemble1.union(ensemble2);

        unionEnsemble1n2.ajouter("jonathan");
        unionEnsemble1n2.ajouter("kancel");

        assertTrue(ensemble3.equals(unionEnsemble1n2));
    }

    @Test
    public void intersectionTest() {
        EnsembleChaine ensemble1 = new EnsembleChaine(), ensemble2 = new EnsembleChaine(),
                ensemble3, interEnsemble1n2 = new EnsembleChaine();

        ensemble1.ajouter("jonathan");
        ensemble1.ajouter("kancel");
        ensemble1.ajouter("miage");

        ensemble2.ajouter("random");
        ensemble2.ajouter("student");
        ensemble2.ajouter("miage");

        ensemble3 = ensemble1.intersection(ensemble2);

        interEnsemble1n2.ajouter("miage");

        assertTrue(ensemble3.equals(interEnsemble1n2));
    }

    @Test
    public void unionDisjointeTest() {
        EnsembleChaine ensembleChaine = new EnsembleChaine(), ensembleChaine2 = new EnsembleChaine(),
                ensemble3, unionDisjointEnsemble1n2 = new EnsembleChaine();

        ensembleChaine.ajouter("jonathan");
        ensembleChaine.ajouter("kancel");
        ensembleChaine.ajouter("miage");

        ensembleChaine2.ajouter("random");
        ensembleChaine2.ajouter("student");
        ensembleChaine2.ajouter("miage");

        ensemble3 = ensembleChaine.unionDisjointe(ensembleChaine2);

        unionDisjointEnsemble1n2.ajouter("jonathan");
        unionDisjointEnsemble1n2.ajouter("kancel");
        unionDisjointEnsemble1n2.ajouter("random");
        unionDisjointEnsemble1n2.ajouter("student");

        assertTrue(ensemble3.equals(unionDisjointEnsemble1n2));
    }
}
