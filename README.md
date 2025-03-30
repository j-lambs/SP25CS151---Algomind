## Group Name: Algomind

## Group Members: Jack Rellamas , Mccay Rhodebeck , Bhavya Vatsavayi & Karamjeet Kaur

## PROJECT TITLE: The Algomind Tutor Center

Overview : We have developed a Java-based application designed to streamline the operations of a tutoring center. It allows managers, tutors and Students to access their respective menu, in which they can view information about the courses, students, sessions, tutors etc. There has been an increase in tutor center so this program might be useful and applicable in real-life.

---
## CLASSES:
-Courses
    Attributes:
      private String courseName;
      private String courseSummary;
      private int courseCode;
      private int gradeLevel;
      private String instructor;
      private List<Student> students;

  Methods: 
      other than getter and setter methods
      displayCourseInfo()
      enrollStudent()
      displayMathCourses()

  in MathCourses class:
  getMathCourses()

-Employee
  Attributes: 
      private final int WORK_HOURS_IN_DAY = 8;
      private String firstName 
      private String lastName
      private String email 
      private String phone
      private int id 
      private String status ("Unassigned")
      private final BitSet availability = new BitSet(WORK_HOURS_IN_DAY); ( either active/inactive))

  Methods: 
      other than getter and setter methods
      display_information()
      setAvailability()
      isAvailable()
      getAvailabilityBitString() 
      setAvailabilityBitString()
      printAvailability()

-Tutor
  Attributes: 
      private String tutorEmail;
      private double payRate;
      private BitSet availability;
      private final List<Course> coursesTeaching;
      private final List<Session> scheduledSessions;
      private double grossPay;

  Methods: 
      other than getter and setter methods
      showInformation()
      updateSession()
      positionPayRate()
      updateGrossPay()
      payEmployee()
  
-Student
  Attributes: 
      public String studentName;
      public List<Course> currentCourses;
      public int phoneNo;
      public String email;
      public int gradeLevel;
      private List<String> permanentRecord;

  Methods:
      other than getter and setter methods
      viewCourses()
      addCourse() 
      removeCourse()
      isEnrolled()
      enrollInCourse()
      updateGradeLevel()
      currentCourse()
  
-Session
  Attributes: 
      private int duration;       // duration of session in minutes
      private int startTime;      // start time of session in minutes (from START_HOUR)
      private int endTime;        // end time of session in minutes
      private final Student student;    // student in session
      private final Tutors tutor;        // tutor conducting the session
      private Course course;      // lesson being taught
      private BitSet sessionTime = new BitSet(WORK_HOURS_IN_DAY); 

  Methods: 
      other than getter and setter methods
      viewSessionTime() // Views the session times in a human-readable format
      isAvailable() // Checks if the session is valid, including tutor availability and subject compatibility
      createNewAvailabilityBitSet() // Creates a BitSet for the session's availability based on start time and duration
      containsAllBits() // Checks if all bits in bitset1 are ON in bitset2
      tutorTeachesSubject() // Checks if the tutor teaches the student's current subject
      viewSessionDetails() // Prints details of the session
      reschedule()
      setAvailability() // Sets tutor availability

-Manager
  Attributes:
      private final List<Tutors> managedTutors;  // List of tutors the manager manages
      private final List<Session> sessions;
      private double grossPay;// List of sessions the manager oversees

  Methods:
      other than getter and setter methods
      hireTutor() // Method to add a tutor to the manager's list
      fireTutor() // Method to remove a tutor from the manager's list
      showAllTutors() // Method to display all tutors managed by the manager
      scheduleSession() // Method to schedule a session for a tutor
      showAllSessions() // Method to display all sessions for the manager
      positionPayRate() // Override positionPayRate method
      updateGrossPay() // Override updateGrossPay method
      payEmployee() 
      getTutor()
 

-Schedulable (INTERFACE)

-TutorCenterUI
  Constants:
    private static final int WORK_HOURS_IN_DAY 
    private static final int START_HOUR 
    private static final int DEFAULT_SESSION_DURATION = 1;

Methods & other Functional Elements:
      other than getter and setter methods
      showManagerMenu()
      signInManager()
      hireTutor()
      createNewAvailabilityBitSet()
      generateNewID()
      viewTutors()
      addNewStudent()
      findTutorById()
      fireTutor()
      findTutorByName()
      showTutorMenu()
      signInTutor()
      viewAllTutors()
      viewAllStudents()
      showStudentMenu()
      signInStudent()
      viewStudentInfo()
      updateLesson()
      scheduleSession()
      updateSession()
      viewSessions()
---
## SESSION DOCUMENTATION:

- Assume time is military time for simplicity of math.
- Start Time: 9:00
- Closing Time: 17:00

*// FINALS*

private static final int WORK_HOURS_IN_DAY = 8;

private static final int START_HOUR = 9;

private static final int DEFAULT_SESSION_DURATION = 1;

*// ATTRIBUTES*

private int duration;      *// duration of session in seconds*

private int startTime;     *// gets start time of session in standard format*

private int endTime;       *// end time of session in standard format*

private Student student;    *// student in session*

private Tutors tutor;       // tutor of session

private String lesson;      *// lesson being taught*

private BitSet sessionTime = new BitSet(WORK_HOURS_IN_DAY);

When Creating Session:

Constructor makes sure session

1. Is within working hours
2. Tutor is available to teach the session
    1. Tutor works during session time
    2. Tutor knows current subject of Student

Methods:

viewSessionTime():

- Prints hours that Session occurs in in military time

public boolean isAvailable(int startTime, int duration, Tutors tutor, Student student):

- Used in constructor

## TUTOR DOCUMENTATION:

Tutors class inherits from Employee and implements Schedulable.
• Each tutor can:
• Manage availability using BitSet.
• Assign or remove students
• Schedule and update tutoring sessions

- View teaching courses and assigned students
- Session scheduling is validated against tutor availability.
Manager class can:
• Add/remove tutors
• Oversee and schedule sessions

## STUDENT DOCUMENTATION:

Student class can:
Enroll in courses means showing the information from student.
Tracking current session and view student info

## INSTALLATION INSTRUCTIONS:
1)Clone using web URL: https://github.com/j-lambs/SP25CS151---Algomind.git
2)Project Trajectory : cd SP25CS151---Algomind
3)Then the project can be opened by your preferred IDE.
4)TutorCenterUI should be run.

---
## CONTRIBUTIONS:
Jack Rellamas: Initial project planning and brainstroming, Contributed in making classes manager , employee , Scedulable,TutorCenterUI,Course (all memebers contributed in making of the classes) , De-bugging, Documentation

Mccay Rhodebeck: Initial project planning and brainstroming, Contributed in making classes manager , employee , Scedulable,TutorCenterUI,Course (all memebers contributed in making of all the classes) , De-bugging, Documentation

 Bhavya Vatsavayi: Initial project planning and brainstroming, Contributed in making classes manager , employee , Scedulable,TutorCenterUI,Course (all memebers contributed in making of all the classes) , De-bugging, Documentation, README

Karamjeet Kaur:Initial project planning and brainstroming, Contributed in making classes manager , employee , Scedulable,TutorCenterUI,Course (all memebers contributed in making of all the classes) , De-bugging, Documentation , UML Diagram
---
