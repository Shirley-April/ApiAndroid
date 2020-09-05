package databases

import androidx.room.Database
import androidx.room.RoomDatabase
import databases.CourseDao
import ke.co.hello.models.Course
import models.Course

@Database(entities = arrayOf(Course::class), version = 1)
abstract class HelloDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}