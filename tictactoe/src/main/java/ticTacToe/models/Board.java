package ticTacToe.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ticTacToe.utils.Direction;

class Board extends Subject implements Serializable {

	private Map<Color, Set<Coordinate>> coordinates;
	
	private boolean existTicTacToe;

    private Color winner = Color.NONE;

	Board(int numPlayers) {
		assert numPlayers > 0;
		coordinates = new HashMap<>();
		for (int i = 0; i < numPlayers; i++) {
			coordinates.put(Color.values()[i], new HashSet<>());
		}
		existTicTacToe = false;
	}

	Color getColor(Coordinate coordinate) {
		assert coordinate != null;
		for (Color color : coordinates.keySet()) {
			if (coordinates.get(color).contains(coordinate)) {
				return color;
			}
		}
		return Color.NONE;
	}

	boolean complete() {
		int contTokens = 0;
		for (Color color : coordinates.keySet()) {
			contTokens += coordinates.get(color).size();
		}
		return contTokens == Coordinate.DIMENSION
				* Coordinate.DIMENSION;
	}

	boolean existTicTacToe() {
		return existTicTacToe;
	}

	private boolean existTicTacToe(Color color) {
		assert color != Color.NONE;
		Set<Coordinate> coordinateSet = coordinates.get(color);
		if (coordinateSet.size() < Coordinate.DIMENSION) {
			return false;
		}
		Coordinate[] coordinateArray = coordinateSet.toArray(new Coordinate[0]);
		for (int i = 0; i < coordinateSet.size()-2; i++){
			for (int j = i + 1; j < coordinateSet.size()-1; j++) {
				Direction direction = coordinateArray[i].direction(coordinateArray[j]);
				if (direction != Direction.NON_EXISTENT) {
                    for (int k = j+1; k < coordinateSet.size(); k++) {
                        Direction subDirection = coordinateArray[j].direction(coordinateArray[k]);
                        if (direction == subDirection) {
                            return true;
                        }
                    }
                }
			}
		}
		return false;
	}

	boolean empty(Coordinate coordinate) {
		assert coordinate != null;
		return !this.full(coordinate, Color.XS)
				&& !this.full(coordinate, Color.OS);
	}

	void put(Coordinate coordinate, Color color) {
        if (existTicTacToe) {
            this.end();
        }

		if (coordinate == null)
            return;
		assert color != Color.NONE;
		assert color != null;
        coordinates.get(color).add(coordinate.clone());
        existTicTacToe = this.existTicTacToe(color);
        if (existTicTacToe) {
            winner = color;
            this.end();
        }else if (this.complete()){
            winner = Color.NONE;
            this.end();
        }
    }

	void remove(Coordinate coordinate, Color color) {
		assert coordinate != null;
		assert color != Color.NONE;
		coordinates.get(color).remove(coordinate);
	}

	boolean full(Coordinate coordinate, Color color) {
		assert coordinate != null;
		assert color != Color.NONE;
		return coordinates.get(color).contains(coordinate);
	}

	void clear() {
		for (Color color : coordinates.keySet()) {
			coordinates.get(color).clear();
		}
		existTicTacToe = false;
	}
	
	public List<Coordinate> emptyCoordinates() {
		List<Coordinate> emptyCoordinates = new ArrayList<Coordinate>(); 
		for(int i=0; i< Coordinate.DIMENSION; i++){
			for(int j=0; j<Coordinate.DIMENSION; j++){
				Coordinate coordinate = new Coordinate(i,j);
				if (this.getColor(coordinate) == Color.NONE){
					emptyCoordinates.add(coordinate);
				}
			}
		}
		return emptyCoordinates;
	}
	
	public List<Coordinate> playerCoordinates(Color color) {
		List<Coordinate> playerCoordinates = new ArrayList<Coordinate>(); 
		for(int i=0; i< Coordinate.DIMENSION; i++){
			for(int j=0; j<Coordinate.DIMENSION; j++){
				Coordinate coordinate = new Coordinate(i,j);
				if (this.getColor(coordinate)== color){
					playerCoordinates.add(coordinate);
				}
			}
		}
		return playerCoordinates;
	}

    public Color getWinner() {
        return this.winner;
    }

}
