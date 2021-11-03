import org.junit.Test;
import static org.junit.Assert.*;

public class EnsembleChaineTest {

    @Test
    public void ajouterTest() {
        EnsembleChaine ensemble = new EnsembleChaine();
        ensemble.ajouter("jojo");
        assertFalse(ensemble.ajouter("jojo"));
    }

    @Test
    public void equalsTest() {
        EnsembleChaine ensemble1 = new EnsembleChaine(), ensemble2 = new EnsembleChaine();

        ensemble1.ajouter("jojo");
        ensemble2.ajouter("jojo");

        assertTrue(ensemble1.equals(ensemble2));
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
        EnsembleChaine ensemble1 = new EnsembleChaine(), ensemble2 = new EnsembleChaine(),
                ensemble3, unionDisjointEnsemble1n2 = new EnsembleChaine();

        ensemble1.ajouter("jonathan");
        ensemble1.ajouter("kancel");
        ensemble1.ajouter("miage");

        ensemble2.ajouter("random");
        ensemble2.ajouter("student");
        ensemble2.ajouter("miage");

        ensemble3 = ensemble1.unionDisjointe(ensemble2);

        unionDisjointEnsemble1n2.ajouter("jonathan");
        unionDisjointEnsemble1n2.ajouter("kancel");
        unionDisjointEnsemble1n2.ajouter("random");
        unionDisjointEnsemble1n2.ajouter("student");

        assertTrue(ensemble3.equals(unionDisjointEnsemble1n2));
    }
}
