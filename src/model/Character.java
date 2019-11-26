package model;

import java.io.Serializable;

import dataStructure.Vertex;

public class Character implements Serializable{
	
	public static final double LIGHTING_INTERVAL = 15.0;
	
	private Vertex position;
	private boolean ilumination;
	
	public Character(Vertex position, boolean ilumination) {
		this.position = position;
		this.ilumination = ilumination;
	}
	
	public boolean canUseIlumination() {
		return this.ilumination;
	}
	
	public Vertex getPosition() {
		return this.position;
	}

	public void setIlumination(boolean ilumination) {
		this.ilumination = ilumination;
	}

	public void setPosition(Vertex position) {
		this.position = position;
	}

}
