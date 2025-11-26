package com.blinou.saucedemo.mobile.pages.ios

import com.blinou.saucedemo.mobile.pages.common.CartPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy
import org.openqa.selenium.WebDriver

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase::class)
class CartPage(driver: WebDriver) : CartPageBase(driver) {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'YOUR CART'`]")
    private lateinit var cartPageHeader: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`][%d]/XCUIElementTypeStaticText")
    private lateinit var productTitle: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`][%d]/XCUIElementTypeStaticText[2]")
    private lateinit var productDescription: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Price'`][%d]/XCUIElementTypeStaticText")
    private lateinit var productPrice: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Amount'`][%d]/XCUIElementTypeStaticText")
    private lateinit var productQty: ExtendedWebElement

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private lateinit var removeButton: ExtendedWebElement

    init {
        setUiLoadedMarker(cartPageHeader)
    }

    override fun getProductTitle(productIndex: Int): String {
        return productTitle.format(productIndex).text
    }

    override fun getProductDescription(productIndex: Int): String {
        return productDescription.format(productIndex).text
    }

    override fun getProductPrice(productIndex: Int): String {
        return productPrice.format(productIndex).text
    }

    override fun getProductQty(productIndex: Int): Int {
        val qty: String = productQty.format(productIndex).text
        return qty.toIntOrNull() ?: 0
    }

    override fun removeProductFromCart(productIndex: Int) {
        removeButton.format(productIndex)?.click()
    }

    override fun isProductPresent(productIndex: Int): Boolean {
        return productTitle.format(productIndex)?.isElementPresent ?: false
    }
}