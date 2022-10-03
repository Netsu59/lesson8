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
    private ProductManager productManager;

    private Book book1 = new Book("С.Моэм","Луна и грош",300);
    private Book book2 = new Book("Ф.Достоевский","Идиот",200);
    private Smartphone smartphone1 = new Smartphone("Pixel 3a","Google",20000);
    private Smartphone smartphone2 = new Smartphone("Pixel 4a", "Google",30000);

    @Test void searchManufacturer(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{smartphone1,smartphone2};
        Product[] actual = productManager.searchBy("Google");
        assertArrayEquals(expected,actual);
    }

    @Test void searchAuthor(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{book2};
        Product[] actual = productManager.searchBy("Ф.Достоевский");
        assertArrayEquals(expected,actual);
    }

    @Test void searchBookName(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{book1};
        Product[] actual = productManager.searchBy("Луна и грош");
        assertArrayEquals(expected,actual);
    }

    @Test void searchSmartphoneName(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = productManager.searchBy("Pixel 3a");
        assertArrayEquals(expected,actual);
    }

    @Test void searchNotExisted(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy("qwe");
        assertArrayEquals(expected,actual);
    }

    @Test void searchSmartphoneNameNumber(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{smartphone1};
        Product[] actual = productManager.searchBy("3");
        assertArrayEquals(expected,actual);
    }

    @Test void searchSmartphoneNameBigLetter(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{smartphone1,smartphone2};
        Product[] actual = productManager.searchBy("P");
        assertArrayEquals(expected,actual);
    }

    @Test void searchSmartphoneNameSmallLetter(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{smartphone1,smartphone2};
        Product[] actual = productManager.searchBy("i");
        assertArrayEquals(expected,actual);
    }

    @Test void searchBookNameDot(){
        Product[] returned = new Product[]{book1,book2,smartphone1,smartphone2};
        doReturn(returned).when(productRepository).getAll();

        Product[] expected = new Product[]{book1,book2};
        Product[] actual = productManager.searchBy(".");
        assertArrayEquals(expected,actual);
    }

}