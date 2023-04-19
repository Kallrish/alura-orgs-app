package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Product

class DaoProducts {

    fun addProducts(product: Product) {
        products.add(product)
    }

    fun searchAllProducts() : List<Product> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Product>()
    }
}