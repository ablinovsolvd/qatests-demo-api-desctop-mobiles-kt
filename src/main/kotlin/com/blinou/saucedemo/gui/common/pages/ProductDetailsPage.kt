package com.blinou.saucedemo.gui.common.pages

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProductDetailsPage(driver: WebDriver): AbstractPage(driver) {

    @FindBy(className = "inventory_details_name")
    private lateinit var productName: ExtendedWebElement

    @FindBy(className = "inventory_details_desc")
    private lateinit var productDescription: ExtendedWebElement

    @FindBy(className = "price")
    private lateinit var productPrice: ExtendedWebElement

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
        setUiLoadedMarker(productName)
    }

    fun getProductName(): String = productName.text

    fun getProductDescription(): String = productDescription.text

    fun getProductPrice(): String = productPrice.text
}