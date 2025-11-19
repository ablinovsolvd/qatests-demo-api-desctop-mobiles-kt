package com.blinou.saucedemo.del.pages.common

/**
 * SwagDemo GUI Test Automation Project
 * Author: Artyom Blinov
 * Year: 2024
 */

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy
import com.zebrunner.carina.webdriver.gui.AbstractPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

abstract class LoginPageBase(driver: WebDriver) : AbstractPage(driver) {

    @FindBy(xpath = "//button[text()='Agree and proceed']")
    private lateinit var acceptCookies: ExtendedWebElement

    init {
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT)
    }

    abstract fun typeUsername(username: String)

    abstract fun typePassword(password: String)

    abstract fun clickLoginButton()

    abstract fun login(username: String, password: String)

    abstract fun getErrorMessageText(): String
}