# 🎫 Gestión de Eventos

Proyecto académico desarrollado con **Java Spring Boot**, **Thymeleaf**, **H2 Database** y **Bootstrap**, que permite realizar una gestión completa de eventos, ciudades, personas y asistencias, utilizando **sesiones** y **cookies** para mejorar el rendimiento y la experiencia del usuario.

---

## 🚀 Características

- ABM completo (Alta, Baja, Modificación) para:
    - ✅ Ciudades
    - ✅ Eventos
    - ✅ Personas
    - ✅ Asistencias a eventos
- Autenticación por formulario de inicio de sesión.
- Mantenimiento de sesión (`usuarioLogueado`).
- Almacenamiento de la última ciudad editada mediante **cookies**.
- Modal de aceptación de cookies estilo **bottom sheet**.
- Interfaz amigable con **Bootstrap 5**.
- Base de datos embebida H2 para pruebas rápidas.
- Deploy en Railway para pruebas desde cliente externo.

---

## 🧰 Tecnologías

| Tecnología     | Versión / Info                 |
|----------------|--------------------------------|
| Java           | 17                             |
| Spring Boot    | 3.5.3                          |
| Spring MVC     | + Spring Data JPA              |
| Thymeleaf      | 3.x                            |
| Bootstrap      | 5.3                            |
| Base de datos  | H2 (en memoria)                |
| Servidor web   | Embedded Tomcat (Puerto 8080)  |

---

## 🌐 Deploy online

El proyecto está disponible públicamente para pruebas en el siguiente enlace:

🔗 **[https://gestion-eventos-production.up.railway.app](https://gestion-eventos-production.up.railway.app)**

---

## 💻 Repositorio GitHub

📁 Repositorio del código fuente disponible en:  
🔗 **[https://github.com/MemoSayan/gestion-eventos](https://github.com/MemoSayan/gestion-eventos)**

---

## 🧪 Usuario de prueba

| Usuario     | Contraseña |
|-------------|------------|
| admin       | admin123   |

*(Podés configurar más desde los datos precargados o modificando el servicio de login)*

---

## 📦 Ejecución local

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/MemoSayan/gestion-eventos.git
   cd gestion-eventos

---
✅ Funcionalidad de Sesiones y Cookies
Al iniciar sesión, los datos del usuario se almacenan en sesión (HttpSession).

Al editar una ciudad, el sistema guarda una cookie con el nombre de la ciudad (ultimaCiudad) que se muestra luego en la barra de navegación.

Se incluye una ventana modal que solicita el consentimiento de cookies al primer ingreso.

--- 
👨‍💻 Autor
Guillermo De la Cruz
📍 Asunción, Paraguay
🧑‍💻 Desarrollador Java & Flutter
