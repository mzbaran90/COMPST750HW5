package CS251_HW5;

public abstract class Pokemon {
	
	//TODO
	/*
	 protected variables
	 */
	protected String name = "";
	protected int health;
	protected int power;
	protected int level;
	
	// superclass contructor
	public Pokemon(String name, int health, int power, int level) {
		this.name = name;
		setHealth(health);
		setPower(power);
		setLevel(level);
								
	}
// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 0) {
			return;
		}
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if(power < 0) {
			return;
		}
		this.power = power;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		if(level < 0) {
			return;
		}
		this.level = level;
	}
	
	public boolean isDefeated() {
		if(health <= 0) {
			return true;
		}
		return false;
	}
	protected void hurt(int damage) {
		if(damage <= 0 || this.isDefeated()) { // checks for positive damage and is still alive
			return;
		}
		else if(damage > getHealth()) {
			setHealth(0);
			
		}
		else {
			setHealth(getHealth() - damage);
		}
		
		
	}
	public abstract void specialAttack(Pokemon target);
	
	public abstract void physicalAttack(Pokemon target);
	
}