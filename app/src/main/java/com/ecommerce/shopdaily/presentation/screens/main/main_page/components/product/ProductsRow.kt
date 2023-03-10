package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.product

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.screen.Loading
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_page.ProductType
import com.ecommerce.shopdaily.presentation.screens.main.util.product.ProductBaseState
import com.ecommerce.shopdaily.presentation.screens.main.util.product.ProductEvent
import com.ecommerce.shopdaily.presentation.screens.product.AddToCartActivity
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants

@Composable
fun ProductsRow(
    productType: ProductType,
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    var chosenProduct: Product? = null
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val result = activityResult.data?.getBooleanExtra(Constants.ADD_TO_CART, false)
            if (result == true) {
                chosenProduct?.let { product ->
                    viewModel.addProduct(product)
                }
            }
            viewModel.onProductEvent(ProductEvent.GetFavorites)
        }
    }

    val currentState: ProductBaseState = when (productType) {
        is ProductType.New -> viewModel.newProductsState
        is ProductType.Sale -> viewModel.saleProductsState
    }

    if (currentState.isLoading) {
        Loading(modifier = Modifier.fillMaxSize())
    } else {
        currentState.products?.let { products ->
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(products) { product ->
                    ProductCard(
                        viewModel = viewModel,
                        product = product,
                        onProductClick = { chosenProd ->
                            chosenProduct = chosenProd
                            val intent = Intent(context, AddToCartActivity::class.java).apply {
                                putExtra(Constants.PRODUCT, chosenProduct)
                            }
                            launcher.launch(intent)
                        })
                }
            }
        }
    }
}