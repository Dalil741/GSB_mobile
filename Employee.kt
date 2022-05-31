package com.firebase.gsbapp

class Employee {
    var pseudo = ""
    var deplacement = 0
    var hotellerie = 0
    var restauration = 0
    var imprevu = 0
    constructor(pseudo:String,deplacement:Int,hotellerie:Int,restauration:Int,imprevu:Int) {
        this.pseudo = pseudo
        this.deplacement = deplacement
        this.hotellerie = hotellerie
        this.restauration = restauration
        this.imprevu = imprevu

    }


}
