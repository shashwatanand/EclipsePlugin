package de.shashwat.reply.challenges.model;

public enum CellRep {
	Mountain('#', "Mountain", Integer.MIN_VALUE),
	Water('~', "Water", 800),
	Traffic_jam('*', "Traffic_jam", 200),
	Dirt('+', "Dirt", 150),
	Railway_level_crossing('X', "Railway_level_crossing", 120),
	Standard_terrain('_', "Standard_terrain", 100),
	Highway('H', "Highway", 70),
	Railway('T', "Railway", 50);
	
	private char rep;
	private String meaning;
	private int cost;
	
	CellRep(char rep, String meaning, int cost){
        this.rep= rep;
        this.meaning = meaning;
        this.cost = cost;
    }

	/**
	 * @return the rep
	 */
	public char getRep() {
		return rep;
	}

	/**
	 * @return the meaning
	 */
	public String getMeaning() {
		return meaning;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
}
