package com.blinou.saucedemo.gui.common.pages.component

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.gui.AbstractUIObject
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProductCard (
    driver: WebDriver,
    searchContext: SearchContext
) : AbstractUIObject(driver, searchContext) {

    @FindBy(className = "inventory_item_name")
    private lateinit var productName: ExtendedWebElement

    @FindBy(className = "inventory_item_desc")
    private lateinit var productDescription: ExtendedWebElement

    @FindBy(className = "inventory_item_price")
    private lateinit var productPrice: ExtendedWebElement

    fun getProductName(): String = productName.text

    fun getProductDescription(): String = productDescription.text

    fun getProductPrice(): String = productPrice.text

    fun isProductNamePresent(): Boolean = productName.isElementPresent

    fun isProductDescriptionPresent(): Boolean = productDescription.isElementPresent

    fun isProductPricePresent(): Boolean = productPrice.isElementPresent

    fun clickProductName() {
        productName.click()
    }
}