package entity;

public class CharacterName {
	private long characterNameId;
	private String firstName;
	private String lastName;
	
	public CharacterName(long characterNameId, String firstName, String lastName) {
		this.characterNameId =characterNameId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public long getCharacterNameId() {
		return characterNameId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "CharacterName [characterNameId=" + characterNameId + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}		
	
	
}
