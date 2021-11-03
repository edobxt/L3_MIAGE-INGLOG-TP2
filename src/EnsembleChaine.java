import java.util.ArrayList;

public class EnsembleChaine {
    ArrayList< String > liste;
    public EnsembleChaine(){
        liste = new ArrayList<>() ;
    }
    //Ajoute la chaine ch, si elle n’existe pas déjà, à l’ensemble
    public boolean ajouter(String ch) {
        if (liste.contains(ch)) { return false; }
        else {
            liste.add(ch);
            return true;
        }
    }
    //Test si l’ensemble e est equivalent à l’ensemble courant
    public boolean equals(EnsembleChaine e) {
        return liste.equals(e.liste);
    }
    //Renvoie l’union de l’ensemble e et l’ensemble courant
    public EnsembleChaine union(EnsembleChaine e){
        EnsembleChaine unionEnsemble = new EnsembleChaine();

        for (String element: this.liste) {
            unionEnsemble.ajouter(element);
        }

        for (String element: e.liste) {
            unionEnsemble.ajouter(element);
        }

        return unionEnsemble;
    }
    //Renvoie l’intersection de l’ensemble e et l’ensemble courant
    public EnsembleChaine intersection(EnsembleChaine e){
        EnsembleChaine interEnsemble = new EnsembleChaine();

        for (String element: this.liste) {
            if (e.liste.contains(element)) {
                interEnsemble.ajouter(element);
            }
        }

        return interEnsemble;
    }
    //Renvoie l’union disjointe de l’ensemble e et l’ensemble courant
    public EnsembleChaine unionDisjointe(EnsembleChaine e){
        EnsembleChaine unionDisjointEnsemble = new EnsembleChaine();

        for (String element: this.liste) {
            if (!e.liste.contains(element)) {
                unionDisjointEnsemble.ajouter(element);
            }
        }

        for (String element: e.liste) {
            if (!this.liste.contains(element)) {
                unionDisjointEnsemble.ajouter(element);
            }
        }

            return unionDisjointEnsemble;
    }
}
