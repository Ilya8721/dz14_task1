package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ShopRepositoryTest {

    Product product1 = new Product(11, "хлеб", 40);
    Product product2 = new Product(22, "яйца", 80);
    Product product3 = new Product(33, "апельсин", 50);
    Product product4 = new Product(44, "дрель", 500);
    Product product5 = new Product(22, "сосиска", 60);


    @Test
    void removeByIdTest2() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(product2.getId());

        Product[] expended = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expended, actual);
    }


    @Test
    void removeByIdTestNull() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-22);
        });
    }


    @Test
    void addProductTest() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Product[] expended = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expended, actual);
    }


    @Test
    void addProductTest0() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product5);
        });
    }
}