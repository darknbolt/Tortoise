# Tortoise

A web-based version control platform built using **Spring Boot**, **Spring Web**, **H2 Database**, and **Thymeleaf**.  
The goal of this application is to manage collaborative repositories with structured user roles and detailed bug reporting.

---

## 🚀 Features

### 🧑‍🤝‍🧑 User Roles

Each repository defines four types of users with increasing levels of permissions:

#### Reporter
- Create bug reports
- Edit non-resolved reports
- View all reports

#### Developer
- All Reporter permissions
- Modify repository files
- Update bug report status (e.g., close report)

#### Admin
- All Developer permissions
- Accept, remove, or invite members
- Change member roles

#### Owner
- All Admin permissions
- Cannot be removed
- Modify repository details (name, logo, max members)

---

### 🐞 Bug Reports

A report contains:
- **ID** (auto-generated)
- **Title**
- **Description**
- **Optional**: File path and line number
- **Status**: `NEW`, `BEING_RESOLVED`, `RESOLVED`
- **Category**: `TRIVIAL`, `SIGNIFICANT`, `SEVERE`

---

### 📁 Repository Pages

Each repository has a dedicated page offering:
- **Member List Access** (based on permissions)
- **Join Request System** (for non-members)
- **Leave Repository Option** (for members)
- **Access to Files**
- **View Reports**
- **Default Repository Description**

---

## 🛠 Tech Stack

- **Backend**: Spring Boot, Spring Web, Spring Security
- **Database**: H2 (in-memory for development)
- **Templating**: Thymeleaf, Bootstrap
- **Build Tool**: Gradle

---

## 📌 Getting Started

### Prerequisites
- Java 17+
- Gradle
- (Optional) IntelliJ IDEA

### Running Locally

```bash
./gradlew bootRun
