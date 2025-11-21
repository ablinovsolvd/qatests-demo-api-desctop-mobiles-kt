package com.blinou.saucedemo.mobile.pages.android


import com.blinou.saucedemo.mobile.pages.common.CartPageBase
import com.blinou.saucedemo.mobile.pages.common.LeftMenuPageBase
import com.blinou.saucedemo.mobile.pages.common.ProductsPageBase
import com.zebrunner.carina.utils.factory.DeviceType
import com.zebrunner.carina.utils.factory.DeviceType.Type.ANDROID_PHONE
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy

@DeviceType(pageType = ANDROID_PHONE, parentClass = ProductsPageBase::class)
class ProductsPage(driver: WebDriver) : ProductsPageBase(driver) {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-PRODUCTS']")
    private lateinit var productGrid: ExtendedWebElement

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-Item'])[%d]/android.view.ViewGroup/android.widget.TextView")
    private lateinit var productTitleByIndex: ExtendedWebElement

    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[%d]")
    private lateinit var addToCartButton: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private lateinit var cartIcon: ExtendedWebElement

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private lateinit var leftMenuButton: ExtendedWebElement

    init {
        setUiLoadedMarker(productGrid)
    }

    override fun goToLeftMenuPage(): LeftMenuPageBase {
        leftMenuButton.click()
        return initPage(LeftMenuPageBase::class.java)
    }

    override fun goToCartPage(): CartPageBase {
        cartIcon.click()
        return initPage(CartPageBase::class.java)
    }

    override fun clickProductTitleByIndex(productIndex: Int) {
        productTitleByIndex.format(productIndex)?.click()
    }

    override fun addProductToCart(productIndex: Int) {
        addToCartButton.format(productIndex)?.click()
    }
}