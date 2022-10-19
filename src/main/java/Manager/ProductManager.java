package Manager;
import Domain.Product;
import Domain.Book;
import Domain.Smartphone;
import Repository.ProductRepository;


public class ProductManager {
    private Product[] products = new Product[0];

    ProductManager (ProductRepository repository){
        this.repository = repository;

    }

    private ProductRepository repository;

        public Product[] searchBy(String text) {
        Product[] repositoryProducts = repository.getAll();
        Product[] products = new Product[0];
        int elements = 0;
        for (Product product : repositoryProducts) {
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

    public boolean matchesBy(Product product, String search) {
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
        repository.saveProduct(product);
    }

}