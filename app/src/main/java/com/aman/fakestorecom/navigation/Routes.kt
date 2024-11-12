package com.aman.fakestorecom.navigation

object Routes {
    const val LOGIN_SCREEN = "login"
    const val SIGNUP_SCREEN = "signup"
    const val FORGET_PASSWORD_SCREEN = "forgetpassword"
    const val HOME_SCREEN = "home"
    const val PRODUCT_LIST_SCREEN = "productlist"
    const val SHOP_SCREEN = "shop"
    const val BAG_SCREEN = "bag"
    const val FAVORITE_SCREEN = "favorite"
    const val PROFILE_SCREEN = "profile"

    const val ITEM_DISPLAY_SCREEN = "itemdisplay/{productId}"
    fun itemDetailScreenRoute(productId: Int) = "itemdisplay/$productId"

    const val CHECKOUT_SCREEN = "checkout"
    const val SUCCESS_SCREEN = "success"
    const val PAYMENT_SCREEN = "payment"

    const val PRODUCT_DETAIL_SCREEN = "productdetail/{productId}"
    fun productDetailScreenRoute(productId: Int) = "productdetail/$productId"

    const val SHOP_CAT_LIST_SCREEN = "shopcatlistlistscreen"

    const val MY_ORDERS_PAGE = "myorders"

    const val ORDER_DETAILS_PAGE = "orderdetails"
    const val SETTING_SCREEN = "setting"
    const val MY_PROFILE_DETAIL_SCREEN ="myprofile"
    const val ADD_SHIPPING_ADDRESS_SCREEN = "addshippingaddress"
    const val SHIPPING_ADDRESS_SCREEN = "shippingaddress"
    const val SEARCH_SCREEN = "searchscreen"

}