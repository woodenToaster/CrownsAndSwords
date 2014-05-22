
public class Player {

	private String playedBy;
	private Sword[] swords;
	private Crown crown;
	private Boolean active;
	
	public Player(String s) {
		playedBy = s;
		active = false;
		swords = new Sword[4];
		for(int i = 0; i < 4; i++) {
			swords[i] = new Sword(i + 1, playedBy);
		}
		crown = new Crown(playedBy);
	}
	
	void submitMove(Piece piece, int x, int y) {
		//TODO: implement this mug
	}
	public Sword[] getSwords() {return swords;}
	
}
