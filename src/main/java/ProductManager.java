
public class ProductManager {
    private Product[] products = new Product[0];

    private Product[] sortedProducts = new Product[0];

    private  ProductRepository repository;

        public Product[] searchBy(String text) {
        Product[] products1 = repository.getAll();
        Product[] products = new Product[0];
        int elements = 0;
        for (Product product : products1) {
                if (matchesBy(product, text)) {
                    Product[]tmp = new Product[products.length + 1];
                    System.arraycopy(products, 0, tmp, 0, elements);
                    tmp[tmp.length - 1] = product;
                    products = tmp;
                    elements++;
                }
            }
            return products;
    }

    public boolean matchesBy(Product product,String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getAuthor().contains(search)) {
                return true;
            }
            if (book.getName().contains(search)) {
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone){
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getManufacturer().contains(search)){
                return true;
            }
            if (smartphone.getName().contains(search)){
                return true;
            }
            return false;
        }
        return false;
    }

    public void add(Product product){
        int productsLength = products.length + 1;
        Product[] products1 = new Product [productsLength];
        for(int i = 0; i < products.length; i++){
            products1[i] = products[i];
        }
        int lastIndex = products1.length-1;
        products1[lastIndex] = product;
        products = products1;
    }

}