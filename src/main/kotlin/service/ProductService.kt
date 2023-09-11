package service

import dtos.ProductRequest
import dtos.ProductResponse
import dtos.toEntity
import dtos.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import repo.ProductRepo

@Service
class ProductService(
    private val productRepo: ProductRepo
) {
    @Transactional
    fun insertProduct(productReq: ProductRequest) {
        productRepo.save(productReq.toEntity())
    }

    fun getProduct(id: Long): ProductResponse {
        val product = productRepo.findByIdOrNull(id) ?: throw IllegalStateException("상품이 없습니다.")

        return product.toResponse()
    }
}