import com.alexdoff.productcrud.ProductApiInterface
import com.alexdoff.productcrud.RetrofitInstance

class ProductRepo {
    var client: ProductApiInterface = RetrofitInstance.api

    suspend fun getAllProducts() = client.getAllProduct()
    sus
}