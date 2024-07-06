package ru.safronov.suits;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import ru.safronov.categories.JUnit4CustomerTest;
import ru.safronov.categories.JUnit4CustomersRepositoryTest;
import ru.safronov.categories.RepositoryTests;

@RunWith(Categories.class)
@ExcludeCategory(RepositoryTests.class)
@SuiteClasses({JUnit4CustomerTest.class, JUnit4CustomersRepositoryTest.class})
public class JUnit4ExcludeRepositorySuiteTest {

}
