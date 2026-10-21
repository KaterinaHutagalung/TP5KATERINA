package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {

    private final ArrayList<Character> characters;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    // Menambahkan karakter jika belum ada
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (characters.contains(character)) {
            return false;
        }

        characters.add(character);
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findCharacter(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(
                    name.trim())) {
                return character;
            }
        }

        return null;
    }

    // Mengambil salinan daftar karakter
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung jumlah karakter
    public int getCharacterCount() {
        return characters.size();
    }

    // Alias untuk kompatibilitas dengan pemanggilan tugas
    public int getTotalCharacters() {
        return getCharacterCount();
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {
        Character character = findCharacter(name);

        if (character == null) {
            return false;
        }

        return characters.remove(character);
    }

    // Memperbarui karakter berdasarkan nama lama
    public boolean updateCharacter(
            String oldName, Character updatedCharacter) {

        if (oldName == null || updatedCharacter == null) {
            return false;
        }

        int index = -1;

        for (int i = 0; i < characters.size(); i++) {
            if (characters.get(i).getName()
                    .equalsIgnoreCase(oldName.trim())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        // Tolak nama yang sudah digunakan karakter lain
        for (int i = 0; i < characters.size(); i++) {
            if (i != index
                    && characters.get(i).equals(updatedCharacter)) {
                return false;
            }
        }

        characters.set(index, updatedCharacter);
        return true;
    }
}