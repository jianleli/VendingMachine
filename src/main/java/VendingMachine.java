
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    // Indicate the Machine Power ON/OFF
    boolean on;

    private Status status;

    private List<Product> products;

    // Indicate which product
    private int productIndex;

    private LED led;

    /**
     * Default Constructor
     * VM initial status is OFF
     */
    VendingMachine(){
        on = false;
        status = Status.STATUS_OFF;
        products = new ArrayList<>();
        productIndex = -1;
        led = new LED(ConstantString.EMPTY, ConstantString.EMPTY);

        setStatusOff();
    }

    /**
     * adding product to VM
     * @param product
     * @return
     */
    public boolean addProduct(Product product){
        if(status != Status.STATUS_OFF){
            System.err.println("You can only add Product when the power is OFF. ");
            return false;
        }
        products.add(product);
        return true;
    }

    public boolean powerButton(){
        if(status == Status.STATUS_AFTER_PAY){
            setStatusStartup();
            return true;
        }

        on = !on;

        // OFF
        if(on == false){
            setStatusOff();
            return true;
        }

        // ON
        setStatusStartup();
        return true;
    }


    public boolean isOn() {
        return on;
    }

    public LED getLed(){
        return this.led;
    }

    public Status getStatus(){
        return this.status;
    }

    /**
     *
     * @return
     */
    public boolean pushUpButton(){
        if(status == Status.STATUS_OFF){
            return false;
        }

        if (status == Status.STATUS_AFTER_PAY){
            setStatusStartup();
            return true;
        }

        productIndex--;
        int maxIndex = products.size() - 1;
        if(productIndex < 0){
            productIndex = maxIndex;
        }
        setStatusSelling();
        return true;
    }

    /**
     *
     * @return
     */
    public boolean pushDownButton() {
        if (status == Status.STATUS_OFF) {
            return false;
        }

        if (status == Status.STATUS_AFTER_PAY) {
            setStatusStartup();
            return true;
        }

        productIndex++;
        int maxIndex = products.size() - 1;
        if (productIndex > maxIndex) {
            productIndex = 0;
        }
        setStatusSelling();
        return true;
    }

    /**
     *  Check if it has it in the inventory
     * @return
     */
    public boolean hasInventory(){

        for(Product product : products){
            if(product.hasStock()){
                return true;
            }
        }
        return false;
    }

    private void setStatusOff(){
        status = Status.STATUS_OFF;
        led.update(ConstantString.EMPTY, ConstantString.EMPTY);
    }

    private void setStatusStartup(){
        status = Status.STATUS_STARTUP;
        // if has inventory
        if(hasInventory()){
            led.update(ConstantString.WELCOME, ConstantString.SELECT_A_PRODUCT);
            return;
        }
        // if has no inventory
        led.update(ConstantString.WELCOME, ConstantString.SOLD_OUT);
    }

    private void setStatusSelling(){
        status = Status.STATUS_SELLING;
        Product selectedProduct = products.get(productIndex);
        led.update(ConstantString.WELCOME, selectedProduct.toString());
    }

}
