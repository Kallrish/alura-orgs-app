package br.com.alura.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.dao.DaoProducts
import br.com.alura.orgs.databinding.ActivityProductFormBinding
import br.com.alura.orgs.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProductFormBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSaveButton()
        setContentView(binding.root)
    }

    private fun setupSaveButton() {
        val buttonSave = binding.activityProductFormBtnSave
        val daoProducts = DaoProducts()
        buttonSave.setOnClickListener {
            val newProduct = createProduct()
            daoProducts.addProducts(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldName = binding.activityProductFormName
        val name = fieldName.text.toString()
        val fieldDescription = binding.activityProductFormDescription
        val description = fieldDescription.text.toString()
        val fieldValue = binding.activityProductFormValue
        val textValue = fieldValue.text.toString()
        val value = if (textValue.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(textValue)
        }

        return Product(
            name = name,
            description = description,
            value = value
        )
    }
}