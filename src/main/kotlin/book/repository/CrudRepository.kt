package book.repository

interface CrudRepository<T, K> {
    fun createTable()
    fun create(m: T): User
    fun findAll(): Iterable<T>
    fun deleteAll(): Int
}