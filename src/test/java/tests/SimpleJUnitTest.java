package tests;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {
    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n###   BeforeAll\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("###   AfterAll\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###   BeforeEach");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###   AfterEach\n");
    }

    private int getResult() {
        return 3;
    }

    @Test
    void firstTest() {
        int result = getResult();
        System.out.println("###   First Test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###   Second Test");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###   Third Test");
        Assertions.assertTrue(result > 2);
    }
}
