package task_2;

class OrderSystem {
    public void placeOrder(String productId, int quantity) {
        System.out.println("Заказ товара " + productId + ", количество: " + quantity);
    }
}

class PaymentSystem {
    public void processPayment(double amount) {
        System.out.println("Платеж на сумму " + amount + " обработан");
    }
}

class OrderPaymentFacade {
    private OrderSystem orderSystem;
    private PaymentSystem paymentSystem;

    public OrderPaymentFacade() {
        this.orderSystem = new OrderSystem();
        this.paymentSystem = new PaymentSystem();
    }

    public void placeOrderAndMakePayment(String productId, int quantity, double amount) {
        orderSystem.placeOrder(productId, quantity);
        paymentSystem.processPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        OrderPaymentFacade facade = new OrderPaymentFacade();
        facade.placeOrderAndMakePayment("ABC123", 3, 100.0);
    }
}