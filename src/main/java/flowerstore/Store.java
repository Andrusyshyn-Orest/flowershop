package flowerstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Flow;

@Getter
@Setter
@ToString
public class Store {
    private List<FlowerBucket> flowerBuckets;
    private List<FlowerPack> flowerPacks;
    private Map<FlowerType, List<Flower>> flowers;

    public Store() {
        flowerBuckets = new ArrayList<>();
        flowerPacks = new ArrayList<>();
        flowers = new HashMap<>();
        flowers.put(FlowerType.ROSE, new ArrayList<>());
        flowers.put(FlowerType.TULIP, new ArrayList<>());
        flowers.put(FlowerType.CHAMOMILE, new ArrayList<>());
    }

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        flowerBuckets.add(flowerBucket);
    }

    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public void addFlower(Flower flower) {
        flowers.get(flower.getFlowerType()).add(flower);
    }


    public boolean search_bucket(FlowerBucket bucket) {
        for (FlowerBucket flowerbucket: flowerBuckets) {
            if (flowerbucket.isEqual(bucket)) {
                return true;
            }
        }

        return false;
    }

    public boolean search_pack(FlowerPack pack) {
        for (FlowerPack flowerPack: flowerPacks) {
            if (flowerPack.isEqual(pack)) {
                return true;
            }
        }

        return false;
    }

    public boolean search_flower(Flower flower) {
        FlowerType type = flower.getFlowerType();

        List<Flower> flower_list = flowers.get(type);

        for (Flower my_flower: flower_list) {
            if (flower.isEqual(my_flower)) {
                return true;
            }
        }

        return false;
    }


    public boolean search(Object search_obj) {

        if (!( (search_obj instanceof FlowerBucket) || (search_obj instanceof FlowerPack)
                                        || (search_obj instanceof Flower))) {
            return false;
        }

        if (search_obj instanceof FlowerBucket) {
            return search_bucket((FlowerBucket) search_obj);
        } else if (search_obj instanceof FlowerPack){
            return search_pack((FlowerPack) search_obj);
        } else {
            return search_flower((Flower) search_obj);
        }

    }


}
