# 🚀 ChickenBrain AndroidApps Modeller: Visual Android Application Generator

![Status](https://img.shields.io/badge/Status-In%20Development-yellow)
![Version](https://img.shields.io/badge/Version-0.0.1--SNAPSHOT-blue)
![Java](https://img.shields.io/badge/Java-1.8-orange)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Table of Contents
- [Description](#-description)
- [Demo](#-demo)
- [Features](#-features)
- [Architecture](#️-architecture)
- [Algorithms](#-algorithms)
- [Technologies](#️-technologies)
- [Installation](#-installation)
- [Usage](#-usage)
- [Module Breakdown](#-module-breakdown)
- [Performance and Scalability](#-performance-and-scalability)
- [Future Development](#-future-development)
- [Contact](#-contact)

## 📝 Description

ChickenBrain AndroidApps Modeller is a visual Android application generator specialized in Wiki-style apps, developed in Java. It allows creating informative applications through an intuitive visual interface, using an interconnected node system and WYSIWYG editors. The application compiles Java/XML projects and packages them as APKs, without requiring the user to write code.

The project was born as an exploration of advanced programming concepts, including procedural code generation, automatic compilation of Android projects, and the development of graph-based interfaces. The main technical motivation was to implement an extensible modular architecture that could represent complex content structures through nodes and connections.

I was the ONLY developer of this project, which I created as a proof of concept to accelerate my development of wiki-style applications. I single-handedly implemented the entire system, including the node architecture, the MDI (Multiple Document Interface) system, and the visual interconnection algorithms.

## 🎮 Demo
- Initial project setup (colors and metadata)
![image](https://github.com/user-attachments/assets/4b650cfa-d56c-492b-bd42-23b24a04a955)
![image](https://github.com/user-attachments/assets/2cdaf17e-8c4c-402e-8524-7f5f7898c8b2)
![image](https://github.com/user-attachments/assets/f06af9e6-ecfe-44f4-97c3-e4aba8cbc718)
- Main node editor and connections
![image](https://github.com/user-attachments/assets/8e6192a8-3502-442e-891a-d30f79beaad2)
- Examples of different card types (informative, horizontal and vertical carousels)
![image](https://github.com/user-attachments/assets/9bc480b4-9bff-4781-aa29-3b073bf7f671)


## ✨ Features

- 🔍 **Visual Node Editor**: Graph-based editing system that allows connecting different types of content through a drag-and-drop interface.
- 🧩 **Procedural Code Generation**: Automatic transformation of the visual model into Java/XML code for Android.
- ⚡ **Real-Time Preview**: Triple synchronized system (editor, index, preview) that immediately shows changes.
- 🎨 **Complete Visual Customization**: Selection of primary, secondary, and tertiary colors with interactive preview.
- 📱 **Multiple Content Types**: Support for informative cards, horizontal and vertical carousels with text and images.
- 🔄 **Multi-level Observer Architecture**: Real-time event propagation among all related components.

## 🏗️ Architecture

The application uses a multi-layer architecture:

1. **Presentation Layer**: Implemented with Java Swing, uses an MDI (Multiple Document Interface) system with JInternalFrames to represent nodes and a JDesktopPane as the master container.

2. **Model Layer**: Uses a modified Singleton pattern through the static `Project` class that maintains the global state of the application.

3. **Communication Layer**: Implements a multi-level event propagation system that keeps all components synchronized.

4. **Generation Layer**: Transforms the visual model into Java/XML code for Android.

```java
// Example of the modified Singleton pattern in the Project class (APKInProgress.java)
public static void SetMainScenesManager() {
    switch(Tipo_Proyecto) {
        case Guia_Educativa: break;
        case Tips_Diarios: break;
        case Temario_Educativo: 
            Temario_Educativo_MainScenesManager Ventana_TemarioEducativo_MainScenesManager = 
                new Temario_Educativo_MainScenesManager();
            break;
    }
}
```

### Architecture Diagram

```
                          +-------------------------+
                          |     User Interface      |
                          | (Swing/AWT Components)  |
                          +-----------+-------------+
                                      |
                                      v
+----------------+        +-------------------------+        +----------------+
|  Visual Editor  | <---> |      Singleton APK      | <---> |    Previewer   |
|  (Nodes Editor) |        | (Global Project State)  |      | (Android View) |
+----------------+        +-------------------------+        +----------------+
                                      |
                                      v
                          +-------------------------+
                          |      Code Generator     |
                          |   (Java/XML for APK)    |
                          +-------------------------+
```

## 🧠 Algorithms

### Dynamic Connection Drawing Algorithm

The system implements a dynamic drawing algorithm that calculates and draws connections between nodes using linear interpolation. For each pair of connected nodes, the slope is calculated and then points are drawn at regular increments to form the line.

```java
private void CalcularTrazo(Component Origen, Component Destino) {
    // Calculate origin and destination points (bottom center of origin, top center of destination)
    float Q = Origen.getX() + Origen.getWidth()/2, 
          K = Origen.getY() + Origen.getHeight(),
          X = Destino.getX() + Destino.getWidth()/2, 
          Y = Destino.getY() + Destino.getHeight();
    
    // Calculate slope between points
    float pendiente = (Y-K)/(X-Q);
    
    // Iterate to draw points along the line
    for(float i = X <= Q ? X : Q; i <= (X <= Q ? Q : X); i += GrosorLinea) {
        float pY = (int)((pendiente*i) - (pendiente*Q) + K);
        if(null != getGraphics()) {
            Graphics g = getGraphics();
            g.setColor(Proyecto.getColorTerciario());
            g.fillOval((int)i, (int)pY, GrosorLinea, GrosorLinea);
        }
    }
}
```
### Multi-View Synchronization System
The synchronization algorithm ensures that any change in a component is instantly reflected in all related views, using a DocumentListener:
```java
@Override
public void insertUpdate(DocumentEvent arg0) {
    try {
        // Update the data model
        CourrentParrafo.SetTexto(Texto.getText());
        
        // Update visual representation in the index
        CourrenButtonParrafo.setText(CourrentParrafo.getTexto().substring(0,
            (CourrentParrafo.getTexto().length() >= 20? 20:(CourrentParrafo.getTexto().length())))+"...");
        
        // Regenerate the complete preview
        JFrame_Preview.LimpiarFicha();
        for(String ID : Ficha.getIndiceDeComponentes()) {
            if(Ficha.getTextos().containsKey(ID)) {
                JFrame_Preview.AgregarParrafo(Ficha.getTextos().get(ID));
            }
            else if(Ficha.getImagenes().containsKey(ID)) {
                JFrame_Preview.AgregarIlustracion(Ficha.getImagenes().get(ID));
            }
        }
    }
    catch(IndexOutOfBoundsException i) { }
}
```
## 🛠️ Technologies
### Frontend
- **Java Swing**: Main graphical interface framework
  - JInternalFrame for the MDI system
  - JDesktopPane as master container
  - Custom components extending JPanel, JButton, and JTextPane
- **AWT (Abstract Window Toolkit)**: For event handling and graphics
  - ActionListener, MouseMotionListener, FocusListener
  - Graphics, Color, Image
### Data Structures
- **Java Collections Framework**:
  - HashMap for O(1) access to components by identifier
  - ArrayList for ordered sequences
  - StringTokenizer for text processing
- **UUID**: Generation of unique identifiers
### Build and Dependencies
- **Maven**: Dependency management and build system
- **MigLayout**: Layout manager for complex interfaces
- **JGoodies Forms**: Advanced UI components
## 📦 Installation
```bash
# Clone repository
git clone https://github.com/username/androidapps-modeller.git
# Compile with Maven
mvn clean package
# Run the application
java -jar target/androidapps-modeller-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

### System Requirements
- Java Development Kit (JDK) 1.8 or higher
- Maven 3.0+
- 2GB RAM minimum (4GB recommended)
## 📚 Usage
### Creating a new project
1. Select "New Project" on the initial screen
2. Choose the project type (currently available: Educational)
3. Configure the main colors of the application
4. Configure the cover (title and image)
5. Use the node editor to create content

### Node Editor
```java
// Example of creating an informative card from code
public void createInformativeCard(String title, String description) {
    // Create card instance
    InformativeCard newCard = new InformativeCard(title);
    newCard.setDescription(description);
    
    // Add to project
    Project.addCard(newCard);
    
    // Update interface
    updateInterface();
}
```

## 📑 Module Breakdown
### Initial Configuration Module
This module handles the basic project configuration, including application type, main colors, and metadata.
**Technical features:**
- Implementation of ActionListener for event capture
- Data validation with visual feedback
- Controlled transitions between windows using the State pattern
**Challenges overcome:**
- Responsive design that adapts to different resolutions using proportional constants
- Real-time preview system for color selections
  
### Node Editor Module
This is the core of the application, allowing the visual creation and connection of different content components.
**Technical features:**
- MDI system with multi-layer event propagation
- Dynamic drawing algorithm for connections between nodes
- Persistence model using dual HashMaps
**Challenges overcome:**
- Implementation of component dragging with real-time recalculation of connections
- Collision detection system to avoid node overlap
- Observer architecture that maintains consistency between model and view

### Scalability Considerations
- Modular architecture that allows adding new project types and components
- Planned plugin system for future extensions
- Serializable data model for persistence and collaboration

## 🌱 Future Development
- Complete implementation of project types: Educational Guide and Daily Tips
- More advanced visual theme editor
- Support for interactive components (quizzes)
- Export to additional formats (PWA, iOS)
- Real-time collaboration system
- Implementation of artificial intelligence for design assistance and content generation



```
   ____ _     _      _              ____           _       
  / ___| |__ (_) ___| | _____ _ __ | __ ) _ __ __ _(_)_ __  
 | |   | '_ \| |/ __| |/ / _ \ '_ \|  _ \| '__/ _` | | '_ \ 
 | |___| | | | | (__|   <  __/ | | | |_) | | | (_| | | | | |
  \____|_| |_|_|\___|_|\_\___|_| |_|____/|_|  \__,_|_|_| |_|
                                                          
```

_This project was developed as an exploration of advanced Java programming concepts, procedural code generation, and Android application development through a visual interface._
