import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product{
    String manufacturer;

    public Smartphone(){

    }

    public Smartphone(String name, String manufacturer, int price){
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
    }

}