package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.DaoProducts
import br.com.alura.orgs.databinding.ActivityProductsListBinding
import br.com.alura.orgs.ui.recyclerview.adapter.AdapterProductList

class ProductsListActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProductsListBinding.inflate(layoutInflater)
    }
    private val dao = DaoProducts()
    private val adapter = AdapterProductList(context = this, products = dao.searchAllProducts())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        setupFab()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.searchAllProducts())

    }

    private fun setupFab() {
        val fabAddProduct = binding.activityProductListFabAddProduct
        fabAddProduct.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, ProductFormActivity::class.java)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        val rvProductList = binding.activityProductListProductList
        rvProductList.adapter = adapter

    }
}