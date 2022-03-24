package com.game.maps;

import java.io.Serializable;
import java.util.HashMap;

import com.game.main.CloneableType;
import com.game.main.Game;

public class DimensionHandler implements Serializable, CloneableType<DimensionHandler> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7360133809072362915L;

	public DimensionID CURRENT_DIMENSION_ID;
	
	public HashMap<DimensionID, Dimension> dimensionHashMap;
	
	public DimensionHandler() {
		
		super();
		
		this.dimensionHashMap = new HashMap<DimensionID, Dimension>();
		this.CURRENT_DIMENSION_ID = DimensionID.HOME;
		
		DimensionHandlerInputObject dhio = new DimensionHandlerInputObject(DimensionID.HOME, new Dimension(DimensionID.HOME, Game.OBJECT_TEXTRA_ALICE.getImageFrom(0, 0, 16, 16)));
		
		this.add(dhio);
		
	
	}
	
	public DimensionHandler(DimensionHandlerInputObject... dims) {
		
		super();
		
		this.dimensionHashMap = new HashMap<DimensionID, Dimension>();
		
		for (int i = 0; i < dims.length; i++) {
			
			DimensionHandlerInputObject dhio = dims[i];
			
			this.dimensionHashMap.put(dhio.getId(), dhio.getDim());
			
		}
	
	}
	
	public void add(DimensionHandlerInputObject dim) {
		
		this.dimensionHashMap.put(dim.getId(), dim.getDim());
		
	}
	
	public void add(DimensionID did, Dimension dim) {
		
		this.dimensionHashMap.put(did, dim);
		
	}
	
	public void remove(DimensionID did) {
		
		this.dimensionHashMap.remove(did);
		
	}
	
	
	public Dimension get(DimensionID did) {
		
		return this.dimensionHashMap.get(did);
		
	}
	
	public Dimension currentDimension() {
		
		return this.get(this.CURRENT_DIMENSION_ID);
		
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

	public DimensionID getCURRENT_DIMENSION_ID() {
		return CURRENT_DIMENSION_ID;
	}

	public void setCURRENT_DIMENSION_ID(DimensionID cURRENT_DIMENSION_ID) {
		CURRENT_DIMENSION_ID = cURRENT_DIMENSION_ID;
	}

	public HashMap<DimensionID, Dimension> getDimensionHashMap() {
		return dimensionHashMap;
	}

	public void setDimensionHashMap(HashMap<DimensionID, Dimension> dimensionHashMap) {
		this.dimensionHashMap = dimensionHashMap;
	}

}
