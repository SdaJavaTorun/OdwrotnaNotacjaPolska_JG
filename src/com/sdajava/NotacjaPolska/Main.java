package com.sdajava.NotacjaPolska;

import java.util.*;

public class Main {

        char [] tab;
        char [] tabLiter = {};

        public Main(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Wpisz równanie ");
            String rownanie = sc.nextLine();
            sc.close();
            this.tab = rownanie.toCharArray();
        }

        public void zamiana(){
            Stack<Character> stos = new Stack<Character>();
            String odwRownanie = "";

                for (int i = 0; i < this.tab.length; i++){

                    if (Character.isDigit(this.tab[i]) || Character.isAlphabetic(this.tab[i])){
                        odwRownanie += tab[i];
                    }
                    else if (tab[i] == '(') {
                        stos.push(tab[i]);
                    }
                    else if (tab[i] == ')'){
                        if (stos.empty()){
                         }
                        else {
                            while (!stos.empty() && stos.peek() != '(' ) {
                                odwRownanie += stos.pop();
                            }
                        }
                    }
                    else if (tab[i] == '*' || tab[i] == '/' || tab[i] == '%'){
                        if (stos.empty()){
                            stos.push(tab[i]);
                        }
                        else if (stos.peek() == '+' || stos.peek() == '-' || stos.peek() == '(' || stos.peek() == ')'){
                            stos.push(tab[i]);
                        }
                    }
                    else if (tab[i] == '+' || tab[i] == '-'){
                        if (stos.empty()){
                            stos.push(tab[i]);
                        }
                        else if (stos.peek() == '*' || stos.peek() == '/' || stos.peek() == '%') {
                            while (!stos.empty() && stos.peek() != '(') {
                                odwRownanie += stos.pop();
                            }
                            stos.push(tab[i]);
                        }
                    }
                }
            System.out.println(odwRownanie);
        }


        public static void main(String[] args) {
        Main ONP = new Main();
            ONP.zamiana();

        }

    }