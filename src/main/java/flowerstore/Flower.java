package flowerstore;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.Arrays;

@Getter
@Setter
@ToString
public class Flower {
    private double price;
    private double sepalLength;
    private byte[] color;
    // rgb -128 to 127

    private FlowerType flowerType;

    public void setColor(byte[] color){
        this.color = Arrays.copyOf(color, color.length);
    }

    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public boolean isEqual(Flower otherFlower) {

        if ((this.getFlowerType() == otherFlower.getFlowerType() ) &&
                (Arrays.equals(this.getColor(), otherFlower.getColor())) &&
                (this.getSepalLength() == otherFlower.getSepalLength())) {
            return true;
        }

        return false;
    }

}
