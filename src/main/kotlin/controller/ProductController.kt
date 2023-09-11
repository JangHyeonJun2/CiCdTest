package controller

import dtos.ProductRequest
import dtos.ProductResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import service.ProductService

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {
    @PostMapping()
    fun addProduct(@RequestBody productRequest: ProductRequest) {
        productService.insertProduct(productRequest)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id") id: Long): ProductResponse {
        return productService.getProduct(id)
    }
}