package Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    String author;

    public Book(String author,String name, int price){
        this.author = author;
        this.name = name;
        this.price = price;
    }

    public Book(){

    }

}