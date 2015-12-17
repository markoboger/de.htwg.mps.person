package de.htwg.mps.time;

public class JavaTime {

	private int hours;
	private int minutes;

	public JavaTime(int hours, int minutes) {
		this.hours = hours % 24 + minutes / 60;
		this.minutes = minutes % 60;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getAsMinutes() {
		return hours * 60 + minutes;
	}

	public void plus(JavaTime that) {
		int newMinutes = (this.minutes + that.minutes) % 60;
		int newHours = (this.hours + that.hours) % 24 + (this.minutes + that.minutes) / 60;
		this.minutes = newMinutes;
		this.hours = newHours;
	}

	public void minus(JavaTime that) {
		while (this.getAsMinutes() < that.getAsMinutes()) this.hours = this.hours + 24;
		int newMinutes = (this.getAsMinutes() - that.getAsMinutes()) % 60;
		int newHours = (this.getAsMinutes() - that.getAsMinutes()) / 60;
		this.minutes = newMinutes;
		this.hours = newHours;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaTime that = (JavaTime) obj;
		if (hours != that.hours)
			return false;
		if (minutes != that.minutes)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		return result;
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", hours, minutes);
	}
}
