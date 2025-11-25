package com.blinou.saucedemo.mobile.pages.common


import com.zebrunner.carina.utils.mobile.IMobileUtils
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver

abstract class ProductsPageBase(driver: WebDriver) : AbstractPage(driver), IMobileUtils {

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
    }

    abstract fun goToLeftMenuPage(): LeftMenuPageBase

    abstract fun goToCartPage(): CartPageBase

    abstract fun addProductToCart(productIndex: Int)

    abstract fun clickProductTitleByIndex(productIndex: Int)
}