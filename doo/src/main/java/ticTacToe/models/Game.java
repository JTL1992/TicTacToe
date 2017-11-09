package ticTacToe.models;

import ticTacToe.utils.IO;

import java.io.*;
import java.util.List;

public class Game implements Serializable {

    private Turn turn;

    private Board board;

    private static final int NUM_PLAYERS = 2;

    public Game(Observer observer) {
        turn = new Turn();
        board = new Board(Game.NUM_PLAYERS);
        board.register(observer);
    }

    private Game() {
    }

    public Color take() {
        return turn.take();
    }

    public void change() {
        turn.change();
    }

    public boolean full(Coordinate origin) {
        return board.full(origin, turn.take());
    }

    public boolean empty(Coordinate target) {
        return board.empty(target);
    }

    public boolean complete() {
        return board.complete();
    }

    public int getNumPlayers() {
        return NUM_PLAYERS;
    }

    public void put(Coordinate target) {
        board.put(target, turn.take());
    }

    public void remove(Coordinate origin) {
        board.remove(origin, turn.take());
    }

    public void clear() {
        board.clear();
    }

    public boolean existTicTacToe() {
        return board.existTicTacToe();
    }

    public Color getColor(Coordinate coordinate) {
        return board.getColor(coordinate);
    }

    public List<Coordinate> emptyCoordinates() {
        return board.emptyCoordinates();
    }

    public List<Coordinate> playerCoordinates() {
        return board.playerCoordinates(turn.take());
    }

    public Game deepClone() {
        try {
            //write object to stream
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream oos  = new ObjectOutputStream(bao);
            oos.writeObject(this);
            //read object from stream
            ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Game) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
