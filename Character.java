package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int mana;
    private int hitPoints;

    // Constructor tanpa parameter
    public Character() {
        this("", CharacterType.WARRIOR, 1);
    }

    // Constructor dengan nama, jenis, dan level
    public Character(String name, CharacterType type, int level) {
        setName(name);
        setType(type);
        setLevel(level);
        this.mana = 0;
        this.hitPoints = 100;
    }

    // Constructor lengkap
    public Character(String name, CharacterType type,
                     int level, int mana, int hitPoints) {
        this(name, type, level);
        setMana(mana);
        setHitPoints(hitPoints);
    }

    // Getter dan setter nama
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }
        this.name = name.trim();
    }

    // Getter dan setter jenis karakter
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                "Jenis karakter tidak boleh null."
            );
        }
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1."
            );
        }
        this.level = level;
    }

    // Getter dan setter mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif."
            );
        }
        this.mana = mana;
    }

    // Getter dan setter hit points
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                "Hit points tidak boleh negatif."
            );
        }
        this.hitPoints = hitPoints;
    }

    // Membandingkan karakter berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    // hashCode harus konsisten dengan equals
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(
            java.util.Locale.ROOT
        ));
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", mana=" + mana +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
