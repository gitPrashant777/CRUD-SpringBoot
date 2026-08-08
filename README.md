# Smart Attendance System Backend

Spring Boot REST backend for managing:

- departments
- sections
- teachers
- students
- lectures
- attendance records

The project links the data together so the attendance flow can be tracked by department, section, teacher, student, and lecture.

## Tech Stack

- Java 8
- Spring Boot 2.7.x
- Spring Web
- Spring Data JPA
- H2 in-memory database

## Project Structure

- `Department` -> master department data
- `Section` -> belongs to a department
- `Teacher` -> belongs to a department
- `Student` -> belongs to a department and section
- `Lecture` -> belongs to a teacher and section
- `AttendanceRecord` -> belongs to a student and lecture

## Run

If Maven is available:

```bash
mvn spring-boot:run
```

Or build first:

```bash
mvn clean package
java -jar target/smart-attendance-system-0.0.1-SNAPSHOT.jar
```

## H2 Console

Open:

`http://localhost:8080/h2-console`

Use:

- JDBC URL: `jdbc:h2:mem:smartattendance`
- User name: `sa`
- Password: empty

## API Endpoints

### Departments

- `GET /api/departments`
- `GET /api/departments/{id}`
- `POST /api/departments`
- `PUT /api/departments/{id}`
- `DELETE /api/departments/{id}`

### Sections

- `GET /api/sections`
- `GET /api/sections/{id}`
- `POST /api/sections`
- `PUT /api/sections/{id}`
- `DELETE /api/sections/{id}`

### Teachers

- `GET /api/teachers`
- `GET /api/teachers/{id}`
- `POST /api/teachers`
- `PUT /api/teachers/{id}`
- `DELETE /api/teachers/{id}`

### Students

- `GET /api/students`
- `GET /api/students/{id}`
- `POST /api/students`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`

### Lectures

- `GET /api/lectures`
- `GET /api/lectures/{id}`
- `POST /api/lectures`
- `PUT /api/lectures/{id}`
- `DELETE /api/lectures/{id}`

### Attendance

- `GET /api/attendance`
- `GET /api/attendance/{id}`
- `POST /api/attendance`
- `PUT /api/attendance/{id}`
- `DELETE /api/attendance/{id}`

## Example JSON

Create a department:

```json
{
  "code": "CSE",
  "name": "Computer Science and Engineering"
}
```

Create a section:

```json
{
  "code": "A",
  "name": "Section A",
  "departmentId": 1
}
```

Create a student:

```json
{
  "enrollmentNo": "S-2001",
  "firstName": "Rahul",
  "lastName": "Verma",
  "email": "rahul.verma@example.com",
  "departmentId": 1,
  "sectionId": 1
}
```

Create a lecture:

```json
{
  "title": "Database Systems",
  "startsAt": "2026-08-09T10:00:00",
  "endsAt": "2026-08-09T11:00:00",
  "teacherId": 1,
  "sectionId": 1
}
```

Mark attendance:

```json
{
  "attendanceDate": "2026-08-08",
  "status": "PRESENT",
  "studentId": 1,
  "lectureId": 1
}
```
