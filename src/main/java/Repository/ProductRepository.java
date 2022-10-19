package Repository;

import Domain.Product;

public class ProductRepository {
    private Product[] product = new Product[0];

    public Product[] getAll(){
       return product;
    }

    //Не работает метод
   public void saveProduct(Product saveProduct){
        int productsLength = product.length + 1;
        Product[] products = new Product[productsLength];
        System.arraycopy(product,0,products,0,productsLength);
        int lastIndex = productsLength - 1;
        products[lastIndex] = saveProduct;
        product = products;
    }

    void deleteById(int id){
        int productLength = product.length - 1;
        Product[] products = new Product[productLength];
        int index = 0;
        for(Product product : product){
            if(product.getId() != id){
                products[index] = product;
                index++;
            }
        }
        product = products;
    }

}