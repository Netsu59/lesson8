import Domain.Book;
import Domain.Product;
import Domain.Smartphone;
import Manager.ProductManager;
import Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class ProductSearchTest {

    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductManager productManager = new ProductManager(productRepository);

    private Book book1 = new Book("Google","Как тестирует в Google",300);
    private Book book2 = new Book("Matt Gypps","Pixel perfect precision",200);
    private Smartphone smartphone1 = new Smartphone("Pixel 3a","Google",20000);
    private Smartphone smartphone2 = new Smartphone("Pixel 4a", "Google",30000);


    //Исправить тест
    @Test void shouldAddItems(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product book = new Book("Сомерсэт Моэм","Луна и грош",400);
        productManager.add(book);

        Product[] expected = new Product[]{book};
        Product[] actual = productManager.searchBy("Луна и грош");
        assertArrayEquals(expected,actual);
    }


    @Test void searchSmartphoneManufacturerAndBookAuthor(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{book1, smartphone1, smartphone2};
        Product[] actual = productManager.searchBy("Google");
        assertArrayEquals(expected,actual);
    }

    @Test void searchSmartphoneNameAndBookName(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{book2,smartphone1,smartphone2};
        Product[] actual = productManager.searchBy("Pixel");
        assertArrayEquals(expected,actual);
    }

    @Test void searchNotExisted(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("qwe");
        assertArrayEquals(expected,actual);
    }


}