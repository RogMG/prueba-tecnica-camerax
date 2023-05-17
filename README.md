# prueba-tecnica-camerax

Prueba técnica 
La siguiente prueba técnica se debe realizar una aplicación APK con las siguientes caracteristicas: 
o Desarrollar la prueba con Kotlin con diseño propio.
o Subir la prueba en un repositorio de GITHUB. 
Descripción 
Con la siguiente API se adjunta el archivo swagger, lo puedes visualizar en https://editor.swagger.io para ver 
información del servicio. 
URL: 
https://api.devdicio.net:8444/v1/sec_dev_interview 
Agregando al header el siguiente token: 
headers: { 
'Content-Type': 'application/json', 
'Host: api.devdicio.net', 
'xc-token': "" 
} 
Se debe construir un formulario para un registro de usuarios que tenga las siguientes características Esta 
Aplicación, tendrá 2 secciones: 
• Alta de usuario con foto. 
• Visualización de datos. 
1. Alta de usuario. Construir un formulario que contenga los siguiente datos: 
1. Nombre 
2. Apellido Paterno 
3. Apellido Materno 
4. Email Validar formato*
5. Fecha de Nacimiento Validar formato* AAAA-MM-DD
6. Datos: 
• Calle
• Numero
• Colonia
• Delegacion/Municipio 
• Estado
• CP 
7. Fotografía.- El usuario deberá tomar una foto desde la cámara con las siguientes caracteristicas:
Imagen original
• Guardar la original en la memoria del télefono 
Imagen para enviar al web service
• Formato de la imagen: PNG
• Recortar la imagen desde el centro de 300x300
• Ejemplo:
•
Ejemplo de estructura de datos a guardar:
2. Visualización datos. En un menu/pestaña/popup visualizar la información guardada en una tabla con 
todos los usuarios y un filtro de búsqueda por nombre. 
3. OPCIONAL. Edición de datos. Una sección donde se pueda editar la información de los usuarios 
registrados. 
4. OPCIONAL. Guía en sefie. Poner una guia para centrar el rostro.
Consideraciones: 
1. Se debe construir en Kotlin. 
2. Buenas prácticas. 
3. Diseño responsivo.
4. Patrones de diseño
5. Buen uso de git (commits bien definidos y documentados) 
Restricciones:
•	• Al finalizar, súbelo a GitHub. Por favor, mandame un correo de confirmación y compartelo con este usuario: 
• Robyrojas 
Cualquier duda que tengas respecto a la prueba, no dudes en contactarnos.
Te pido también que confirmes este mail para confirmar que lo recibiste correctamente. 
Saludos.
