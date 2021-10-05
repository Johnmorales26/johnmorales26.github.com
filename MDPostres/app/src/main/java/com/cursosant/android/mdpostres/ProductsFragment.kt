package com.cursosant.android.mdpostres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
import java.util.*

/****
 * Project: MD Postres
 * From: com.cursosant.android.mdpostres
 * Created by Alain Nicolás Tello on 01/01/21 at 14:06
 * Course: Professional Material Desing/Theming for Android, UX/UI.
 * More info: https://www.udemy.com/course/material-design-theming-diseno-profesional-para-android/
 * All rights reserved 2021.
 *
 * Others:
 * Android con Kotlin intensivo y práctico desde cero.
 * https://www.udemy.com/course/kotlin-intensivo/?referralCode=93D5D2FA6EF503FD0A6B
 */
class ProductsFragment : Fragment(), OnClickListener {
    
    private val selectedProducts: MutableList<Product?> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough()
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductsAdapter(products, this)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = adapter

        view.findViewById<View>(R.id.btnAddCar).setOnClickListener { view1: View? ->
            //NavHostFragment.findNavController(this).navigate(R.id.action_products_to_car));
            val action = ProductsFragmentDirections.actionProductsToCar()
            action.products = productsStr
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    private val products: List<Product>
        get() {
            val products: MutableList<Product> = ArrayList()
            products.add(Product("Classic",
                    "https://upload.wikimedia.org/wikipedia/commons/4/48/Dona_sencilla_mexicana.jpg"))
            products.add(Product("Glazed",
                    "https://p0.pikist.com/photos/921/203/donut-mini-donut-small-round-cake-torus-" +
                            "glaze-fat-sugar-mixture-schokoplaettchen.jpg"))
            products.add(Product("Chocolate",
                    "https://cdn.pixabay.com/photo/2017/04/13/23/35/dona-2228986__340.jpg"))
            products.add(Product("Blue Berry",
                    "https://cdn.pixabay.com/photo/2017/11/22/00/18/donuts-2969490_1280.jpg"))
            products.add(Product("Dark Chocolate",
                    "https://cdn.pixabay.com/photo/2017/04/12/21/18/dona-2225812_1280.jpg"))
            products.add(Product("Strawberry",
                    "https://live.staticflickr.com/1338/1036945312_8e12c26d99_b.jpg"))
            products.add(Product("Caramel",
                    "https://p0.pxfuel.com/preview/187/392/25/cute-sweet-tasty-delicious.jpg"))
            products.add(Product("Wine",
                    "https://cdn.pixabay.com/photo/2017/08/11/21/46/donuts-2632878__340.jpg"))
            products.add(Product("Penaut",
                    "https://cdn.pixabay.com/photo/2014/02/17/17/26/donuts-268388__340.jpg"))
            products.add(Product("Apple",
                    "https://cdn.pixabay.com/photo/2020/10/12/15/58/donuts-5649218__340.jpg"))
            products.add(Product("Special",
                    "https://live.staticflickr.com/3356/3282189390_4ba32754b6_b.jpg"))
            return products
        }

    private val productsStr: Array<String?>
        get() {
            val productsStr = arrayOfNulls<String>(selectedProducts.size)
            var index = 0
            for (product in selectedProducts) {
                productsStr[index] = product!!.name
                index++
            }
            return productsStr
        }

    override fun onClick(product: Product?) {
        if (product!!.isSelected) {
            selectedProducts.add(product)
        } else {
            selectedProducts.remove(product)
        }
    }
}