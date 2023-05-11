package pattern.decorator;

public class Client {
    public static void main(String[] args) {
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + " " + food.cost());
        System.out.println();

        FastFood food1 = new Egg(food);
        System.out.println(food1.cost());
        System.out.println(food1.getDesc());
        System.out.println();

        FastFood food2 = new Egg(food1);
        System.out.println(food2.cost());
        System.out.println(food2.getDesc());
        System.out.println();

        FastFood food3 = new Bacon(food2);
        System.out.println(food3.cost());
        System.out.println(food3.getDesc());
        System.out.println();
    }
}
