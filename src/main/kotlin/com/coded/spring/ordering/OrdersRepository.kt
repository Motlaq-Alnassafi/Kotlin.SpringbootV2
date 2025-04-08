package com.coded.spring.ordering

import jakarta.inject.Named
import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository

@Named
interface OrdersRepository : JpaRepository<Orders, Long>

@Entity
@Table(name = "orders")
data class Orders(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var civilId: String,
    var items: List<String>
){
    constructor() : this(null, "","", items = listOf("",""))
}