package user.repository

import user.model.User


interface UserRepository : CrudRepository<User, Int>
