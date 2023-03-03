package practice.day02;

public class Q2_Dto {

	private String 이름;
	private String 전화번호;
	private Double 키;
	private int 나이;
	private String 등록일;
	private String 성별;
	private boolean 개인정보동의;
	private String 지역;
	private String 자기소개;
	
	public Q2_Dto() {}

	public Q2_Dto(String 이름, String 전화번호, Double 키, int 나이, String 등록일, String 성별, boolean 개인정보동의, String 지역,
			String 자기소개) {
		super();
		this.이름 = 이름;
		this.전화번호 = 전화번호;
		this.키 = 키;
		this.나이 = 나이;
		this.등록일 = 등록일;
		this.성별 = 성별;
		this.개인정보동의 = 개인정보동의;
		this.지역 = 지역;
		this.자기소개 = 자기소개;
	}

	public String get이름() {
		return 이름;
	}

	public void set이름(String 이름) {
		this.이름 = 이름;
	}

	public String get전화번호() {
		return 전화번호;
	}

	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}

	public Double get키() {
		return 키;
	}

	public void set키(Double 키) {
		this.키 = 키;
	}

	public int get나이() {
		return 나이;
	}

	public void set나이(int 나이) {
		this.나이 = 나이;
	}

	public String get등록일() {
		return 등록일;
	}

	public void set등록일(String 등록일) {
		this.등록일 = 등록일;
	}

	public String get성별() {
		return 성별;
	}

	public void set성별(String 성별) {
		this.성별 = 성별;
	}

	public boolean is개인정보동의() {
		return 개인정보동의;
	}

	public void set개인정보동의(boolean 개인정보동의) {
		this.개인정보동의 = 개인정보동의;
	}

	public String get지역() {
		return 지역;
	}

	public void set지역(String 지역) {
		this.지역 = 지역;
	}

	public String get자기소개() {
		return 자기소개;
	}

	public void set자기소개(String 자기소개) {
		this.자기소개 = 자기소개;
	}
	
	
	
}
