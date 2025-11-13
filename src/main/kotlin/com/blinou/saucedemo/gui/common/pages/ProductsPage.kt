package com.blinou.saucedemo.gui.common.pages

import com.blinou.saucedemo.gui.common.pages.component.Header
import com.blinou.saucedemo.gui.common.pages.component.ProductCard
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProductsPage: AbstractPage {

    @FindBy(id = "inventory_container")
    private lateinit var inventoryContainer: ExtendedWebElement

    @FindBy(className = "inventory_item")
    private lateinit var productCards: List<ProductCard>

    @FindBy(id = "header_container")
    private lateinit var header: Header

    constructor(driver: WebDriver) : super(driver) {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
        setUiLoadedMarker(inventoryContainer)
    }

    fun isProductNamePresent(index: Int): Boolean {
        return productCards[index].isProductNamePresent()
    }

    fun isProductDescriptionPresent(index: Int): Boolean {
        return productCards[index].isProductDescriptionPresent()
    }

    fun isProductPricePresent(index: Int): Boolean {
        return productCards[index].isProductPricePresent()
    }

    fun getProductCards(): List<ProductCard> = productCards

    fun clickProductTitle(index: Int): ProductDetailsPage {
        productCards[index].clickProductName()
        return ProductDetailsPage(getDriver())
    }

    fun getHeader(): Header {
        return header

    }
}