package test1;

public class User implements Cloneable{
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public int id;
	
	String name;
	Teacher t;
	public User clone() throws CloneNotSupportedException{
	 User clone = (User)super.clone();
	 	return clone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", t=" + t + "]";
	}
	
}
