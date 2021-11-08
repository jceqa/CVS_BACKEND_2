package py.com.cvs2.dto;

import java.io.Serializable;

public class TokenDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean ok;

	private String token;

	public TokenDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TokenDto(Boolean ok, String token) {
		super();
		this.ok = ok;
		this.token = token;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenDto [ok=" + ok + ", token=" + token + "]";
	}

}
