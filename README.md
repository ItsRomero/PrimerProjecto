# 🏋️‍♂️ Sistema de Monitoreo de Rendimiento de Atletas

[![Java](https://img.shields.io/badge/Java-24-blue?logo=java)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-Academic-lightgrey)](#)
[![Status](https://img.shields.io/badge/Status-Activo-green)](#)

**Descripción:**  
Aplicación de **consola en Java** desarrollada para el **Comité Olímpico Guatemalteco**, que permite registrar atletas de alto rendimiento, llevar un historial de entrenamientos y calcular estadísticas de desempeño de manera rápida y sencilla.  

---

## 📌 Funcionalidades

- **Gestión de atletas:** Registrar nombre, edad, disciplina y departamento.  
- **Registro de entrenamientos:** Guardar sesiones con fecha, tipo y valor (tiempo o peso).  
- **Historial individual:** Consultar todas las sesiones de un atleta específico.  
- **Estadísticas básicas:**  
  - Promedio de rendimiento  
  - Mejor marca registrada  
- **Interfaz sencilla:** Menú interactivo en consola para facilitar su uso.  

---

## 🗂️ Estructura del proyecto

src/
├── Main.java # Clase principal: menú y operaciones
├── Atleta.java # Representa a un atleta con su lista de entrenamientos
└── Entrenamiento.java # Contiene la información de cada sesión (fecha, tipo, valor)


---

## 🚀 Instalación y ejecución


### 1️⃣ Clonar el repositorio
git clone https://github.com/tuusuario/atletas-monitor.git
cd atletas-monitor

### 2️⃣ Compilar
javac src/*.java

### 3️⃣ Ejecutar
java src.Main

📂 Menú de ejemplo
===== MENÚ PRINCIPAL =====
1. Registrar atleta
2. Registrar entrenamiento
3. Mostrar historial de un atleta
4. Mostrar estadísticas de un atleta
5. Salir

🛠️ Tecnologías usadas
Java 24 (compatible con versiones 8+)

✍️ Autor
Oliver Romero – Proyecto desarrollado con fines académicos
