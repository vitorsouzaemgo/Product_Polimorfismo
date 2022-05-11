public class ImportedProduct extends Product {
    private double customsFee;
    

    public ImportedProduct(String name, double price, double customsFee){
        super(name,price);
        this.customsFee = customsFee;
    }

    public double getcustomsFee() {
		return customsFee;
	}

	public void setcustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	public double totalPrice() {
		return getPreco() + customsFee;
	}
	
	@Override
	public String priceTag() {
		return "Produtos Importados \n Nome"+getNome()+ "\n R$ "+ String.format("%.2f", totalPrice())
		+ "\n (Customs fee: R$ "+ String.format("%.2f ", customsFee)+ ")";
	}
    
}