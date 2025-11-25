package com.blinou.saucedemo.mobile.pages.dd

import com.blinou.saucedemo.mobile.pages.common.LoginPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy
import org.openqa.selenium.WebDriver

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase::class)
class LoginPage(driver: WebDriver) : LoginPageBase(driver) {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private lateinit var usernameField: ExtendedWebElement

    @ExtendedFindBy(accessibilityId = "test-Password")
    private lateinit var passwordField: ExtendedWebElement

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private lateinit var loginButton: ExtendedWebElement

    @ExtendedFindBy(accessibilityId = "test-Error message")
    private lateinit var errorTextView: ExtendedWebElement

    init {
        setUiLoadedMarker(loginButton)
    }

    override fun typeUsername(username: String) {
        usernameField.type(username)
    }

    override fun typePassword(password: String) {
        passwordField.type(password)
    }

    override fun clickLoginButton() {
        loginButton.click()
    }

    override fun login(username: String, password: String) {
        typeUsername(username)
        typePassword(password)
        clickLoginButton()
    }

    override fun getErrorMessageText(): String {
        return errorTextView.text
    }
}