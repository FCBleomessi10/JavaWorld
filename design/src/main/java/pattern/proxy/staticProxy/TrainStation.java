package pattern.proxy.staticProxy;

public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站买票");
    }
}
