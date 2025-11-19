package com.blinou.saucedemo.del.pages.android

/**
 * SwagDemo GUI Test Automation Project
 * Author: Artyom Blinov
 * Year: 2025
 */

import com.blinou.saucedemo.del.pages.common.LoginPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.utils.factory.DeviceType.Type.ANDROID_PHONE
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

@DeviceType(pageType = ANDROID_PHONE, parentClass = LoginPageBase::class)
class LoginPage(driver: WebDriver) : LoginPageBase(driver) {

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private lateinit var usernameField: ExtendedWebElement

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private lateinit var passwordField: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private lateinit var loginButton: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
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