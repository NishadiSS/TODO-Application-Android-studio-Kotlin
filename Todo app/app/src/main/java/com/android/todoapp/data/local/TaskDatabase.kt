package com.android.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
/**
 * TaskDatabase is an abstract class representing the Room database for managing tasks.
 *
 * This class is annotated with [@Database] to indicate that it is a Room database and
 * specifies the entities it manages, the version number, and whether to export the schema.
 *
 * @property entities An array of classes annotated with [@Entity] that represent the tables in the database.
 * @property version The version number of the database. Should be incremented when making schema changes.
 * @property exportSchema Whether to export the schema to a folder. Typically used for version control.
 */
@Database(entities = [TaskEntry::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {
    /**
     * Provides access to the Data Access Object (DAO) for tasks.
     *
     * @return An instance of [TaskDao] for performing database operations on tasks.
     */

    abstract fun taskDao(): TaskDao
}