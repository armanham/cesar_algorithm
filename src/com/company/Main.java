package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String anyString = scanner.nextLine();
        System.out.println("Encrypt /1/");
        System.out.println("Decrypt /2/");
        int choose = scanner.nextInt();
        if (choose == 1) {
            System.out.print("Enter key: ");
            int shift = scanner.nextInt();
            System.out.println("Encrypted text: " + cesarEncrypt(anyString, shift));
        } else if (choose == 2) {
            System.out.print("Enter key: ");
            int shift = scanner.nextInt();
            System.out.println("Decrypted text: " + cesarDecrypt(anyString, shift));
        }
    }

    static String cesarEncrypt(String anyString, int shift) {
        String result = "";
        for (int i = 0; i < anyString.length(); i++) {
            if (Character.isUpperCase(anyString.charAt(i))) {
                char lettersOfWord = (char) (((int) anyString.charAt(i) + shift - 65) % 26 + 65);
                result += lettersOfWord;
            } else if (Character.isSpaceChar(anyString.charAt(i))) {
                result += " ";
            } else {
                char lettersOfWord = (char) (((int) anyString.charAt(i) + shift - 97) % 26 + 97);
                result += lettersOfWord;
            }
        }
        return result;
    }

    static String cesarDecrypt(String anyString, int shift) {
        String result = "";
        char ch;
        for (int i = 0; i < anyString.length(); ++i) {
            ch = anyString.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - shift);
                if (ch < 'a') {
                    ch = (char) (ch + 'z' - 'a' + 1);
                }
                result += ch;
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - shift);
                if (ch < 'A') {
                    ch = (char) (ch + 'Z' - 'A' + 1);
                }
                result += ch;
            } else {
                result += ch;
            }
        }
        return result;
    }
}


