# 🎓 Sistema de Gestión Académica

<div align="center">

![Academic Management](https://img.shields.io/badge/Gestión-Académica-blue?style=for-the-badge)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=for-the-badge)

**Sistema web para administrar procesos académicos con roles y reportes** 🚀

</div>

---

## 📖 Descripción

**Sistema Web de Gestión Académica** es una aplicación Spring Boot para administrar estudiantes, docentes, cursos, matrículas y notas. Incluye autenticación por roles (Admin, Docente, Estudiante), paneles personalizados y reportes en PDF con JasperReports.

### 🎯 ¿Para quién es?

- 👨‍💼 **Administradores**: Gestión general del sistema y reportes
- 👨‍🏫 **Docentes**: Registro y consulta de notas
- 👨‍🎓 **Estudiantes**: Consulta de matrículas y calificaciones

---

## ✨ Características Principales

### 🔐 Sistema de Autenticación
- ✅ Login con roles diferenciados
- ✅ Acceso a paneles por tipo de usuario

### 👨‍💼 Panel de Administración
- 👥 Mantenimiento de docentes y estudiantes (CRUD)
- 🏫 Gestión de cursos
- 📝 Registro y consulta de matrículas
- 📊 Reportes en PDF (matriculados y notas)

### 👨‍🏫 Funcionalidades para Docentes
- 📊 Registro de calificaciones
- 🔍 Consulta de notas por estudiante/curso

### 👨‍🎓 Portal del Estudiante
- 📅 Consulta de matrículas
- 📈 Consulta de notas

---

## 🛠️ Tecnologías

<div align="center">

| Backend | Frontend | Base de Datos | Reportes |
|:-------:|:--------:|:-------------:|:--------:|
| ☕ Java 17 | 🧩 Thymeleaf | 🗄️ MySQL | 📄 JasperReports |
| 🌱 Spring Boot 4 | 🎨 HTML/CSS/JS | | |
| 🗃️ Spring Data JPA | | | |

</div>

---

## 📦 Instalación

### Prerrequisitos

- ☕ Java 17
- 🧰 Maven (o usar `./mvnw`)
- 🗄️ MySQL

### Pasos de instalación

```bash
# 1️⃣ Clonar el repositorio
git clone https://github.com/Enmvnuel/gestion-academica.git

# 2️⃣ Entrar al directorio
cd gestion-academica

# 3️⃣ Crear la base de datos (opcional, usando script)
mysql -u root -p < src/main/resources/query.sql

# 4️⃣ Ajustar credenciales en application.properties
#    (src/main/resources/application.properties)

# 5️⃣ Ejecutar la aplicación
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

---

## 🚀 Uso

### Credenciales de prueba

> ⚠️ **Nota**: Estas credenciales están en el script `query.sql` para uso en desarrollo.

| Rol | Usuario | Contraseña |
|-----|---------|------------|
| 👨‍💼 Admin | admin | admin123 |
| 👨‍🏫 Docente | profe | profe123 |
| 👨‍🎓 Estudiante | jperez | alumno123 |
| 👨‍🎓 Estudiante | mgomez | alumno123 |

---

## 📂 Estructura del Proyecto

```
gestion-academica/
├── src/
│   ├── main/
│   │   ├── java/com/cibertec/gestionacademica/
│   │   │   ├── controller/   # Controladores MVC
│   │   │   ├── model/        # Entidades JPA
│   │   │   ├── repository/   # Repositorios
│   │   │   └── service/      # Lógica de negocio
│   │   └── resources/
│   │       ├── templates/    # Vistas Thymeleaf
│   │       ├── static/       # CSS/JS
│   │       └── reportes/     # Plantillas JasperReports
│   └── test/                 # Pruebas
├── pom.xml
└── README.md
```

---

## 🔧 Operaciones CRUD

### 👥 Usuarios (Docentes/Estudiantes)
- ✏️ **Create**: Registrar docentes y estudiantes
- 👁️ **Read**: Consultar información
- ✍️ **Update**: Actualizar datos
- 🗑️ **Delete**: Eliminar registros

### 📚 Cursos
- ✏️ **Create**: Crear cursos y asignaturas
- 👁️ **Read**: Visualizar cursos
- ✍️ **Update**: Modificar detalles del curso
- 🗑️ **Delete**: Eliminar cursos

### 📝 Matrículas y Notas
- ✏️ **Create**: Registrar matrículas y calificaciones
- 👁️ **Read**: Consultar matrículas y notas
- ✍️ **Update**: Actualizar registros
- 🗑️ **Delete**: Anular registros

---

## 🎨 Capturas de Pantalla

```
🖥️ [Próximamente]
```

---

## 🤝 Contribuir

¡Las contribuciones son bienvenidas! 🎉

1. 🍴 Fork el proyecto
2. 🌿 Crea tu rama de característica (`git checkout -b feature/AmazingFeature`)
3. 💾 Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. 📤 Push a la rama (`git push origin feature/AmazingFeature`)
5. 🔃 Abre un Pull Request

---

## 📝 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

---

## 👨‍💻 Autor

**Emmanuel**

- 🌐 GitHub: [@Enmvnuel](https://github.com/Enmvnuel)

---

## 📞 Contacto

¿Tienes preguntas o sugerencias?

- 💬 Issues: [GitHub Issues](https://github.com/Enmvnuel/gestion-academica/issues)
- 🌐 Discusiones: [GitHub Discussions](https://github.com/Enmvnuel/gestion-academica/discussions)

---

## 🙏 Agradecimientos

- 💡 A todos los contribuidores que hacen posible este proyecto
- 📚 A la comunidad de código abierto
- 🎓 A las instituciones educativas que inspiran este trabajo

---

<div align="center">

**⭐ Si este proyecto te resulta útil, considera darle una estrella ⭐**

Made with ❤️ for education

</div>
