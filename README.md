GROUP MEMBERS: 

CLASSES:
-Courses
  Attributes: CourseName (String) , CourseInfo (String), CourseCode (int), grade_level (String)
  Methods: get_course_info() , add_course(), remove_course(), update_course()
  
-Employees
  Attributes: 
  Methods: () , (), (), ()
  
-Tutor
  Attributes: tutorName (String) , availability (), rating (double/float), email(string), phoneno (int), courses_teaching
  Methods: get_tutor_info() , schedule_session(), update_session(), view_session()
  
-Student
  Attributes: studentName (String), courses_taken, phoneno(int), email (string), grade_level (string)
  Methods: get_student_info() , view_courses(), (), ()
  
-Management
  Attributes: managerName (String), 
  Methods: hire_tutor() , create_lesson(), manager_info(), ()
  
-Session
 Attributes: 
 Methods: session_details() , (), (), ()
