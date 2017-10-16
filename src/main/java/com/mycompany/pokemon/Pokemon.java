/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pokemon;

/**
 *
 * @author marconte
 */
public class Pokemon{
    private String name;
    private int pv;
    int level;
    String type;
    Attack[] attacks;
    
    public Pokemon(String name, int pv, int level, String type, Attack[] attacks) {
        this.name = name;
        this.pv = pv;
        this.level = level;
        this.type = type;
        this.attacks = attacks;
    }
    
    public String getName(){
        return this.name;
    }
    public int getPv(){
        return this.pv;
    }

}
