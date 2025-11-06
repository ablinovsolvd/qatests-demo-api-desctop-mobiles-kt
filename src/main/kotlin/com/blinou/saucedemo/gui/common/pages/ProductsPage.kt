package com.blinou.saucedemo.gui.common.pages

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

class ProductsPage: AbstractPage {

    @FindBy(id = "inventory_container")
    private lateinit var inventoryContainer: ExtendedWebElement

    constructor(driver: WebDriver) : super(driver) {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
        setUiLoadedMarker(inventoryContainer)
    }
}