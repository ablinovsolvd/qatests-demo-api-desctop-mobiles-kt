package com.blinou.saucedemo.del.pages.common


import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver

abstract class ProductsPageBase(driver: WebDriver) : AbstractPage(driver) {

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
    }

    abstract fun goToLeftMenuPage(): LeftMenuPageBase

    abstract fun goToCartPage(): CartPageBase

    abstract fun addProductToCart(productIndex: Int)

    abstract fun clickProductTitleByIndex(productIndex: Int)
}