package com.android.todoapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
/**
 * TaskDao is a Data Access Object (DAO) interface for performing database operations on tasks.
 *
 * This interface is annotated with [@Dao] to indicate that it is a Room DAO.
 */
@Dao
interface TaskDao {
    /**
     * Inserts a new task entry into the database.
     *
     * @param taskEntry The task entry to be inserted.
     */
    @Insert
    suspend fun insert(taskEntry: TaskEntry)

    /**
     * Deletes a task entry from the database.
     *
     * @param taskEntry The task entry to be deleted.
     */
    @Delete
    suspend fun delete(taskEntry: TaskEntry)

    /**
     * Updates an existing task entry in the database.
     *
     * @param taskEntry The updated task entry.
     */
    @Update
    suspend fun update(taskEntry: TaskEntry)

    /**
     * Deletes all task entries from the database.
     */
    @Query("DELETE FROM task_table")
    suspend fun deleteAll()

    /**
     * Retrieves all tasks from the database, ordered by timestamp in descending order.
     *
     * @return A [Flow] of lists of task entries.
     */

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    fun getAllTasks(): Flow<List<TaskEntry>>
    /**
     * Retrieves all tasks from the database, ordered by priority in ascending order.
     *
     * @return A [Flow] of lists of task entries.
     */

    @Query("SELECT * FROM task_table ORDER BY priority ASC")
    fun getAllPriorityTasks(): Flow<List<TaskEntry>>
    /**
     * Searches the database for task entries with titles matching the given search query,
     * ordered by timestamp in descending order.
     *
     * @param searchQuery The search query to match against task titles.
     * @return A [LiveData] of lists of task entries.
     */

    @Query("SELECT * FROM task_table WHERE title LIKE :searchQuery ORDER BY timestamp DESC")
    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>>
}