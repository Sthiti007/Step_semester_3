package session7.assignment.p2;

public abstract class ArtPiece {
    private static int counter = 0;
    private final String pieceId;
    protected String title;

    public ArtPiece(String title) {
        this.title = title;
        this.pieceId = "PIECE-" + (++counter);
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}

public class Painting extends ArtPiece {
    public Painting(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

public class Sculpture extends ArtPiece {
    public Sculpture(String title) {
        super(title);
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}