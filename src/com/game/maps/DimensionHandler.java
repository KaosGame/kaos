package com.game.maps;

import java.io.Serializable;
import java.util.HashMap;

import com.game.main.CloneableType;

public class DimensionHandler implements Serializable, CloneableType<DimensionHandler> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7360133809072362915L;

	public DimensionID CURRENT_DIMENSION_ID;
	
	public HashMap<DimensionID, Dimension> dimensionHashMap;
	
	public DimensionHandler(DimensionHandlerInputObject... dims) {
		
		super();
		
		this.dimensionHashMap = new HashMap<DimensionID, Dimension>();
		
		for (int i = 0; i < dims.length; i++) {
			
			DimensionHandlerInputObject dhio = dims[i];
			
			this.dimensionHashMap.put(dhio.getId(), dhio.getDim());
			
		}
	
	}
	
	
	
	private DimensionHandler(DimensionID CURRENT_DIMENSION_ID, HashMap<DimensionID, Dimension> dimensionHashMap) {
		
		super();
		
		this.CURRENT_DIMENSION_ID = CURRENT_DIMENSION_ID;
		this.dimensionHashMap = dimensionHashMap;
		
		
	}



	@Override
	public DimensionHandler cloneType() {
		return new DimensionHandler(this.CURRENT_DIMENSION_ID, this.dimensionHashMap);
	}

}
