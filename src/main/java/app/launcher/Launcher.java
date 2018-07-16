package app.launcher;

import app.heroes.SuperHero;

public class Launcher {

	public static void main (String[] args) {
		SuperHero hero = new SuperHero();
		
		System.out.println(hero.name);
	}
}
