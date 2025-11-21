package com.blinou.saucedemo.mobile.pages.common

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver

abstract class LeftMenuPageBase(driver: WebDriver) : AbstractPage(driver) {

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
    }

    abstract fun clickLogoutButton(): LoginPageBase
}