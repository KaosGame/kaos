package com.github.kaosgame.kaos.saving;

import java.io.Serializable;

public class GameVersion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2425698296665208603L;
	
	private String version;
	
	public GameVersion(String version) {
		
		this.version = version;
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameVersion other = (GameVersion) obj;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameVersion [version=" + version + "]";
	}
	
	

}
