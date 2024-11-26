public class FactureManager {

    /**
     * Calcule le total d'une facture après application des réductions spécifiques.
     *
     * @param typeProduit Le type du produit (Alimentaire, Electronique, Luxe).
     * @param quantite La quantité de produits achetés.
     * @param prixUnitaire Le prix unitaire du produit.
     * @return Le montant total après application des réductions.
     */
    public double calculerFacture(String typeProduit, int quantite, double prixUnitaire) {
        double total = quantite * prixUnitaire;

        // Appliquer une réduction selon la catégorie de produit
        switch (typeProduit) {
            case "Alimentaire":
                total = appliquerReduction(total, 0.05); // Réduction de 5%
                break;
            case "Electronique":
                total = appliquerReduction(total, 0.10); // Réduction de 10%
                break;
            case "Luxe":
                total = appliquerReduction(total, 0.15); // Réduction de 15%
                break;
            default:
                System.out.println("Type de produit inconnu. Aucune réduction appliquée.");
        }

        // Réduction supplémentaire pour les gros montants (> 1000)
        if (total > 1000) {
            total = appliquerReduction(total, 0.05);
        }

        return total;
    }

    /**
     * Applique une réduction au montant total.
     *
     * @param montant Le montant initial avant réduction.
     * @param tauxReduction Le taux de réduction à appliquer (ex: 0.05 pour 5%).
     * @return Le montant après application de la réduction.
     */
    private double appliquerReduction(double montant, double tauxReduction) {
        return montant - (montant * tauxReduction);
    }
}