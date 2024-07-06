package ru.safronov.suits;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import ru.safronov.categories.IndividualTests;
import ru.safronov.categories.JUnit4CustomerTest;
import ru.safronov.categories.JUnit4CustomersRepositoryTest;

@RunWith(Categories.class)
@IncludeCategory(IndividualTests.class)
@SuiteClasses({JUnit4CustomersRepositoryTest.class, JUnit4CustomerTest.class})
public class JUnit4IndividualSuiteTest {

}
