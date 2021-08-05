public class Product {
    private String productName;
    private double productPrice;
    private int numberInStock;

    public Product(String productName, double productPrice, int numberInStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.numberInStock = numberInStock;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getNumberInStock() {
        return numberInStock;
    }

    public void decreaseStock(){
        if(numberInStock == 0){
            return;
        }
        numberInStock--;
    }

    public boolean hasStock(){
        if (numberInStock > 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = productName + " $ " + productPrice;
        if (numberInStock == 0){
            str += " Sold Out";
        }
        return str;
    }


}
