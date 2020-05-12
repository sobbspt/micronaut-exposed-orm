package user.repository

interface CrudRepository<T, K> {
    fun createTable()
    fun create(m: T): T
    fun findById(id: K): T
    fun findAll(): Iterable<T>
    fun deleteAll(): Int
}