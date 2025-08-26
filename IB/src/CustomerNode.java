public class CustomerNode {
    private String customerId;
    private int items;
    private CustomerNode next;


    public CustomerNode(String id, int items){
        this.customerId=id;
        this.items = items;
        this.next = null;
    }
    public String getCustomerId(){
        return customerId;
    }
    public CustomerNode getNext(){
        return next;
    }
    public void setNext(CustomerNode customerNode){
        next= customerNode;
    }

}