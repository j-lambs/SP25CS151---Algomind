class Course:
    def __init__(self, course_name: str, course_info: str, course_code: int, grade_level: str):
        self.course_name = course_name
        self.course_info = course_info
        self.course_code = course_code
        self.grade_level = grade_level

    def get_course_info(self):
        return f"Course: {self.course_name} (Code: {self.course_code}) - {self.grade_level}\nInfo: {self.course_info}"

    def update_course(self, new_name=None, new_info=None, new_code=None, new_grade=None):
        if new_name:
            self.course_name = new_name
        if new_info:
            self.course_info = new_info
        if new_code:
            self.course_code = new_code
        if new_grade:
            self.grade_level = new_grade

    def __str__(self):
        return self.get_course_info()


# Example Usage:
course1 = Course("Algebra I", "Basic algebra principles", 101, "9th Grade")
print(course1)

course1.update_course(new_info="Introduction to algebra concepts and problem-solving")
print(course1)
