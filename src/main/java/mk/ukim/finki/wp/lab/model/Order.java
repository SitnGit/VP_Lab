package mk.ukim.finki.wp.lab.model;

public class Order {
    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAdress;
    private Long orderId;

    public Order(String balloonColor, String balloonSize, String clientName, String clientAdress, Long orderId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.orderId = orderId;
    }
}
