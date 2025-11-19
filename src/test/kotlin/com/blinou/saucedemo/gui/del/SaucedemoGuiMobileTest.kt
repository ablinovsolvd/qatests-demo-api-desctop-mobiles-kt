package com.blinou.saucedemo.gui.del

/**
 * SwagDemo GUI Test Automation Project
 * Author: Artyom Blinov
 * Year: 2025
 */

import com.blinou.saucedemo.del.pages.common.LoginPageBase
import com.blinou.saucedemo.gui.constants.GuiConstants.PASSWORD
import com.blinou.saucedemo.gui.constants.GuiConstants.STANDARD_USERNAME
import com.blinou.saucedemo.del.pages.common.ProductsPageBase
import com.zebrunner.agent.core.annotation.TestLabel
import com.zebrunner.carina.core.IAbstractTest
import com.zebrunner.carina.core.registrar.ownership.MethodOwner
import com.zebrunner.carina.utils.mobile.IMobileUtils
import org.testng.Assert
import org.testng.annotations.Test

class SaucedemoGuiMobileTest : IAbstractTest, IMobileUtils {

    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiMobile")
    @TestLabel(name = "feature", value = ["mobile", "regression"])
    fun testSuccessfulLogin() {
        val loginPage = initPage(LoginPageBase::class.java)
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened")

        loginPage.login(STANDARD_USERNAME, PASSWORD)
        val productsPage = initPage(ProductsPageBase::class.java)
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login")
    }


    @Test(groups = ["functional"])
    @MethodOwner(owner = "saucedemoGuiMobile")
    @TestLabel(name = "feature", value = ["mobile", "regression"])
    fun testSuccessfulLogout() {
        val loginPage = initPage(LoginPageBase::class.java)
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened")

        loginPage.login(STANDARD_USERNAME, PASSWORD)
        val productsPage = initPage(ProductsPageBase::class.java)
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened after login")

        val leftMenu = productsPage.goToLeftMenuPage()
        Assert.assertTrue(leftMenu.isPageOpened(), "Left Menu page is not opened!")

        leftMenu.clickLogoutButton()
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened after logout")
    }

}