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
public class Kategorit {
private int id;
    private String prodName;
    private String pershkrimi;
    
    public Kategorit(int ID, String ProdName, String Pershkrimi)
    {
        this.id = ID;
        this.prodName = ProdName;
        this.pershkrimi = Pershkrimi;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getProdName()
    {
        return prodName;
    }
    
    public String getPershkrimi()
    {
        return pershkrimi;
    }
}
