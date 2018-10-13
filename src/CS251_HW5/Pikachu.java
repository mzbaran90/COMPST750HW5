package CS251_HW5;


public class Pikachu extends Pokemon {

	//TODO
	
	//variables
	private static final int thunderBolt = 6;
	private static final int swipe =3;
	
	public Pikachu(int health, int power, int level) {
		super("Pikachu", health, power, level);
		
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
	
	@Override
	public void specialAttack(Pokemon target) {
		if (!(this.isDefeated() || target.isDefeated())) {
			

			if(this.power >= thunderBolt) {
				target.hurt(thunderBolt);
				this.setPower(getPower() - thunderBolt);
			}
			else if(this.power < thunderBolt && power > 0) {
				int attack = this.getPower(); // temp variable for the adjusted special attack damage
				target.hurt(attack);
				this.setPower(0); // power is not depleted to zero. 
			}
			else if(power == 0) {
				physicalAttack(target);
			}
			return;
		}

	}
	
	@Override
	public void physicalAttack(Pokemon target) {
		if(this.isDefeated()) {
			return;
		}
		target.hurt(swipe);
		
	}
	
}
