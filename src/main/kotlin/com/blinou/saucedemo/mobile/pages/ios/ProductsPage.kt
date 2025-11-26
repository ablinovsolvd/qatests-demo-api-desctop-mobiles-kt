package com.blinou.saucedemo.mobile.pages.ios


import com.blinou.saucedemo.mobile.pages.common.CartPageBase
import com.blinou.saucedemo.mobile.pages.common.LeftMenuPageBase
import com.blinou.saucedemo.mobile.pages.common.ProductsPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase::class)
class ProductsPage(driver: WebDriver) : ProductsPageBase(driver) {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'PRODUCTS'`]")
    private lateinit var headerTitle: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Item title'`][%d]")
    private lateinit var productTitleByIndex: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`][%d]")
    private lateinit var addToCartButton: ExtendedWebElement

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private lateinit var leftMenuButton: ExtendedWebElement

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]")
    private lateinit var cartIcon: ExtendedWebElement

    init {
        setUiLoadedMarker(headerTitle)
    }

    override fun goToLeftMenuPage(): LeftMenuPageBase {
        clickOnElementBottomRight(leftMenuButton)
        return initPage(LeftMenuPageBase::class.java)
    }

    override fun goToCartPage(): CartPageBase {
        clickOnElementBottomRight(cartIcon)
        return initPage(CartPageBase::class.java)
    }

    override fun clickProductTitleByIndex(productIndex: Int) {
        productTitleByIndex.format(productIndex).click()
    }

    override fun addProductToCart(productIndex: Int) {
        addToCartButton.format(productIndex).click()
    }

    private fun clickOnElementBottomRight(element: WebElement) {
        val location = element.location
        val size = element.size

        val clickX = location.getX() + size.getWidth() - 1
        val clickY = location.getY() + size.getHeight() - 1

        tap(clickX, clickY)
        element.click()
    }
}