public class CheckoutLine {
    private CustomerNode root;
    public void setNext(){
    }
    public void addCustomer(CustomerNode customer) {
        if (root == null) {
            root = customer;
        } else {
            CustomerNode current = root;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(customer);
        }
    }
    public CustomerNode removeCustomer(String id){
        if(root == null){
            return null;
        }

        if(root.getCustomerId().equals(id)){
            CustomerNode removed = root;                                                                                                                                                                                                                  
            root = root.getNext();
            return removed;
        }

        CustomerNode current = root;
        while(current.getNext() != null){
            if(current.getNext().getCustomerId().equals(id)){
                CustomerNode removed = current.getNext();
                current.setNext(current.getNext().getNext());
                return removed;
            }
            current = current.getNext();
        }
        return null;
    }
}
