package CS251_HW5;

public class Charmander extends Pokemon {

	//TODO
	
	private final static int fireBall = 5;
	private final static int bite = 4;
	
	public Charmander(int health, int power, int level) {
		super("Charmander", health, power, level);
	}
	@Override
	public String toString() {
		return "[name = " + getName() + ", health = " + getHealth() + ", power = " + getPower() + ", level =  " 
	+ getLevel() + "]";
		
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this){
			return true;
		}
		if (other instanceof Pokemon) {
			Pokemon tempPoke = (Pokemon)other;
			return this.name.equals(tempPoke.name) && this.health == tempPoke.health && this.level == tempPoke.level 
					&& this.power == tempPoke.power;
			
			
		}
		return false;
		
	}
	
	/*************************************************
	* abstract methods overridden */
	//need further validation check for inputs,i.e. else or "try"?
	
	@Override
	public void specialAttack(Pokemon target) {
		if(!(this.isDefeated() || target.isDefeated())) {
			if(this.power >= fireBall) {
				target.hurt(fireBall);
				this.setPower(getPower() - fireBall);
			}
			else if(this.power < fireBall && power > 0) {
				int attack = this.getPower(); // temp variable for the adjusted special attack damage
				target.hurt(attack);
				this.setPower(0); // power is not depleted to zero. 
			}
			else if(power == 0) {
				physicalAttack(target);
			}
		}

	}
	
	@Override
	public void physicalAttack(Pokemon target) {
		if (this.isDefeated()){
			return;
			
		}
		target.hurt(bite);
		
		
	}
	
	
}
