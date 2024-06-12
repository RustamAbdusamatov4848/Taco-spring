# Taco-spring Project

## Overview
The Taco-spring project is a web application designed to manage taco recipes. It based on project from [Spring in Action, Sixth Edition.Craig Walls](https://www.amazon.co.uk/Spring-Action-Sixth-Craig-Walls/dp/1617297577). 
This project demonstrates the use of modern Java web development technologies and frameworks, 
providing a solid example of a full-stack application built with Spring Boot, Spring MVC, Spring Data JPA, and Thymeleaf.

## Features
- **User Management:** Allows users to create, read, update, and delete accounts.
- **Recipe Management:** Users can create, view, update, and delete taco recipes.
- **Ingredient Management:** Enables management of ingredients for recipes.
- **Ordering System:** Users can place orders for tacos based on available recipes.

## Technology Stack
- **Java:** The primary programming language used for the backend.
- **Spring Boot:** Simplifies the development of production-ready applications.
- **Spring MVC:** Facilitates the creation of web applications with an MVC architecture.
- **Spring Data JPA:** Provides abstraction over data access, making database interactions easier.
- **Thymeleaf:** A server-side Java template engine for web and standalone environments.
- **H2 Database:** An in-memory database for development and testing.
- **Maven:** For project build and dependency management.

## Project Structure
- `src/main/java`: Contains the main application code including controllers, services, and repositories.
- `src/main/resources`: Contains configuration files and static resources like HTML templates and CSS files.
- `pom.xml`: Maven configuration file that manages project dependencies and build configurations.

## Setup and Installation
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/RustamAbdusamatov4848/Taco-spring.git
    cd Taco-spring
    ```

2. **Build the Project:**
    ```bash
    ./mvnw clean install
    ```

3. **Run the Application:**
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Access the Application:**
    Open a web browser and navigate to [http://localhost:8080](http://localhost:8080).

## Usage
- **Home Page:** Displays available taco recipes.
- **User Registration/Login:** Allows users to register and log in.
- **Recipe Management:** Logged-in users can manage their recipes.
- **Place Orders:** Users can place orders for tacos.

## Contribution
Contributions are welcome! Please fork the repository and submit a pull request for review.

---

# Проект Taco-spring

## Обзор
Проект Taco-spring - это веб-приложение, разработанное для управления рецептами тако. Основанно на проекте книги [Spring in Action, Sixth Edition.Craig Walls](https://www.amazon.co.uk/Spring-Action-Sixth-Craig-Walls/dp/1617297577)
Этот проект демонстрирует использование современных технологий и фреймворков разработки на Java, 
обеспечивая прочный пример полноценного приложения, построенного с использованием Spring Boot, Spring MVC, Spring Data JPA и Thymeleaf.

## Возможности
- **Управление пользователями:** Позволяет пользователям создавать, читать, обновлять и удалять учетные записи.
- **Управление рецептами:** Пользователи могут создавать, просматривать, обновлять и удалять рецепты тако.
- **Управление ингредиентами:** Позволяет управлять ингредиентами для рецептов.
- **Система заказов:** Пользователи могут размещать заказы на тако на основе доступных рецептов.

## Технологический стек
- **Java:** Основной язык программирования для бэкенда.
- **Spring Boot:** Упрощает разработку готовых к использованию в производстве приложений.
- **Spring MVC:** Облегчает создание веб-приложений с архитектурой MVC.
- **Spring Data JPA:** Предоставляет абстракцию над доступом к данным, упрощая взаимодействие с базой данных.
- **Thymeleaf:** Серверный шаблонизатор Java для веб-и автономных сред.
- **H2 Database:** Встроенная база данных для разработки и тестирования.
- **Maven:** Для сборки проекта и управления зависимостями.

## Структура проекта
- `src/main/java`: Содержит основной код приложения, включая контроллеры, сервисы и репозитории.
- `src/main/resources`: Содержит файлы конфигурации и статические ресурсы, такие как HTML-шаблоны и CSS-файлы.
- `pom.xml`: Файл конфигурации Maven, управляющий зависимостями проекта и настройками сборки.

## Установка и запуск
1. **Клонировать репозиторий:**
    ```bash
    git clone https://github.com/RustamAbdusamatov4848/Taco-spring.git
    cd Taco-spring
    ```

2. **Собрать проект:**
    ```bash
    ./mvnw clean install
    ```

3. **Запустить приложение:**
    ```bash
    ./mvnw spring-boot:run
    ```

4. **Доступ к приложению:**
    Откройте веб-браузер и перейдите по адресу [http://localhost:8080](http://localhost:8080).

## Использование
- **Главная страница:** Отображает доступные рецепты тако.
- **Регистрация/Вход пользователя:** Позволяет пользователям зарегистрироваться и войти.
- **Управление рецептами:** Зарегистрированные пользователи могут управлять своими рецептами.
- **Размещение заказов:** Пользователи могут размещать заказы на тако.

## Вклад
Приемлются вклады! Пожалуйста, создайте форк репозитория и отправьте pull request для рассмотрения.
