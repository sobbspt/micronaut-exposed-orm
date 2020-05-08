package user.repository

import user.model.UserResponse

interface CrudRepository<T, K> {
    fun createTable()
    fun create(m: T): UserResponse
    fun findAll(): Iterable<T>
    fun deleteAll(): Int
}