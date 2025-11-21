package com.blinou.saucedemo.mobile.pages.common


import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver

abstract class CartPageBase(driver: WebDriver) : AbstractPage(driver) {

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
    }

    abstract fun getProductTitle(productIndex: Int): String

    abstract fun getProductDescription(productIndex: Int): String

    abstract fun getProductPrice(productIndex: Int): String

    abstract fun getProductQty(productIndex: Int): Int

    abstract fun removeProductFromCart(productIndex: Int)

    abstract fun isProductPresent(productIndex: Int): Boolean
}