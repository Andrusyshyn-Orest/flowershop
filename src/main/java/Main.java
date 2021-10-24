import flowerstore.*;

public class Main {
    public static void main(String[] args) {
        byte[] color1 = {127, 0, 0};
        Flower flower1 = new Flower(FlowerType.ROSE);
        flower1.setColor(color1);
        flower1.setPrice(10);
        flower1.setSepalLength(10);

        byte[] color2 = {127, 127, 0};
        Flower flower2 = new Flower(FlowerType.TULIP);
        flower2.setColor(color2);
        flower2.setPrice(5);
        flower2.setSepalLength(7);

        byte[] color3 = {127, 127, 127};
        Flower flower3 = new Flower(FlowerType.CHAMOMILE);
        flower3.setColor(color3);
        flower3.setPrice(2);
        flower3.setSepalLength(3);

        Store store = new Store();

        store.addFlower(flower1);
        store.addFlower(flower2);
        store.addFlower(flower3);

        FlowerPack pack1 = new FlowerPack();
        pack1.setFlower(flower1);
        pack1.setAmount(10);

        FlowerPack pack2 = new FlowerPack();
        pack2.setFlower(flower2);
        pack2.setAmount(1);

        FlowerPack pack3 = new FlowerPack();
        pack3.setFlower(flower3);
        pack3.setAmount(5);

        store.addFlowerPack(pack1);
        store.addFlowerPack(pack2);
        store.addFlowerPack(pack3);

        FlowerBucket buck1 = new FlowerBucket();
        buck1.addFlowerPack(pack1);

        FlowerBucket buck2 = new FlowerBucket();
        buck2.addFlowerPack(pack1);
        buck2.addFlowerPack(pack2);

        FlowerBucket buck3 = new FlowerBucket();
        buck3.addFlowerPack(pack1);
        buck3.addFlowerPack(pack2);
        buck3.addFlowerPack(pack3);

        store.addFlowerBucket(buck1);
        store.addFlowerBucket(buck2);
        store.addFlowerBucket(buck3);

        System.out.println(store);

        // flowerx in store and flowery not in store

        byte[] colorx = {127, 0, 0};
        Flower flowerx = new Flower(FlowerType.ROSE);
        flowerx.setColor(colorx);
        flowerx.setPrice(100);
        flowerx.setSepalLength(10);

        byte[] colory = {127, 1, 0};
        Flower flowery = new Flower(FlowerType.ROSE);
        flowery.setColor(colory);
        flowery.setPrice(10);
        flowery.setSepalLength(10);

        System.out.println(store.search(flowerx));   // true
        System.out.println(store.search(flowery));   // false

        // packx in store and packy not in store
        FlowerPack packx = new FlowerPack();
        packx.setFlower(flowerx);
        packx.setAmount(10);

        FlowerPack packy = new FlowerPack();
        packy.setFlower(flowerx);
        packy.setAmount(1);

        System.out.println(store.search(packx)); // true
        System.out.println(store.search(packy)); // false

        // bucketx in store and buckety not in store

        FlowerBucket buckx = new FlowerBucket();
        buckx.addFlowerPack(packx);
        buckx.addFlowerPack(pack2);
        buckx.addFlowerPack(pack3);

        FlowerBucket bucky = new FlowerBucket();
        bucky.addFlowerPack(packy);
        bucky.addFlowerPack(pack2);
        bucky.addFlowerPack(pack3);


        System.out.println(store.search(buckx)); // true
        System.out.println(store.search(bucky)); // false
    }
}
