package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrdersController(
    val ordersRepository: OrdersRepository
){

    @GetMapping("/my-orders")
    fun printOrders() : MutableList<Orders> {
        return ordersRepository.findAll()
    }

    @PostMapping("/my-orders")
    fun myOrders(
        @RequestBody request: MyOrdersRequeset
    ) = ordersRepository.save(Orders(name = request.name,
                                    civilId = request.civilId,
                                    items = request.items))
}

data class MyOrdersRequeset(
    val name: String,
    val civilId: String,
    var items: List<String>
)