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
public class User {
    private final String name;
    
    public User(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
