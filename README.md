# Authorization Authentication - Sistema de Autorización y Autenticación 🔒

La aplicación Authorization Authentication es un sistema que proporciona funcionalidades para la gestión de usuarios, privilegios y roles dentro de un sistema. Permite realizar operaciones de registro de usuarios, autenticación y autorización de acceso a recursos protegidos.

## Ejecución de la Aplicación ▶️

Para ejecutar la aplicación Authorization Authentication, sigue estos pasos:

1. **Clonar el Repositorio 📦**: Clona el repositorio de GitHub en tu máquina local.

   ```bash
   git clone https://github.com/AndresGUIO2/SITAS-Auth-Backend.git

2. **Importar Proyecto 📁**: Abre el proyecto en tu IDE como un proyecto de Maven.

3. **Configurar Dependencias 📚:**: Asegúrate de que todas las dependencias definidas en el archivo `pom.xml` se descarguen correctamente.

4. **Ejecutar la Aplicación ▶️**: Ejecuta la clase principal `AuthorizationAuthenticationApplication.java` como una aplicación Spring Boot.

5. **Acceder a la Aplicación 🌐**: Una vez que la aplicación esté en funcionamiento, puedes acceder a ella en tu navegador ingresando la URL: `http://localhost:8080`.

## Endpoints Disponibles 🚀

La aplicación proporciona los siguientes endpoints para interactuar con la API:

- **Registro de Usuarios 📝**: POST `/public/api/auth/register` - Permite registrar un nuevo usuario en el sistema.
- **Login de Usuarios 🔑**: POST `/public/api/auth/login` - Permite el logeo de un usuario en el sistema.
- **Validación de Tokens 🛡️**: GET `/api/user/me` - Permite validar el token de autenticación y obtener información del usuario autenticado.

## Requisitos del Sistema 📋
- Java JDK 11 o superior ☕.
- Apache Maven 📦.
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA, Eclipse) 🖥️.
- Conexión a Internet para descargar dependencias 🌐.

## Despliegue y Documentación 📖
La aplicación ya está desplegada y se pueden probar o consultar la API y el Swagger en el siguiente enlace: [Swagger UI](https://codefact.udea.edu.co/modulo-01/swagger-ui/index.html#/)
