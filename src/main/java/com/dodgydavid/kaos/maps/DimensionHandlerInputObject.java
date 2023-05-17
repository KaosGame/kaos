package com.dodgydavid.kaos.maps;

public class DimensionHandlerInputObject {
	
	private DimensionID id;
	private Dimension dim;
	
	public DimensionHandlerInputObject(DimensionID id, Dimension dim) {
		
		super();
		
		this.id = id;
		this.dim = dim;
		
		
	}

	public DimensionID getId() {
		return this.id;
	}

	public void setId(DimensionID id) {
		this.id = id;
	}

	public Dimension getDim() {
		return this.dim;
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}
	
	

}
