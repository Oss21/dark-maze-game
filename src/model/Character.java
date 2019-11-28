package model;

import java.io.Serializable;

import dataStructure.Vertex;

/**
 * Represents the hiker.
 */
public class Character implements Serializable{
	
	/**
	 * It is the interval in which the flashlight is turned on.
	 */
	public static final double LIGHTING_INTERVAL = 15.0;
	
	/**
	 * It is the path on which the character is located.
	 */
	private Vertex position;
	
	/**
	 * Indicates if the flashlight is on or not.
	 */
	private boolean ilumination;
	
	/**
	 * Create a character.
	 * @param position -  It is the path on which the character is located.
	 * @param ilumination - Indicates if the flashlight is on or not.
	 */
	public Character() {
		this.position = null;
		this.ilumination = false;
	}
	
	/**
	 * Indicates if you can use the flashlight or not.
	 * @return Indicates true or false.
	 */
	public boolean canUseIlumination() {
		return this.ilumination;
	}
	
	/**
	 * Returns the path on which the character is located.
	 * @return position - The path.
	 */
	public Vertex getPosition() {
		return this.position;
	}

	/**
	 * Change whether the flashlight can be turned on or not.
	 * @param ilumination - Is the new value.
	 */
	public void setIlumination(boolean ilumination) {
		this.ilumination = ilumination;
	}

	/**
	 * Change the path on which the character is located.
	 * @param position
	 */
	public void setPosition(Vertex position) {
		this.position = position;
	}

}
