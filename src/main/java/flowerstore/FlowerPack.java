package flowerstore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack {
    private Flower flower;
    private int amount;

    public double getPrice() {
        return flower.getPrice() * amount;
    }

    public boolean isEqual(FlowerPack otherFlowerPack) {
        if ((this.getFlower().isEqual(otherFlowerPack.getFlower())) &&
                (this.getAmount() == otherFlowerPack.getAmount())) {
            return true;
        }

        return false;
    }
}
