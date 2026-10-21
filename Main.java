package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        System.out.println("=== CHARACTER MANAGER ===");

        // 1. Menambahkan karakter
        Character c1 = new Character(
            "Siti", CharacterType.HEALER, 2
        );

        Character c2 = new Character(
            "Budi", CharacterType.WARRIOR, 5
        );

        System.out.println(
            "Tambah Siti: " + manager.addCharacter(c1)
        );

        System.out.println(
            "Tambah Budi: " + manager.addCharacter(c2)
        );

        // 2. Menguji duplikat
        Character duplicate = new Character(
            "siti", CharacterType.MAGE, 9
        );

        System.out.println(
            "Tambah duplikat Siti: "
            + manager.addCharacter(duplicate)
        );

        // 3. Mencari karakter
        System.out.println("\nCari Siti:");
        System.out.println(manager.findCharacter("Siti"));

        // 4. Menampilkan seluruh karakter
        System.out.println("\nDaftar karakter:");
        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        // 5. Mengubah karakter
        Character updated = new Character(
            "Siti", CharacterType.MAGE, 3, 50, 130
        );

        System.out.println(
            "\nUpdate Siti: "
            + manager.updateCharacter("Siti", updated)
        );

        System.out.println(manager.findCharacter("Siti"));

        // 6. Menghapus karakter
        System.out.println(
            "\nHapus Budi: " + manager.removeCharacter("Budi")
        );

        // 7. Menghitung karakter
        System.out.println(
            "Total karakter: " + manager.getTotalCharacters()
        );
    }
}
