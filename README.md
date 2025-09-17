# 🎭 Costume Quiz REST API  

A Spring Boot REST API for creating and managing quizzes. It supports **Admins** (who create quizzes and questions) and **Users** (who attempt quizzes). Users can take quizzes, submit answers, and get their scores automatically.  

## 🚀 Features  
- ✅ User & Admin role support  
- ✅ Create, update, delete quizzes  
- ✅ Add questions & multiple-choice options  
- ✅ Submit quiz and auto-score calculation  
- ✅ Exception handling with meaningful messages  
- ✅ MySQL database integration with JPA/Hibernate  
- ✅ RESTful API endpoints for all operations  


## 🛠️ Tech Stack  
- **Backend:** Spring Boot (Java)  
- **Database:** MySQL + JPA/Hibernate  
- **Security:** Role-based access (Admin/User)  
- **Build Tool:** Maven  


## 📌 API Endpoints Overview  

### 👤 User  
- `POST /user` → Register new user  
- `GET /user/{id}` → Get user by ID  

### 📚 Quiz  
- `POST /quiz` → Create a new quiz  
- `GET /quiz/{id}` → Get quiz by ID  
- `DELETE /quiz/{id}` → Delete quiz  

### ❓ Question  
- `POST /question/add/{quizId}` → Add question to a quiz  
- `DELETE /question/{id}` → Delete question  

### ✅ Option  
- `GET /options/question/{questionId}` → Get options of a question  
- `PUT /options/{id}` → Update an option  

### 📝 Result  
- `POST /results/submit/{userId}/{quizId}` → Submit quiz answers and calculate score  

---

## ⚙️ Installation & Setup  

1. Clone the repository:  
   ```bash
   git clone https://github.com/PRIYANSHU4061/costume-quiz-api.git
Configure database in application.properties:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
Run the project:

bash
Copy code
mvn spring-boot:run

📊 Database Schema
Entity	Fields
User	userId, username, role
Quiz	quizId, title, description
Question	questionId, questionText, quizId (FK)
Option	optionId, optionText, correct, questionId (FK)
Result	resultId, userId (FK), quizId (FK), score

🎯 Future Enhancements

⏱️ Add a timer for each question

🌐 Build a frontend UI (React / Angular)

🏆 Leaderboard to display top scorers

🧑‍💻 Multi-admin support with separate quiz sets

📧 Contact

For any issues or questions, feel free to reach me via LinkedIn:
https://www.linkedin.com/in/priyanshu4061/

⭐ If you find this project helpful, please give it a star!
