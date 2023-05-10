package pattern.proxy.staticProxy;

public class ProxyPoint implements SellTickets {

    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理服务费");
        trainStation.sell();
    }
}
