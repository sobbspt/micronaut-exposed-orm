package user.repository

import user.model.UserDomain


interface UserRepository : CrudRepository<UserDomain, Int>
