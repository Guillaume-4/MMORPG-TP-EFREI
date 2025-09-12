# RPG-TP-Efrei 🎮⚔️

Un petit RPG en Java développé dans le cadre d’un projet d’apprentissage.
Le jeu se joue dans la console et propose un système de combats, d’objets, d’inventaire et de progression.


## 🚀 Fonctionnalités

  - ✅ Création de personnages (Knight, Elf, Goblin, Orc, etc.)

  - ✅ Système de combat tour par tour avec attaque, défense et garde

  - ✅ Gestion de l’inventaire et des équipements :

    - Armes ⚔️

    - Boucliers 🛡️

    - Charms ✨

  - ✅ Gagner de l’or et de l’expérience

  - ✅ Boutique pour acheter des objets 💰

  - ✅ Sauvegarde/chargement de la partie


## 📂 Structure du projet

```
src/
├── App/
│   └── Main.java            # Point d’entrée du jeu
├── Charms/                  # Les charms (bonus d’attaque, etc.)
├── Entities/                # Les personnages et monstres (Knight, Elf, Orc, Goblin…)
├── Items/                   # Gestion de l’inventaire et des items
├── Level/                   # Gestion des niveaux et progression
├── Settings/                # Sauvegarde et configuration
├── Shield/                  # Boucliers
├── Shop/                    # Boutique
├── Views/                   # Affichage console (menus, pages)
└── Weapons/                 # Armes
```


## 🛠️ Installation

**Cloner le dépôt :**

```
git clone https://github.com/<TON-USERNAME>/RPG-TP-Efrei.git
cd RPG-TP-Efrei/src
```


**Compiler le projet :**

```javac App/Main.java```


**Lancer le jeu :**

```java App.Main```


## 📦 Générer un JAR exécutable

**Compiler toutes les classes :**

```javac App/*.java Entities/*.java Items/*.java Level/*.java Settings/*.java Shield/*.java Shop/*.java Views/*.java Weapons/*.java Charms/*.java```


**Créer un fichier manifest.txt :**

```Main-Class: App.Main```


**Générer le .jar :**

```jar cfm RPG-TP-Efrei.jar manifest.txt App/*.class Entities/*.class Items/*.class Level/*.class Settings/*.class Shield/*.class Shop/*.class Views/*.class Weapons/*.class Charms/*.class```


**Lancer le .jar :**

```java -jar RPG-TP-Efrei.jar```


## 🎮 Exemple d’affichage
==================[ HOME ]==================
 1) Fight
 2) Visit Shop
 3) View Stats
 4) View Inventory
 5) Equipment
 6) Exit
 7) Clear Console

============================================


## 📌 Améliorations possibles

Ajout de nouveaux monstres et boss 👹

Système de quêtes

Sauvegardes multiples

Effets spéciaux sur les armes/charms

Interface graphique (Swing ou JavaFX)


## 👤 Auteur

Projet développé par Guillaume-4 dans le cadre du TP d’Efrei.
📧 Contact : ```guillaume.blas4@gmail.com```
