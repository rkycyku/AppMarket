package AppMarket;



/*  
 *
 *  Importimi i Librarive
 *
 */



/*  
 *
 *  Tema: 
 *  @author Rilind Kyçyku - rkycyku
 *
 */
public class Produktet {
    private int id;
    private String prodName;
    private String prodKat;
    private float prodQmim; 
    
    public Produktet(int ID, String ProdName, String ProdKat, float ProdQmim)
    {
        this.id = ID;
        this.prodName = ProdName;
        this.prodKat = ProdKat;
        this.prodQmim = ProdQmim;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getProdName()
    {
        return prodName;
    }
    
    public String getProdKat()
    {
        return prodKat;
    }
    
    public float getProdQmim(){
        return prodQmim;
    }
}
