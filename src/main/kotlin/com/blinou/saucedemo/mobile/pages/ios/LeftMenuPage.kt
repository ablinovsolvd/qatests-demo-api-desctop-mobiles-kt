package com.blinou.saucedemo.mobile.pages.ios

import com.blinou.saucedemo.mobile.pages.common.LeftMenuPageBase
import com.blinou.saucedemo.mobile.pages.common.LoginPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy
import org.openqa.selenium.WebDriver

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LeftMenuPageBase::class)
class LeftMenuPage(driver: WebDriver) : LeftMenuPageBase(driver) {

    @ExtendedFindBy(accessibilityId = "test-Close")
    private val closePageButton: ExtendedWebElement? = null

    @ExtendedFindBy(accessibilityId = "test-ALL ITEMS")
    private val allItemsButton: ExtendedWebElement? = null

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private val logoutButton: ExtendedWebElement? = null

    init {
        setUiLoadedMarker(allItemsButton)
    }

    override fun clickLogoutButton(): LoginPageBase {
        logoutButton?.click()
        return initPage(LoginPageBase::class.java)
    }
}