package exam.task1;

public class OrderService {
    private final Object object = new Object();
    int orderCount;

    public void increaseOrderCount() {
        synchronized (object) {
            this.orderCount += 1;
        }
    }

    public int getOrderCount() {
        return orderCount;
    }

    public static void main(String[] args) throws InterruptedException {
        OrderService orderService = new OrderService();
        for (int i = 0; i < 20_000; i++) {
            new Thread(orderService::increaseOrderCount).start();
        }

        Thread.sleep(1000);

        System.out.println("orderService.getOrderCount() = " + orderService.getOrderCount());
    }

}
