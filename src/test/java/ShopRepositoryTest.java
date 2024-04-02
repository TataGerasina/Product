import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {


    @Test
    public void ShouldRemoveExistentElement() {  // удаление существующего элемента
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "молоко", 74);
        Product product2 = new Product(18, "яблоки", 200);
        Product product3 = new Product(94, "бананы", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(94);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    //@Test
//    public void ShouldRemoveNotExistentElement() {  // удаление Несуществующего элемента
//        ShopRepository repo = new ShopRepository();
//        Product product1 = new Product(15, "молоко", 74);
//        Product product2 = new Product(18, "яблоки", 200);
//        Product product3 = new Product(94, "бананы", 150);
//
//        repo.add(product1);
//        repo.add(product2);
//        repo.add(product3);
//        repo.remove(1009);
//
//        Product[] actual = repo.findAll();
//        Product[] expected = {product1, product2, product3};
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void ShouldRemoveNotExistentProduct() {  // удаление Несуществующего продукта
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(15, "молоко", 74);
        Product product2 = new Product(18, "яблоки", 200);
        Product product3 = new Product(94, "бананы", 150);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(1009)
        );
    }
}