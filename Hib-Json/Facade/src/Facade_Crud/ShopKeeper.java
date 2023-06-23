package Facade_Crud;

public class ShopKeeper {

    private Iphone iphone;  
    private Samsung samsung;  
    private Vivo vivo; 
    
    public ShopKeeper(){  
        iphone= new Iphone();  
        samsung=new Samsung();  
        vivo=new Vivo();  
    }  
    
    public void iphoneSale() {
    	iphone.modelNo();
    	iphone.price();
    	Facade.runAgain();
    }
    
    public void samsungSale() {
    	samsung.modelNo();
    	samsung.price();
    	Facade.runAgain();
    }
    
    public void vivoSale() {
    	vivo.modelNo();
    	vivo.price();
    	Facade.runAgain();
    }
    
}
