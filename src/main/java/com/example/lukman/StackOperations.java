package com.example.lukman;

import java.util.ArrayList;
import java.util.List;

public class StackOperations {
	private List<Object> storage;

	public StackOperations() {
		// Inisialisasi stack dengan data yang diberikan
		storage = new ArrayList<>();
		storage.add(1);
		storage.add("{id: 1, value: \"obj\"}");
		storage.add("stringHolder");
		storage.add(46);
	}

	public List<Object> stack(String stackOperation, Object stackValue) {
		// Lakukan operasi stack sesuai dengan stackOperation
		switch (stackOperation) {
		case "push":
			// Jika operasi adalah push, tambahkan stackValue ke atas stack
			storage.add(stackValue);
			break;
		case "pop":
			// Jika operasi adalah pop, hapus elemen paling atas dari stack
			if (!storage.isEmpty()) {
				storage.remove(storage.size() - 1);
			}
			break;
		case "peek":
			// Jika operasi adalah peek, ambil elemen paling atas dari stack tanpa
			// menghapusnya
			List<Object> result = new ArrayList<>();
			if (!storage.isEmpty()) {
				result.add(storage.get(storage.size() - 1));
			}
			return result;
		case "swap":
			// Jika operasi adalah swap, tukar posisi dua elemen paling atas dari stack
			if (storage.size() >= 2) {
				int lastIndex = storage.size() - 1;
				Object topElement = storage.remove(lastIndex);
				Object secondTopElement = storage.remove(lastIndex - 1);
				storage.add(topElement);
				storage.add(secondTopElement);
			}
			break;
		default:
			System.out.println("Invalid stack operation");
		}

		// Kembalikan stack setelah operasi
		return storage;
	}

	public static void main(String[] args) {
		// Contoh penggunaan
		StackOperations stack = new StackOperations();
		System.out.println(stack.stack("push", "newElement")); // Menambahkan "newElement" ke atas stack
		System.out.println(stack.stack("pop",null)); // Menghapus elemen paling atas dari stack
		System.out.println(stack.stack("peek",null)); // Mengambil elemen paling atas tanpa menghapusnya
		System.out.println(stack.stack("swap",null)); // Menukar posisi dua elemen paling atas dari stack
	}
}
