public class StockManager {

    /**
     * Gère les opérations sur le stock : ajout ou retrait de produits.
     *
     * @param typeOperation Le type d'opération (ajout ou retrait).
     * @param produit Le nom du produit.
     * @param quantite La quantité à ajouter ou retirer.
     * @param stock Le stock actuel du produit avant l'opération.
     * @return Le stock mis à jour après l'opération.
     */
    public int gererStock(String typeOperation, String produit, int quantite, int stock) {
        switch (typeOperation.toLowerCase()) {
            case "ajout":
                stock = ajouterStock(produit, quantite, stock);
                break;
            case "retrait":
                stock = retirerStock(produit, quantite, stock);
                break;
            default:
                System.out.println("Opération inconnue.");
        }
        return stock;
    }

    /**
     * Ajoute une quantité de produit au stock.
     *
     * @param produit Le nom du produit.
     * @param quantite La quantité à ajouter.
     * @param stock Le stock actuel avant l'ajout.
     * @return Le nouveau stock après l'ajout.
     */
    private int ajouterStock(String produit, int quantite, int stock) {
        stock += quantite;
        System.out.println("Produit : " + produit + ", Stock après ajout : " + stock);
        return stock;
    }

    /**
     * Retire une quantité de produit du stock, si le stock est suffisant.
     *
     * @param produit Le nom du produit.
     * @param quantite La quantité à retirer.
     * @param stock Le stock actuel avant le retrait.
     * @return Le nouveau stock après le retrait, ou le stock inchangé si insuffisant.
     */
    private int retirerStock(String produit, int quantite, int stock) {
        if (stock >= quantite) {
            stock -= quantite;
            System.out.println("Produit : " + produit + ", Stock après retrait : " + stock);
        } else {
            System.out.println("Stock insuffisant pour le produit : " + produit);
        }
        return stock;
    }
}
