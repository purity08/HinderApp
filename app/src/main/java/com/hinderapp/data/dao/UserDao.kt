package com.hinderapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hinderapp.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}