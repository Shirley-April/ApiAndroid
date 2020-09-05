package activities

import ke.co.hello.models.Course
import models.Course

interface CourseItemClickListener {
    fun onItemClick(course: Course)
}