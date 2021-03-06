import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private static final SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufactureDate;


    public UsedProduct(String name, double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getDate(){
        return manufactureDate;
    }

    public void setDate(Date manufactureDate){
        this.manufactureDate = manufactureDate;
    }
    
    
    @Override
    public String priceTag() {
        return getName()+" (used) $ "+ String.format("%.2f", getPrice())
        + " (Manufacture date: "+ data.format(manufactureDate)+ ")";
    }
}