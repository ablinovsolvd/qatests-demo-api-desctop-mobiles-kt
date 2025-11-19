package com.blinou.saucedemo.del.pages.android

import com.blinou.saucedemo.del.pages.common.LeftMenuPageBase
import com.blinou.saucedemo.del.pages.common.LoginPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.utils.factory.DeviceType.Type.ANDROID_PHONE
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

@DeviceType(pageType = ANDROID_PHONE, parentClass = LeftMenuPageBase::class)
class LeftMenuPage(driver: WebDriver) : LeftMenuPageBase(driver) {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Close']")
    private lateinit var closePageButton: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ALL ITEMS']")
    private lateinit var allItemsButton: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGOUT']")
    private lateinit var logoutButton: ExtendedWebElement


    init {
        setUiLoadedMarker(allItemsButton)
    }

    override fun clickLogoutButton(): LoginPageBase {
        logoutButton.click()
        return initPage(LoginPageBase::class.java)
    }
}